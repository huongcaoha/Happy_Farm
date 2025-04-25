package com.example.demo.model.dao;

import com.example.demo.model.entity.Land;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class LandDao implements IDao<Land>{
   @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Land> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Land ", Land.class).getResultList();
    }

    @Override
    public Land findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Land.class,id);
    }

    @Override
    public int insert(Land land) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(land);
            return land.getId();
        }catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int update(Land land) {
       Session session = sessionFactory.getCurrentSession();
       try {
           session.merge(land);
           return land.getId();
       }catch (Exception e) {
           return -1 ;
       }
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Land land = session.get(Land.class,id);
        if(land!=null){
           try {
               session.createQuery("update Land set status = false where id=:id", Land.class)
                       .setParameter("id", id)
                       .executeUpdate();
               return land.getId();
           }catch (Exception e) {
               return -1 ;
           }
        }else {
            return 0 ;
        }
    }
}
