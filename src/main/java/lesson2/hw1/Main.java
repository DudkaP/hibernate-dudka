package lesson2.hw1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriveLicense.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Owner("Petya", Arrays.asList(
                new Car("ZAZ", Type.SEDAN, 220, 2000, 1980),
                new Car("VAZ", Type.HATCHBACK, 232, 3242, 1990)),
                new DriveLicense(123456789)));
        session.save(new Owner("Olya", Arrays.asList(
                new Car("Mers", Type.SEDAN, 543, 786, 1983),
                new Car("KIA", Type.HATCHBACK, 245, 5443, 1995)),
                new DriveLicense(987654321)));
        session.getTransaction().commit();

        System.out.println("------------------------------");
        List<Owner> owners = session.createQuery("select o from Owner o", Owner.class).getResultList();
        owners.forEach(System.out::println);
        System.out.println("------------------------------");
        List<Car> carsList = session.createQuery("select c from Car c", Car.class).getResultList();
        carsList.forEach(System.out::println);
        System.out.println("------------------------------");
        List<DriveLicense> driveLicenses = session.createQuery("select l from DriveLicense l", DriveLicense.class).getResultList();
        driveLicenses.forEach(System.out::println);
        System.out.println("------------------------------");

        session.close();
        sessionFactory.close();
    }
}
