package lesson4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class SqlHandler {
    private Connection connection = null;
    private Statement statement = null;

    public  void connect(){
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test","admin","12345");
            statement = connection.createStatement();
            System.out.println("Connect H2");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            statement.close();
            connection.close();
            System.out.println("Disconnect H2");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void applyScript(){
        try {
            //statement=connection.createStatement();
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            System.out.println(sql);
        statement.executeUpdate(sql);
            System.out.println("Script applied");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void readAll(){
    try(ResultSet rs = statement.executeQuery("select * from films join timetable on films.id = timetable.id_film ORDER BY timetable.start_time")) {
        while (rs.next()){
            System.out.printf("id =%d, name=%s, bued_tickets = %d, time = %tT ,duration =%d  \n",
                    rs.getInt("id"),rs.getString("name"),rs.getInt("bued_tickets"),rs.getTime("start_time"),rs.getInt("duration"));
        }
    } catch (Exception e){
        e.printStackTrace();
    }
    }

    public void readByName(String name){
        String query = String.format("select * from films join timetable on films.id = timetable.id_film WHERE name = '%s'  ORDER BY timetable.start_time", name);
        try(ResultSet rs = statement.executeQuery(query)){
            while (rs.next()){
                System.out.printf("name = %s, time = %tT, duration = %d \n", rs.getString("name"), rs.getTimestamp("start_time"), rs.getInt("duration"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewMistake(){
        String name = "";
        String nameTemp;
        LocalDateTime dataTime = LocalDateTime.of(2000,01,01,01,01);
        int duration = 0;
        int durationTemp;

        try(ResultSet rs = statement.executeQuery("select * from films join timetable on films.id = timetable.id_film ORDER BY timetable.start_time")) {
            while (rs.next()){
                nameTemp = rs.getString("name");
                durationTemp = rs.getInt("duration");
                dataTime = dataTime.plusMinutes(duration);
                if(dataTime != null && dataTime.isAfter((rs.getTimestamp("start_time")).toLocalDateTime())){
                    System.out.printf("name=%s, time = %tT ,duration =%d  \n",
                            name,dataTime.minusMinutes(duration),duration);
                    System.out.printf("name=%s, time = %tT ,duration =%d  \n",
                            nameTemp,rs.getTimestamp("start_time"),durationTemp);
                }
                name = nameTemp;
                duration = durationTemp;
                dataTime = (rs.getTimestamp("start_time")).toLocalDateTime();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void viewBreak(int pause){
        List<Film> films = new ArrayList<>();
        int index = 0;
        try(ResultSet rs = statement.executeQuery("select * from films join timetable on films.id = timetable.id_film ORDER BY timetable.start_time")) {

            while (rs.next()){
                films.add(new Film(rs.getString("name"),
                        (rs.getTimestamp("start_time")).toLocalDateTime(),
                        rs.getInt("duration"),
                        rs.getInt("price"),
                        rs.getInt("bued_tickets")));
                if(index > 0) {
                    films.get(index-1).setDurationBreak((Duration.between(films.get(index).getDataTimeStart(),films.get(index-1).getDataTimeEnd())).toMinutesPart());
                }
                index++;
            }
            Collections.sort(films,new FilmCompareDurationBreak());
            for ( Film f : films ) {
                if(f.getDurationBreak() >= pause){
                    System.out.println("name = " + f.getName() + " timeStart = " + f.getDataTimeStart() + " durationBreak = " + f.getDurationBreak());
                }
            }
        }catch  (Exception e){
            e.printStackTrace();
        }
    }



}
