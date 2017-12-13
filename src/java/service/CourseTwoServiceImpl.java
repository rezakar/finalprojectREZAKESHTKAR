/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CourseTwoDAO;
import java.util.List;
import model.CourseTwo;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hamid
 */
public class CourseTwoServiceImpl implements CourseTwoService {
    private CourseTwoDAO courseTwoDAO;
    public void setCourseTwoDAO(CourseTwoDAO courseTwoDAO) {
        this.courseTwoDAO = courseTwoDAO;
    }
    
    @Override
    @Transactional
    public void addCourseTwo(CourseTwo s) {
        courseTwoDAO.addCourseTwo(s);
    }

    @Override
    @Transactional
    public void updateCourseTwo(CourseTwo s) {
        courseTwoDAO.updateCourseTwo(s);
    }

    @Override
    @Transactional
    public List<CourseTwo> listCourseTwo() {
        return courseTwoDAO.listCourseTwo();
    }

    @Override
    @Transactional
    public CourseTwo getCourseTwoById(int id) {
        return courseTwoDAO.getCourseTwoById(id);
    }

    @Override
    @Transactional
    public void removeCourseTwo(int id) {
        courseTwoDAO.removeCourseTwo(id);
    }
}
