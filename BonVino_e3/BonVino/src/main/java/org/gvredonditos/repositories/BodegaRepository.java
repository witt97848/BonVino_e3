package org.gvredonditos.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.gvredonditos.modelo.Bodega;
import java.util.List;

public class BodegaRepository extends Repository{

    public List<Bodega> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Bodega", Bodega.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BodegaRepository() {}
    public BodegaRepository(SessionFactory sessionFactory) {}
}
