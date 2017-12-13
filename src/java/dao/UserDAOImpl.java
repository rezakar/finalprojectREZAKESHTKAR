/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hamid
 */
@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionfactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionfactory = sf;
    }
    @Override
    public void addUser(User s){
        Session session = this.sessionfactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void updateUser (User s){
        Session session = this.sessionfactory.getCurrentSession();
        User t = getUserById(s.getId());
        t.setUsername(s.getUsername());
        t.setPassword(s.getPassword());
        t.setEmail(s.getEmail());
        t.setProfession(s.getProfession());
        session.saveOrUpdate(t);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<User> listUser(){
        Session session = this.sessionfactory.getCurrentSession();
        List<User> UserList = session.createQuery("from User").list();
        return UserList;
    }
    @Override
    public User getUserById (int id){
        Session session = this.sessionfactory.getCurrentSession();
        User s = (User)session.load(User.class, new Integer(id));
        Hibernate.initialize(s);
        return s;
    }
    @Override
    public void removeUser(int id){
        Session session = this.sessionfactory.getCurrentSession();
        User s = (User) session.load(User.class, new Integer(id));
        if(null !=s){
            session.delete(s);
        }
    }
    
}
