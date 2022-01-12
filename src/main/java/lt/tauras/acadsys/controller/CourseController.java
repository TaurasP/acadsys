package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.Course;
import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.service.CourseService;
import lt.tauras.acadsys.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private GradeService gradeService;

    // display list of courses
    @GetMapping("/courses")
    public String viewCoursesPage(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("listCourses", courseService.getAllCourses());
        model.addAttribute("listGrades", gradeService.getAllStudentCourseGrades(student));
        return "courses";
    }

    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model) {
        // create model attribute to bind form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "new_course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Course course) {
        // save course to database
        courseService.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {

        // call delete course method
        this.courseService.deleteCourseById(id);
        return "redirect:/courses";
    }
}
