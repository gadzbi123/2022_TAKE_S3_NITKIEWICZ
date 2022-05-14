package pl.polsl.autobusy;

import pl.polsl.autobusy.entities.Autobus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("autobusy");
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();

        Autobus autobus = new Autobus();
        autobus.setNumer(5);
        autobus.setNumerRejestracyjny("K1-DIS");
        autobus.setCzySprawny(true);

        manager.persist(autobus);

        manager.getTransaction().commit();
        manager.close();
        managerFactory.close();
    }
}