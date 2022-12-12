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

        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml.tld")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Cars.class)
                        .addAnnotatedClass(Drivers.class)
                        .addAnnotatedClass(License.class)
                        .addAnnotatedClass(Salon.class)
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        session.beginTransaction();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        session.save(new Salon("Lincoln 45 street",Arrays.asList(new Cars(
                "KA4545", "BMW X7", Availability.YES,Arrays.asList(new Drivers(
                        "Max","Johnson",new License("00842188421"),Arrays.asList())
        ))
        )));

        session.save(new Salon("Lincoln 45 street",Arrays.asList(new Cars(
                        "BK5543", "Skoda Fabia", Availability.NO, Arrays.asList(new Drivers(
                        "Rick","Ablazovenko",new License("0084838421"),Arrays.asList())
                ))
        )));

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        session.close();
        sessionFactory.close();
    }
}