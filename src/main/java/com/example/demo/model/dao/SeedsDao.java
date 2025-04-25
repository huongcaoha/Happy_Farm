package com.example.demo.model.dao;

import com.example.demo.model.entity.Seeds;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SeedsDao implements IDao<Seeds> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Seeds> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Seeds", Seeds.class).getResultList();
    }

    @Override
    public Seeds findById(int id) {
      Session session = sessionFactory.getCurrentSession();
      return session.get(Seeds.class, id);
    }

    @Override
    public int insert(Seeds seeds) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(seeds);
            return seeds.getId();
        }catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int update(Seeds seeds) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(seeds);
            return seeds.getId();
        } catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Seeds seeds = session.get(Seeds.class, id);
        if (seeds != null) {
            try {
                session.createQuery("update Seeds where id=:id", Seeds.class)
                        .setParameter("id", id)
                        .executeUpdate();
                return seeds.getId();
            } catch (Exception e) {
                return -1 ;
            }
        }else {
            return 0 ;
        }
    }
}
