package lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepository {
    private static SessionFactory factory;


    public static void applyScript(){
        factory = new Configuration()
                .configure("hibernate_students.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("script5.sql")).collect(Collectors.joining(" "));
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void shutdown() {
        factory.close();
    }



    public static void create(String name, int mark) {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Student student = new Student(name, mark);
            session.save(student);
            session.getTransaction().commit();
        }
    }


    public static Student read(String name) {
        Student student;
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            String query = String.format("SELECT s from Student s where s.name = '%s'", name);
            student = (Student) session.createQuery(query).getResultList().get(0);
            System.out.println(student.toString());
            session.getTransaction().commit();
        }
        return student;
    }

    public static void delete(String name) {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            String query = String.format("SELECT s from Student s where s.name = '%s'", name);
            Student student = (Student) session.createQuery(query).getResultList().get(0);
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    public static void readAll(){
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            List<Student> students = session.createQuery("select a from Student a ").getResultList();
            for (Student s: students  ) {
                System.out.println(s + "\n");
            }
            session.getTransaction().commit();
        }
    }

}
