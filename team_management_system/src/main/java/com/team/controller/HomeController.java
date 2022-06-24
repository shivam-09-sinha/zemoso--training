package com.team.controller;

import com.team.dao.TeamRepository;
import com.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends ApplicationController{

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/login")
    public String  login(){
        return "login";
    }

    @GetMapping("/")
    public String teamList(Model model){
            model.addAttribute("teams", teamRepository.findAll());
            model.addAttribute("current_user", current_user());
            return "teams";

    }
}
