package com.example.demo.model.dao;

import com.example.demo.model.entity.UserLand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserLandDao implements IDao<UserLand> {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UserLand> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserLand", UserLand.class).getResultList();
    }

    @Override
    public UserLand findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserLand.class, id);
    }

    @Override
    public int insert(UserLand userLand) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(userLand);
            return  userLand.getId();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int update(UserLand userLand) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(userLand);
            return  userLand.getId();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public int delete(int id) {
    Session session = sessionFactory.getCurrentSession();
    UserLand userLand = findById(id);
    if(userLand != null) {
        try {
            session.createQuery("update UserLand set status=false where id=:id", UserLand.class)
                    .setParameter("id", id)
                    .executeUpdate();
            return  userLand.getId();
        } catch (Exception e) {
            return -1;
        }
    }else {
        return 0;
    }
    }
}
