package pl.sda.database;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionProvider {

    private SessionProvider(){}

    public static Session getSession() {
        return new Configuration().configure().buildSessionFactory().openSession();
    }
}
