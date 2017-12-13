/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Mark;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Kritth
 */
@Repository
public class MarkDAOImpl implements MarkDAO {
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addMark(Mark m) {
       Session session = this.sessionFactory.getCurrentSession();
       session.persist(m);
// throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMark(Mark m) {
       Session session = this.sessionFactory.getCurrentSession();
       session.saveOrUpdate(m);
//       Mark t = getMarkById(m.getMark_id());
//       t.setMark_id(m.getMark_id());
//       t.setMark(m.getMark());
//       t.setStudent(m.getStudent());
//       t.setTeacher(m.getTeacher());
//       t.setCourse(m.getCourse());
// throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated metmhods, choose Tools | Templates.
    }

    @Override
    public List<Mark> listMarks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Mark> markList = session.createQuery("from Mark").list();
        return markList;
    }

    @Override
    public Mark getMarkById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
      Mark s = (Mark)session.load(Mark.class, new Integer(id));
        Hibernate.initialize(s);
        return s;
//  throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeMark(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Mark s = (Mark) session.load(Mark.class, new Integer(id));
        if(null !=s){
            session.delete(s);
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
}
}