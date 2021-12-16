package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.Lecturer;
import lt.tauras.acadsys.service.LecturerService;
import lt.tauras.acadsys.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    // display list of lecturers
    @GetMapping("/lecturers")
    public String viewLecturersPage(Model model) {
        model.addAttribute("listLecturers", lecturerService.getAllLecturers());
        return "lecturers";
    }

    @GetMapping("/showNewLecturerForm")
    public String showNewLecturerForm(Model model) {
        // create model attribute to bind form data
        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer", lecturer);
        return "new_lecturer";
    }

    @PostMapping("/saveLecturer")
    public String saveLecturer(@ModelAttribute("lecturer") Lecturer lecturer) {
        // save lecturer to database
        lecturer.setUserName(lecturer.getName().toLowerCase());
        lecturer.setPassword(lecturer.getSurname().toLowerCase());
        lecturer.setActive(true);
        lecturer.setRoles(UserServiceImpl.ROLE_LECTURER);
        lecturerService.saveLecturer(lecturer);
        return "redirect:/lecturers";
    }

    @GetMapping("/deleteLecturer/{id}")
    public String deleteLecturer(@PathVariable (value = "id") long id) {

        // call delete lecturer method
        this.lecturerService.deleteLecturerById(id);
        return "redirect:/lecturers";
    }
}
