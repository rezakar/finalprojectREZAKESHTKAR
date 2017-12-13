/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Teachers;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hamid
 */
@Repository
public class TeachersDAOImpl implements TeachersDAO {
    private SessionFactory sessionfactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionfactory = sf;
    }
    @Override
    public void addTeachers(Teachers s){
        Session session = this.sessionfactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void updateTeachers (Teachers s){
        Session session = this.sessionfactory.getCurrentSession();
        Teachers t = getTeachersById(s.getTeacherid());
        t.setFname(s.getFname());
        t.setLname(s.getLname());
        t.setDepartment(s.getDepartment());
        t.setDegree(s.getDegree());
        session.saveOrUpdate(t);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Teachers> listTeachers(){
        Session session = this.sessionfactory.getCurrentSession();
        List<Teachers> TeachersList = session.createQuery("from Teachers").list();
        return TeachersList;
    }
    @Override
    public Teachers getTeachersById (int id){
        Session session = this.sessionfactory.getCurrentSession();
        Teachers s = (Teachers)session.load(Teachers.class, new Integer(id));
        Hibernate.initialize(s);
        return s;
    }
    @Override
    public void removeTeachers(int id){
        Session session = this.sessionfactory.getCurrentSession();
        Teachers s = (Teachers) session.load(Teachers.class, new Integer(id));
        if(null !=s){
            session.delete(s);
        }
    }
    
}
