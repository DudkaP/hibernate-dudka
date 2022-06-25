package lesson1.hw_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.Serializable;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(new Owner("Petya",new Car("KIA", Type.SEDAN, 34, 2000, 1999)));
        session.save(new Owner("Olya",new Car("Ford", Type.HATCHBACK, 43,1230,1987)));
        session.save(new Owner("Kolya",new Car("Oka", Type.SEDAN, 11,7540,1965)));
        session.save(new Owner("Max",new Car("ZAZ", Type.UNIVERSAL, 76,4540,1998)));
        session.save(new Owner("Pasha",new Car("Mers", Type.HATCHBACK, 23,340,2010)));
        session.getTransaction().commit();

        List<Owner> ownerList = session.createQuery("select o from Owner o", Owner.class).getResultList();
        System.out.println(ownerList);

        List<Car> carList = session.createQuery("select o.car from Owner o", Car.class).getResultList();
        System.out.println(carList);

        session.close();
        sessionFactory.close();
    }
}
