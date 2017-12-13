/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MarkDAO;
import java.util.List;
import model.Mark;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kritth
 */
@Service
@Transactional
public class MarkServiceImpl implements MarkService {
    private MarkDAO markDAO;

    public void setMarkDAO(MarkDAO markDAO) {
        this.markDAO = markDAO;
    }

    @Override
    public void addMark(Mark m) {
        markDAO.addMark(m);
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMark(Mark m) {
        markDAO.updateMark(m);
       // throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mark> listMarks() {
        return markDAO.listMarks();
    }

    @Override
    public Mark getMarkById(int id) {
      return  markDAO.getMarkById(id);
        //throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeMark(int id) {
        markDAO.removeMark(id);
       // throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.
    }
}
