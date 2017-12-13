/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.CourseTwo;
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
public class CourseTwoDAOImpl implements CourseTwoDAO {
    private SessionFactory sessionfactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionfactory = sf;
    }
    @Override
    public void addCourseTwo(CourseTwo s){
        Session session = this.sessionfactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void updateCourseTwo (CourseTwo s){
        Session session = this.sessionfactory.getCurrentSession();
        CourseTwo t = getCourseTwoById(s.getCoursetwoid());
        t.setCoursename(s.getCoursename());
        
        session.saveOrUpdate(t);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<CourseTwo> listCourseTwo(){
        Session session = this.sessionfactory.getCurrentSession();
        List<CourseTwo> CourseTwoList = session.createQuery("from CourseTwo").list();
        return CourseTwoList;
    }
    @Override
    public CourseTwo getCourseTwoById (int id){
        Session session = this.sessionfactory.getCurrentSession();
        CourseTwo s = (CourseTwo)session.load(CourseTwo.class, new Integer(id));
        Hibernate.initialize(s);
        return s;
    }
    @Override
    public void removeCourseTwo(int id){
        Session session = this.sessionfactory.getCurrentSession();
        CourseTwo s = (CourseTwo) session.load(CourseTwo.class, new Integer(id));
        if(null !=s){
            session.delete(s);
        }
    }
    
}
