/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hamid
 */
@Entity
@Table(name="coursetwo")
public class CourseTwo {
   @Id
   @Column(name="coursetwoid")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int coursetwoid;
   private String coursename;
   

    public CourseTwo() {
    }

    public int getCoursetwoid() {
        return coursetwoid;
    }

    public void setCoursetwoid(int coursetwoid) {
        this.coursetwoid = coursetwoid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    
}
