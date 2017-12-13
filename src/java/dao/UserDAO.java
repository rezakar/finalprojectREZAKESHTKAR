/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.User;

/**
 *
 * @author hamid
 */
public interface UserDAO {
    public void addUser(User s);
    public void updateUser(User s);
    public List<User> listUser();
    public User getUserById(int id);
    public void removeUser(int id);
    
}
