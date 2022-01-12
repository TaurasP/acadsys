package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.service.StudentService;
import lt.tauras.acadsys.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String viewStudentsPage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        student.setUserName(student.getName().toLowerCase());
        student.setPassword(student.getSurname().toLowerCase());
        student.setActive(true);
        student.setRoles(UserServiceImpl.ROLE_STUDENT);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {
        this.studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
