package lt.tauras.acadsys.controller;

import lt.tauras.acadsys.model.User;
import lt.tauras.acadsys.repository.UserRepository;
import lt.tauras.acadsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    /*@Autowired
    private UserRepository userRepository;*/

    @Autowired
    private UserService userService;

    // display list of users
    @GetMapping("/index")
    public String viewHomePage(Model model) {
        return findPaginated(1, "userName", "asc", model);
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        userService.saveUser(user);
        return "redirect:/index";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get user from the service
        User user = userService.getUserById(id);

        // set user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {

        // call user employee method
        this.userService.deleteUserById(id);
        return "redirect:/index";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listUsers = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsers", listUsers);
        return "index";
    }






    /*@RequestMapping("/students")
    public String showUserList(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }*/

    /*@GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }*/

    /*@PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepository.save(user);
        return "Saved user " + user.getName() + " " + user.getSurname();
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userRepository.findById(id).get();
        updatedUser.setActive(user.isActive());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setUserName(user.getUserName());
        updatedUser.setRoles(user.getRoles());
        userRepository.save(updatedUser);
        return "Updated user " + user.getName() + " " + user.getSurname();
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id) {
        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "Delete user with the id " + id;
    }*/

    /*@GetMapping("/listUsers")
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("test");
        mav.addObject("listUsers", userRepository.findAll());
        return mav;
    }*/

    /*@RequestMapping("/students")
    public String getAllUsers(Model model) {
        List<User> listProducts = userService.listAll();
        model.addAttribute("listUsers", listProducts);

        return "students";
    }*/

}