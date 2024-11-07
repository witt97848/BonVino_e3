package org.gvredonditos.repositories;


import org.gvredonditos.modelo.TipoUva;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TipoUvaRepository extends Repository{
    public TipoUvaRepository() {}
    public TipoUvaRepository(SessionFactory sessionFactory) {}

    public List<TipoUva> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from TipoUva", TipoUva.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
