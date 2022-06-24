package lesson1.hw_1;

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
                .addAnnotatedClass(Word.class)
                .getMetadataBuilder()
                .build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();
        Session session = sessionFactory.openSession();

//        session.beginTransaction();
//        session.save(new Word("First word"));
//        session.save(new Word("Second word"));
//        session.save(new Word("Third word"));
//        session.save(new Word("Forth word"));
//        session.save(new Word("Fifth word"));
//        session.save(new Word("Sixth word"));
//        session.save(new Word("Seventh word"));
//        session.save(new Word("Eighth word"));
//        session.save(new Word("Ninth word"));
//        session.save(new Word("Tenth word"));
//        session.getTransaction().commit();
        List<Word> words = session.createQuery("select w from Word w", Word.class).getResultList();
        System.out.println(words);

        session.close();
        sessionFactory.close();
    }
}
