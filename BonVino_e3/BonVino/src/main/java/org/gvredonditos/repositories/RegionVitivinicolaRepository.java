package org.gvredonditos.repositories;

import org.gvredonditos.modelo.RegionVitivinicola;
import org.hibernate.Session;

import java.util.List;

public class RegionVitivinicolaRepository extends Repository{

    public RegionVitivinicolaRepository() {}
    public RegionVitivinicolaRepository(org.hibernate.SessionFactory sessionFactory) {}

    public List<RegionVitivinicola> findAll(){
        try (Session session = this.sessionFactory.openSession()) {
            return session.createQuery("from RegionVitivinicola", RegionVitivinicola.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
