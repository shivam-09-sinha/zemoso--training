package com.team.controller;

import com.team.dao.UserRepository;
import com.team.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController extends ApplicationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public String userList(Model model){
        if(current_user().getRole().toString() != "admin"){
            System.out.println("hello");
            return "redirect:/";
        }
        List<User> usersList = userRepository.findAll();
        model.addAttribute("users", usersList);
        model.addAttribute("current_user", current_user());
        return "user_list";
    }

    @GetMapping("/users/new")
    public String newUser(Model model){
        if(!isAdminUser()){
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        model.addAttribute("current_user", current_user());
        return "new_user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String userCreate(@Valid @ModelAttribute User user, BindingResult result){
        if(!isAdminUser()){
            return "redirect:/";
        }
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "new_user";
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userRepository.findById(id).orElse(null));
        model.addAttribute("current_user", current_user());
        return "edit_user";
    }



    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable("id")int id, @ModelAttribute User user){
        User exists = userRepository.findById(id).orElse(null);
        exists.setUserName(user.getUserName());
        exists.setEmail(user.getEmail());
        if(isAdminUser()) {
            exists.setRole(user.getRole());
        }
        userRepository.save(exists);
        return "redirect:/users";
    }



    @GetMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id")int id){
        if(!isAdminUser()){
            return "redirect:/";
        }
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
