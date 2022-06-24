package com.team.dao;

import com.team.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Players, Integer> {
}
