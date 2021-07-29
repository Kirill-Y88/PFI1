package lesson5;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class StudentRepo <S> extends AbstractRepository{


    public StudentRepo(Class thisclass) {
        super(thisclass);
    }

    @Override
    public void applyScript() {
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

    @Override
    public void shutdown() {
        super.shutdown();
    }

    @Override
    public void create(Object o) {
        super.create(o);
    }

    @Override
    public Object read(String name) {
        return super.read(name);
    }

    @Override
    public void delete(String name) {
        super.delete(name);
    }

    @Override
    public void readAll() {
        super.readAll();
    }
}
