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
@Table(name="Teachers")
public class Teachers {
   @Id
   @Column(name="teacherid")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private int teacherid;
   private String fname;
   private String lname;
   private String degree;
   private String department;

    public Teachers() {
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int id) {
        this.teacherid = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
   
}
