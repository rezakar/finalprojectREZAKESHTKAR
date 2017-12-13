/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.TeachersDAO;
import java.util.List;
import model.Teachers;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hamid
 */
public class TeachersServiceImpl implements TeachersService {
    private TeachersDAO teachersDAO;
    public void setTeachersDAO(TeachersDAO teachersDAO) {
        this.teachersDAO = teachersDAO;
    }
    
    @Override
    @Transactional
    public void addTeachers(Teachers s) {
        teachersDAO.addTeachers(s);
    }

    @Override
    @Transactional
    public void updateTeachers(Teachers s) {
        teachersDAO.updateTeachers(s);
    }

    @Override
    @Transactional
    public List<Teachers> listTeachers() {
        return teachersDAO.listTeachers();
    }

    @Override
    @Transactional
    public Teachers getTeachersById(int id) {
        return teachersDAO.getTeachersById(id);
    }

    @Override
    @Transactional
    public void removeTeachers(int id) {
        teachersDAO.removeTeachers(id);
    }
}
