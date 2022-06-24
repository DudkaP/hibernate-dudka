package lesson1.hw_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Car("KIA", Type.HATCHBACK, 34, 2000, 1999));
        session.save(new Owner("Petya");


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
