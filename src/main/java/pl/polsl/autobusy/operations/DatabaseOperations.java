package pl.polsl.autobusy.operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    public List<TEntity> getAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<TEntity> cq = cb.createQuery(type);
        Root<TEntity> rootEntry = cq.from(type);
        CriteriaQuery<TEntity> all = cq.select(rootEntry);
        TypedQuery<TEntity> allQuery = manager.createQuery(all);

        return allQuery.getResultList();
    }

    public void update(TEntity entity) {
        manager.getTransaction().begin();
        manager.merge(entity);
        manager.getTransaction().commit();
    }

    public void insert(TEntity entity) {
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }

    public void delete(int id) {
        manager.getTransaction().begin();
        manager.remove(get(id));
        manager.getTransaction().commit();
    }

    @Override
    public void close() {
        manager.close();
        managerFactory.close();
    }
}
