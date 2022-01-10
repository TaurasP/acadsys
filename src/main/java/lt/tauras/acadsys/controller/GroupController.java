package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.Group;
import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.service.GroupService;
import lt.tauras.acadsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private StudentService studentService;

    // display list of groups
    @GetMapping("/groups")
    public String viewGroupsPage(Model model) {
        model.addAttribute("listGroups", groupService.getAllGroups());
        return "groups";
    }

    @GetMapping("/showNewGroupForm")
    public String showNewGroupForm(Model model) {
        // create model attribute to bind form data
        Group group = new Group();
        model.addAttribute("group", group);
        return "new_group";
    }

    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group) {
        // save group to database
        groupService.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteGroup(@PathVariable(value = "id") long id) {

        // call delete group method
        this.groupService.deleteGroupById(id);
        return "redirect:/groups";
    }

    // display list of students from a group
    /*@GetMapping("/group_students")
    public String viewGroupStudentsPage(Long id, Model model) {
        id = 28L;
        model.addAttribute("listGroupStudents", groupService.getAllStudentsByGroupId(id));
        model.addAttribute("groupName", groupService.getGroupById(id).getName());
        model.addAttribute("listStudents", studentService.getAllStudents());

        return "group_students";
    }*/

    @GetMapping("/group_students/{id}")
    public String viewGroupStudentsPage(@PathVariable(value = "id") long id, @ModelAttribute("group") Group group, Model model) {
        model.addAttribute("listGroupStudents", groupService.getAllStudentsByGroupId(id));
        model.addAttribute("groupName", groupService.getGroupById(id).getName());
        model.addAttribute("listStudents", studentService.getAllStudents());
        model.addAttribute("listStudentsWithoutGroup", studentService.getAllStudentsWithoutGroup());
        model.addAttribute("listStudentsWithGroup", studentService.getAllStudentsWithGroup());

        return "group_students";
    }

    @PostMapping("/group_students/{id}")
    public String saveStudentToGroup(@PathVariable(value = "id") long id, @ModelAttribute("group") Group group, @ModelAttribute("student") Student student) {
        // save student to a group
        List<Student> studentsList = new ArrayList<>();
        //studentsList.add(studentService.getStudentById(id));
        studentsList.add(student);
        group.setStudents(studentsList);
        groupService.saveGroup(group);

        //model.addAttribute("group", groupService.getGroupById(group.getId()));

        //return "redirect:/group_students/{id}";
        return "/group_students/{id}";
    }
}
