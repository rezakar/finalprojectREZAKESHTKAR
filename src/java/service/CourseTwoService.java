/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.CourseTwo;

/**
 *
 * @author hamid
 */
public interface CourseTwoService {
    public void addCourseTwo(CourseTwo s);
    public void updateCourseTwo(CourseTwo s);
    public List<CourseTwo> listCourseTwo();
    public CourseTwo getCourseTwoById(int id);
    public void removeCourseTwo(int id);
    
}
