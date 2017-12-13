/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Mark;

/**
 *
 * @author Kritth
 */
public interface MarkService {
        
    public void addMark(Mark m);
    public void updateMark(Mark m);
    public List<Mark> listMarks();
    public Mark getMarkById(int id);
    public void removeMark(int id);
}
