/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import static jdk.nashorn.internal.runtime.Debug.id;
import model.CourseTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.portlet.ModelAndView;
import service.CourseTwoService;

/**
 *
 * @author hamid
 */
@Controller
@RequestMapping("courseTwo")
public class CourseTwoController {
    private CourseTwoService courseTwoService;

    @Autowired(required=true)
    @Qualifier(value="courseTwoService")
    public void setCourseTwoService(CourseTwoService courseTwoService) {
        this.courseTwoService = courseTwoService;
    }

    /*
    @RequestMapping(value = "/courseTwo_form", method = RequestMethod.GET)
    public String courseTwoForm(Model model) {
        model.addAttribute("courseTwo", new CourseTwo());
        return "courseTwo_form";
    }
    @RequestMapping(value = "/courseTwoedit_form/{id}")
    public String courseTwoeditForm(@PathVariable("id") int id, Model model) {
       model.addAttribute("getCourseTwo",courseTwoService.getCourseTwoById(id));
        return "courseTwoedit_form";
    }
    */
    @RequestMapping(value="/courseTwo_manipulate")
    public String courseTwoEditNoId(Model model) {
        model.addAttribute("courseTwo", new CourseTwo());
        model.addAttribute("action", "add");
        return "courseTwo_manipulate_form";
    }
    
    @RequestMapping(value = "/courseTwo_manipulate/{id}")
    public String courseTwoEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("courseTwo", courseTwoService.getCourseTwoById(id));
        model.addAttribute("action", "edit");
        return "courseTwo_manipulate_form";
    }
    
    @RequestMapping(value = "/courseTwo_list", method = RequestMethod.GET)
    public String listCourseTwo(Model model) {
        model.addAttribute("listCourseTwo", courseTwoService.listCourseTwo());
        return "courseTwo_list";
    }
	

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addCourseTwo(@ModelAttribute("courseTwo") CourseTwo s){
        courseTwoService.addCourseTwo(s);
        return "redirect:/courseTwo/courseTwo_list";	
    }
    
    @RequestMapping(value = "/courseTwo_manipulate/edit", method = RequestMethod.POST)
    public String editCourseTwo(@ModelAttribute("courseTwo") CourseTwo s) {
        courseTwoService.updateCourseTwo(s);
        return "redirect:/courseTwo/courseTwo_list";
    }
	
    @RequestMapping("/remove/{id}")
    public String removeCourseTwo(@PathVariable("id") int id) {	
        courseTwoService.removeCourseTwo(id);
        return "redirect:/courseTwo/courseTwo_list";
    }
//    @RequestMapping("/edit/{id}")
//    public ModelAndView edit (@PathVariable("id") int id){
//         CourseTwo emp=courseTwoService.getCourseTwoById(id);
//         //model.addAttribute("listCourseTwo", courseTwoService.listCourseTwo());
//        return new ModelAndView ("courseTwoedit_form","command",emp);
//    }
/*    @RequestMapping(value="/editsave",method=RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("emp") CourseTwo emp){  
        courseTwoService.updateCourseTwo(emp);
        return new ModelAndView("redirect:/courseTwo/courseTwo_list");  
    }   */
}
