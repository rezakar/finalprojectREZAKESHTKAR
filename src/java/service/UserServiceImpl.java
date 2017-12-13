/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDAO;
import java.util.List;
import model.User;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hamid
 */

public class UserServiceImpl implements UserService{
    private UserDAO teachersDAO;
    public void setUserDAO(UserDAO teachersDAO) {
        this.teachersDAO = teachersDAO;
    }
    
    @Override
    @Transactional
    public void addUser(User s) {
        teachersDAO.addUser(s);
    }

    @Override
    @Transactional
    public void updateUser(User s) {
        teachersDAO.updateUser(s);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return teachersDAO.listUser();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return teachersDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        teachersDAO.removeUser(id);
    }
}
