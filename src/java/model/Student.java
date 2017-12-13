/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

 
@Entity
@Table(name="STUDENT")
public class Student {
    
    @Id
    @Column(name="studentid")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int studentid;
    private String firstname;
    private String lastname;
    private String studingfield;

    public Student() {
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudingfield() {
        return studingfield;
    }

    public void setStudingfield(String studingfield) {
        this.studingfield = studingfield;
    }

    
    
    
    
}
