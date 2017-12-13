/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Teachers;

/**
 *
 * @author hamid
 */
public interface TeachersService {
    public void addTeachers(Teachers s);
    public void updateTeachers(Teachers s);
    public List<Teachers> listTeachers();
    public Teachers getTeachersById(int id);
    public void removeTeachers(int id);
    
}
