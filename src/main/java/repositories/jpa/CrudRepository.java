package repositories.jpa;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public abstract class CrudRepository <T> {
    // Generic: Java 2 Slide 7-8
    private Session hSession;

    public abstract String getClassName();
    public abstract Class<T> getClassType();

    public CrudRepository()
    {
        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void create(T entity)
    {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.persist(entity);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }

    public void update(T entity)
    {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.merge(entity);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }

    public void delete(T entity)
    {
        Transaction t = this.hSession.getTransaction();
        try {
            t.begin();
            this.hSession.remove(entity);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
        }
    }

    public List<T> findAll()
    {
        String jpql = "SELECT entity FROM " + this.getClassName() + " entity";
        Query q = this.hSession.createQuery(jpql, this.getClassType());
        return q.getResultList();
    }

    public T findByID(int id)
    {
        return this.hSession.find(this.getClassType(), id);
    }
}
