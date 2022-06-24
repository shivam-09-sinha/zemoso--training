package com.team.controller;

import com.team.dao.PlayerRepository;
import com.team.dao.TeamRepository;
import com.team.model.Players;
import com.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PlayerController extends ApplicationController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teams/{team_id}/players/new")
    public String newPlayer(Model model, @PathVariable("team_id")int team_id){
        model.addAttribute("player", new Players());
        Team team = teamRepository.findById(team_id).orElse(null);
        model.addAttribute("team", team);
        model.addAttribute("current_user", current_user());
        return "new_player";
    }

    @RequestMapping(value = "/teams/{team_id}/players", method = RequestMethod.POST)
    public String playerCreate(@Valid @ModelAttribute Players players, BindingResult result, @PathVariable("team_id")int team_id){
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "new_player";
        }
        System.out.println(players);
        Team team = teamRepository.findById(team_id).orElse(null);
        players.setTeam(team);
        playerRepository.save(players);
        return "redirect:/";
    }

    @GetMapping("/players/{id}/delete")
    public String deletePlayer(@PathVariable("id")int id){
        playerRepository.deleteById(id);
        return "redirect:/";
    }
}
