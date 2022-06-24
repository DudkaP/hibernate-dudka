package lesson1.cw_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        session.save(new User("Vasya"));
//        session.save(new User("Sasha"));
//        session.save(new User("Olya"));
//
//
//        session.getTransaction().commit();

//        List<User> resultList = session.createNativeQuery("select * from user", User.class).getResultList();
        List<User> resultList = session.createQuery("select u from User u", User.class).getResultList();
        System.out.println(resultList);

        session.close();
        sessionFactory.close();
    }
}
