package com.team.controller;

import com.team.dao.UserRepository;
import com.team.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class ApplicationController {

    @Autowired
    private UserRepository userRepository;

    public User current_user(){
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUserName(username);
        return  user;
    }

    // Checks if current user is admin
    public boolean isAdminUser() {

        User user = current_user();
        if (user.getRole().toString() == "admin") {
            return true;
        } else {
            return false;
        }
    }


    // Checks if current user is manager
    public boolean isManagerUser() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUserName(username);
        if (user.getRole().toString() == "manager") {
            return true;
        } else {
            return false;
        }
    }

    // Checks if current user is user
    public boolean isUserUser() {
        String username = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = userRepository.findByUserName(username);
        if (user.getRole().toString() == "user") {
            return true;
        } else {
            return false;
        }
    }
}
