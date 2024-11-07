package org.gvredonditos.repositories;

import org.gvredonditos.modelo.Varietal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class VarietalRepository extends Repository{
    public VarietalRepository() {}
    public VarietalRepository(SessionFactory sessionFactory) {}

    public List<Varietal> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Varietal", Varietal.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
