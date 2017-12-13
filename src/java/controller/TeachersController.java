/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import static jdk.nashorn.internal.runtime.Debug.id;
import model.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.portlet.ModelAndView;
import service.TeachersService;

/**
 *
 * @author hamid
 */
@Controller
@RequestMapping("teachers")
public class TeachersController {
    private TeachersService teachersService;

    @Autowired(required=true)
    @Qualifier(value="teachersService")
    public void setTeachersService(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    /*
    @RequestMapping(value = "/teachers_form", method = RequestMethod.GET)
    public String teachersForm(Model model) {
        model.addAttribute("teachers", new Teachers());
        return "teachers_form";
    }
    @RequestMapping(value = "/teachersedit_form/{id}")
    public String teacherseditForm(@PathVariable("id") int id, Model model) {
       model.addAttribute("getTeachers",teachersService.getTeachersById(id));
        return "teachersedit_form";
    }
    */
    @RequestMapping(value="/teacher_manipulate")
    public String teacherEditNoId(Model model) {
        model.addAttribute("teachers", new Teachers());
        model.addAttribute("action", "add");
        return "teacher_manipulate_form";
    }
    
    @RequestMapping(value = "/teacher_manipulate/{id}")
    public String teacherEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("teachers", teachersService.getTeachersById(id));
        model.addAttribute("action", "edit");
        return "teacher_manipulate_form";
    }
    
    @RequestMapping(value = "/teachers_list", method = RequestMethod.GET)
    public String listTeachers(Model model) {
        model.addAttribute("listTeachers", teachersService.listTeachers());
        return "teachers_list";
    }
	

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addTeachers(@ModelAttribute("teachers") Teachers s){
        teachersService.addTeachers(s);
        return "redirect:/teachers/teachers_list";	
    }
    
    @RequestMapping(value = "/teacher_manipulate/edit", method = RequestMethod.POST)
    public String editTeachers(@ModelAttribute("teachers") Teachers s) {
        teachersService.updateTeachers(s);
        return "redirect:/teachers/teachers_list";
    }
	
    @RequestMapping("/remove/{id}")
    public String removeTeachers(@PathVariable("id") int id) {	
        teachersService.removeTeachers(id);
        return "redirect:/teachers/teachers_list";
    }
//    @RequestMapping("/edit/{id}")
//    public ModelAndView edit (@PathVariable("id") int id){
//         Teachers emp=teachersService.getTeachersById(id);
//         //model.addAttribute("listTeachers", teachersService.listTeachers());
//        return new ModelAndView ("teachersedit_form","command",emp);
//    }
/*    @RequestMapping(value="/editsave",method=RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("emp") Teachers emp){  
        teachersService.updateTeachers(emp);
        return new ModelAndView("redirect:/teachers/teachers_list");  
    }   */
}
