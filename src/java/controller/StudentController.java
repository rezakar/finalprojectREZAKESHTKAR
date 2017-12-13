/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.StudentService;

/**
 *
 * @author hamid
 */
@Controller
@RequestMapping("student")
public class StudentController {
    
    private StudentService studentService;

    @Autowired(required=true)
    @Qualifier(value="studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    
    @RequestMapping(value="/student_manipulate")
    public String studentEditNoId(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("action", "add");
        return "student_manipulate_form";
    }
    
    @RequestMapping(value = "/student_manipulate/{id}")
    public String studentEdit(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("action", "edit");
        return "student_manipulate_form";
    }
    
    @RequestMapping(value = "/student_list", method = RequestMethod.GET)
    public String listStudent(Model model) {
        model.addAttribute("listStudent", studentService.listStudents());
        return "student_list";
    }
	

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student s){
        studentService.addStudent(s);
        return "redirect:/student/student_list";	
    }
    
    @RequestMapping(value = "/student_manipulate/edit", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute("student") Student s) {
        studentService.updateStudent(s);
        return "redirect:/student/student_list";
    }
	
    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id) {	
        studentService.removeStudent(id);
        return "redirect:/student/student_list";
    }
}
