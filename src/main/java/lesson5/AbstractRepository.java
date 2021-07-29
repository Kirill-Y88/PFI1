package lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public abstract class   AbstractRepository<T> {
    protected static SessionFactory factory;
    protected final Class<T>  thisclass;

    public abstract void applyScript();

    public void shutdown() {
        factory.close();
    }

    public AbstractRepository(Class<T>  thisclass) {
        this.thisclass = thisclass;
    }

    public <T> void create(T t) {
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        }
    }


    public <T> T read(String name) {
        T t;
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            String query = String.format("SELECT s from %s s where s.name = '%s'",thisclass.getSimpleName(), name);
            t = (T) session.createQuery(query).getResultList().get(0);
            System.out.println(t.toString());
            session.getTransaction().commit();
        }
        return t;
    }

    public <T> void delete(String name) {
        T t;
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            String query = String.format("SELECT s from %s s where s.name = '%s'",thisclass.getSimpleName(), name);
            t = (T) session.createQuery(query).getResultList().get(0);
            session.delete(t);
            session.getTransaction().commit();
        }
    }

    public <T> void readAll(){
        T t;
        try(Session session = factory.getCurrentSession()){
            session.beginTransaction();
            String query = String.format("SELECT s from %s s ",thisclass.getSimpleName());
            List<T> ts = session.createQuery(query).getResultList();
            for (T t1: ts ) {
                System.out.println(t1 + "\n");
            }
            session.getTransaction().commit();
        }
    }

}
