/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.beans.PropertyEditorSupport;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.CourseTwo;
import model.Mark;
import model.Student;
import model.Teachers;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import service.CourseTwoService; 
import service.StudentService;
import service.TeachersService;
import service.MarkService;


@Controller
@RequestMapping("mark")
public class MarkController {
    @Autowired
    private MarkService markService;

    @RequestMapping(value = "/mark_form", method = RequestMethod.GET)
    public String courseForm(Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("courseList", courseService.listCourseTwo());
        model.addAttribute("studentList",sservice.listStudents());
        model.addAttribute("teacherList",tservice.listTeachers());
        model.addAttribute("action", "add");
        return "mark_form";
    }
    
    @RequestMapping(value = "/mark_list", method = RequestMethod.GET)
    public String listMarks(Model model) {
        model.addAttribute("listMarks", markService.listMarks());
        return "mark_list";
    }
	

    @RequestMapping(value= "/add", method = RequestMethod.POST)
    public String addMark(@ModelAttribute("mark") Mark s, BindingResult result){
        markService.addMark(s);
        //System.out.println(s.getCourse().getId() + " " + s.getCourse().getCourseName());
        System.out.println(s.getCourse().getCoursetwoid()+" "+s.getCourse().getCoursename());
        return "redirect:/mark/mark_list";	
    }
	
    @RequestMapping("/remove/{id}")
    public String removeCourse(@PathVariable("id") int id) {	
        // markService.removeMark(id);
        return "redirect:/mark/mark_list";
    }
    
    // Binding
    @Autowired
    private StudentService sservice;
    
    @Autowired
    private TeachersService tservice;
    
    @Autowired
    private CourseTwoService courseService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.registerCustomEditor(CourseTwo.class, "course", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text)
            {
                List<CourseTwo> list = courseService.listCourseTwo();
                for (CourseTwo c : list)
                {
                    if (c.getCoursetwoid() == Integer.parseInt(text))
                    {
                        setValue(c);
                        return;
                    }
                }
            }
        });
        binder.registerCustomEditor(Student.class, "student", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text)
            {
                List<Student> list = sservice.listStudents();
                for (Student c : list)
                {
                    if (c.getStudentid() == Integer.parseInt(text))
                    {
                        setValue(c);
                        return;
                    }
                }
            }
        });
        binder.registerCustomEditor(Teachers.class, "teacher", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text)
            {
                List<Teachers> list = tservice.listTeachers();
                for (Teachers c : list)
                {
                    if (c.getTeacherid() == Integer.parseInt(text))
                    {
                        setValue(c);
                        return;
                    }
                }
            }
        });
        binder.registerCustomEditor(Mark.class, "mark", new PropertyEditorSupport() {
            @Override
            public void setAsText(String text)
            {
                List<Mark> list = markService.listMarks();
                for (Mark c : list)
                {
                    if (c.getMark_id() == Integer.parseInt(text))
                    {
                        setValue(c);
                        return;
                    }
                }
            }
        });
    }
    
}