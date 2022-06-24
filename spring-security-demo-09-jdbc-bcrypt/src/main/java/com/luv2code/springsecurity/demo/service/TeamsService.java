package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.model.Teams;

import java.util.List;

public interface TeamsService {
	List<Teams> getAllTeams();
	void saveTeams(Teams team);
	Teams getTeamById(long id);
	void deleteTeamById(long id);

}
