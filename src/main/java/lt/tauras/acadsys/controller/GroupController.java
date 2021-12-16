package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.Group;
import lt.tauras.acadsys.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;

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
    public String saveLGroup(@ModelAttribute("group") Group group) {
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
}
