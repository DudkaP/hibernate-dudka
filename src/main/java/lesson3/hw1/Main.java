package lesson3.hw1;

import lesson3.hw1.company.DeputyDirector;
import lesson3.hw1.company.Director;
import lesson3.hw1.company.Employers;
import lesson3.hw1.company.Owner;
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
                .addAnnotatedClass(Director.class)
                .addAnnotatedClass(DeputyDirector.class)
                .addAnnotatedClass(Employers.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
