/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.busmap.controllers;

import com.busmap.pojo.Route;
import com.busmap.pojo.User;
import com.busmap.service.UserService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lechi
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/users")
    public String list(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("users", userService.getUsers(params));
        model.addAttribute("user", new User());
        model.addAttribute("roles", Role.values());
        return "users";
    }
    
    @PostMapping(path = "/users")
    public String add(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult rs ){
//        if(rs.hasErrors()){
//            return "routes";
//        }
        try {
            this.userService.createUser(user);
        } catch (Exception ex) {
            model.addAttribute("errMsg", ex.getMessage());
            return "users";

        }
//        this.routeService.addOrUpdate(route);
        return "redirect:/users";
    }
    
    @GetMapping(path = "/users/test")
    public String test(Model model){
        User user = new User("admin", "admin", "lê", "Thien", "ROLE_ADMIN", "lechithien26@gmaii.com", "0942117827");
//        try {
//            this.userService.createUser(user);
//        } catch (Exception ex) {
//            model.addAttribute("errMsg", ex.getMessage());
//            return "users";
//
//        }
        this.userService.createUser(user);

        return "redirect:/users";
    }
}
