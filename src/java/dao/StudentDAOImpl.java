/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import model.Student;
import org.hibernate.Hibernate;
 
@Repository
public class StudentDAOImpl implements StudentDAO {
    private SessionFactory sessionfactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionfactory = sf;
    }
    @Override
    public void addStudent(Student s){
        Session session = this.sessionfactory.getCurrentSession();
        session.persist(s);
    }

    @Override
    public void updateStudent (Student s){
        Session session = this.sessionfactory.getCurrentSession();
        Student t = getStudentById(s.getStudentid());
        t.setFirstname(s.getFirstname());
        t.setLastname(s.getLastname());
        t.setStudingfield(s.getStudingfield());
        session.saveOrUpdate(t);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Student> listStudents(){
        Session session = this.sessionfactory.getCurrentSession();
        List<Student> StudentList = session.createQuery("from Student").list();
        return StudentList;
    }
    @Override
    public Student getStudentById (int id){
        Session session = this.sessionfactory.getCurrentSession();
        Student s = (Student)session.load(Student.class, new Integer(id));
        Hibernate.initialize(s);
        return s;
    }
    @Override
    public void removeStudent(int id){
        Session session = this.sessionfactory.getCurrentSession();
        Student s = (Student) session.load(Student.class, new Integer(id));
        if(null !=s){
            session.delete(s);
        }
    }
}
