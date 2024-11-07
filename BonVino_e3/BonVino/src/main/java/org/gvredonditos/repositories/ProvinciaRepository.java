package org.gvredonditos.repositories;

import org.gvredonditos.modelo.Provincia;
import org.gvredonditos.repositories.Repository;
import org.hibernate.Session;
import java.util.List;

public class ProvinciaRepository extends Repository{
    public List<Provincia> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Provincia", Provincia.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProvinciaRepository() {}
    public ProvinciaRepository(org.hibernate.SessionFactory sessionFactory) {}

}
