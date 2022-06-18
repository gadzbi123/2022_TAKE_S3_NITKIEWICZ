package pl.polsl.autobusy.operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseOperations<TEntity> implements AutoCloseable {

    EntityManagerFactory managerFactory;
    EntityManager manager;

    Class<TEntity> type;

    public DatabaseOperations(Class<TEntity> type) {
        this.type = type;

        managerFactory = Persistence.createEntityManagerFactory("autobusy");
        manager = managerFactory.createEntityManager();
    }

    public TEntity get(int id) {
        return manager.find(type, id);
    }

    public void update(TEntity entity) {
        manager.merge(entity);
    }

    public void insert(TEntity entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    public void delete(int id) {
        manager.remove(get(id));
    }

    @Override
    public void close() {
        manager.close();
        managerFactory.close();
    }
}
