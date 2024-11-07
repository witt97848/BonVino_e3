package org.gvredonditos.repositories;

import org.gvredonditos.modelo.Vino;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class VinoRepository extends Repository{
    public VinoRepository() {}
    public VinoRepository(SessionFactory sessionFactory) {}

    public List<Vino> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from Vino", Vino.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
