package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.model.Teams;
import com.luv2code.springsecurity.demo.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;


import java.util.List;
import java.util.Optional;

@Service
public class TeamsServiceImpl implements TeamsService {

	@Autowired
	private TeamsRepository teamsRepository;


	@Override
	public List<Teams> getAllTeams() {
		return teamsRepository.findAll();
	}

	@Override
	public void saveTeams(Teams teams) {
		this.teamsRepository.save(teams);

	}

	@Override
	public Teams getTeamById(long id) {
		Optional<Teams> optional = teamsRepository.findById(id);
		Teams teams = null;
		if (optional.isPresent()) {
			teams = optional.get();
		} else {
			throw new RuntimeException(" Team not found for id :: " + id);
		}
		return teams;
	}

	@Override
	public void deleteTeamById(long id) {

	}

}
