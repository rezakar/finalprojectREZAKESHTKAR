/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hamid
 */
@Entity
@Table(name="Mark")
public class Mark implements Serializable { 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int Mark_id;
    @ManyToOne(fetch=FetchType.EAGER)
    //@NotNull
    private Student student;
    @ManyToOne(fetch=FetchType.EAGER)
    //@NotNull
    private Teachers teacher;
    @ManyToOne(fetch=FetchType.EAGER)
    //@NotNull
    private CourseTwo course;
    private int mark;

    public int getMark_id() {
        return Mark_id;
    }

    public void setMark_id(int Mark_id) {
        this.Mark_id = Mark_id;
    }

    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public CourseTwo getCourse() {
        return course;
    }

    public void setCourse(CourseTwo course) {
        this.course = course;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    
}
