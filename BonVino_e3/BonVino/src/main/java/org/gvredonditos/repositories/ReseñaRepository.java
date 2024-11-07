package org.gvredonditos.repositories;

import org.gvredonditos.modelo.Reseña;
import org.hibernate.Session;

import java.util.List;

public class ReseñaRepository extends Repository{
    public ReseñaRepository() {}
    public ReseñaRepository(org.hibernate.SessionFactory sessionFactory) {}

    public List<Reseña> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Reseña", Reseña.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
