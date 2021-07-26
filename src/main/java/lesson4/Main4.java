package lesson4;

public class Main4 {
    public static void main(String[] args) {
        SqlHandler sqlHandler = new SqlHandler();

        sqlHandler.connect();
        sqlHandler.applyScript();

        System.out.println("-----------");
        sqlHandler.viewMistake();
        sqlHandler.viewBreak(0);

        sqlHandler.disconnect();


    }
}
