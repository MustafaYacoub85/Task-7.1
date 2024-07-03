package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Controller
public class UserController {
    private final UserService userServices;
    @Autowired
    public UserController(UserService userService){
        this.userServices = userService;
    }

    @GetMapping({"","/","/list"})
    public String getUsers(Model model) {
        model.addAttribute("users", userServices.getAllUser());
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model){
        User user = userServices.readUser(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        userServices.createOrUpdateUser(user);
        return "redirect:/list";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") Long id, User user, Model model){
        user.setId(id);
        userServices.createOrUpdateUser(user);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public  String confirmDelete(@PathVariable("id") Long id){
        userServices.deleteUser(id);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "create";
    }
}
