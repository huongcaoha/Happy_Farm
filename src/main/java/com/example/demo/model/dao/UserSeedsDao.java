package com.example.demo.model.dao;

import com.example.demo.model.entity.UserSeeds;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserSeedsDao implements IDao<UserSeeds> {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<UserSeeds> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserSeeds", UserSeeds.class).getResultList();
    }

    @Override
    public UserSeeds findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserSeeds.class, id);
    }

    @Override
    public int insert(UserSeeds userSeeds) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(userSeeds);
            return userSeeds.getId();
        } catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int update(UserSeeds userSeeds) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(userSeeds);
            return userSeeds.getId();
        } catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        UserSeeds userSeeds = findById(id);
        if (userSeeds != null) {
            try {
                session.createQuery("update UserSeeds set status = false where id = :id", UserSeeds.class)
                        .setParameter("id", id)
                        .executeUpdate();
                return userSeeds.getId();
            } catch (Exception e) {
                return -1 ;
            }
        }else {
            return 0;
        }
    }
}
