package com.luv2code.springsecurity.demo.repository;

import com.luv2code.springsecurity.demo.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
}