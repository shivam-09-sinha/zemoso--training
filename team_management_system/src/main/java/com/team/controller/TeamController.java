package com.team.controller;

import com.team.dao.TeamRepository;
import com.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Controller
public class TeamController extends ApplicationController{

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams")
    public String getTeams(Model model) {
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("current_user", current_user());
        return "teams";
    }

    @GetMapping("/teams/{id}")
    public String TeamShow(@PathVariable("id")int id, Model model) throws UnsupportedEncodingException {
        model.addAttribute("team", teamRepository.findById(id).orElse(null));
        model.addAttribute("players", teamRepository.findById(id).orElse(null).getPlayers());
        byte[] encodeBase64 = Base64.getEncoder().encode(teamRepository.findById(id).orElse(null).getImage());
        String base64Encoded = new String(encodeBase64, "UTF-8");
        model.addAttribute("contentImage", base64Encoded );
        model.addAttribute("current_user", current_user());
        return "show_team";
    }

    @GetMapping("/teams/new")
    public String newTeam(Model model){
        model.addAttribute("team", new Team());
        model.addAttribute("current_user", current_user());
        return "new_team";
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public String teamCreate(@RequestParam("name")String name, @RequestParam("win")int win, @RequestParam("loss")int loss,@RequestParam("image") MultipartFile file ) throws IOException {

        Team team = new Team();
        team.setName(name);
        team.setLoss(loss);
        team.setWin(win);
        team.setImage(file.getBytes());
        teamRepository.save(team);
        return "redirect:/";
    }




    @GetMapping("/teams/{id}/edit")
    public String editTeam(@PathVariable("id") int id, Model model){
        model.addAttribute("current_user", current_user());
        model.addAttribute("team", teamRepository.findById(id).orElse(null));
        return "edit_team";
    }

    @PostMapping("/teams/{id}/update")
    public String updateProject(@PathVariable("id") int id, @ModelAttribute Team team){
        Team exists = teamRepository.findById(id).orElse(null);
        exists.setName(team.getName());
        exists.setLoss(team.getLoss());
        exists.setWin(team.getWin());
        teamRepository.save(team);
        return "redirect:/";
    }

    @GetMapping("/teams/{id}/delete")
    public String deleteTeam(@PathVariable("id")int id){
        teamRepository.deleteById(id);
        return "redirect:/";
    }

}
