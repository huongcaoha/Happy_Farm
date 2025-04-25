package com.example.demo.model.dao;

import com.example.demo.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao implements IDao<User> , IAuth {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User login(String username, String password) {
        Session session = sessionFactory.getCurrentSession();
       return session.createQuery("from User where username = :username and password = :password and status = true", User.class)
                .setParameter("username", username)
                .setParameter("password", password).uniqueResult();
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public int insert(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.persist(user);
            return user.getId();
        } catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int update(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.merge(user);
            return user.getId();
        } catch (Exception e) {
            return -1 ;
        }
    }

    @Override
    public int delete(int id) {
        User user = findById(id);
        if(user != null) {
            Session session = sessionFactory.getCurrentSession();
            try {
                session.createQuery("update User set status = false where id = :id", User.class)
                        .setParameter("id", id)
                        .executeUpdate();
                       return  user.getId();
            } catch (Exception e) {
                return -1 ;
            }
        }else {
            return 0 ;
        }
    }
}
