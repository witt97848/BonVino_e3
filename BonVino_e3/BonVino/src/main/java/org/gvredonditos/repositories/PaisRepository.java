package org.gvredonditos.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.gvredonditos.modelo.Pais;
import java.util.List;

public class PaisRepository extends Repository{

    public List<Pais> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Pais", Pais.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PaisRepository() {}
    public PaisRepository(SessionFactory sessionFactory) {}
}
