package com.luv2code.springsecurity.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Teams")
public class Teams {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "team_Name")
	private String team_Name;

	@Column(name = "captain_Name")
	private String captain_Name;

	@Column(name = "owned_By")
	private String owned_By;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTeam_Name() {
		return team_Name;
	}

	public void setTeam_Name(String team_Name) {
		this.team_Name = team_Name;
	}

	public String getCaptain_Name() {
		return captain_Name;
	}

	public void setCaptain_Name(String captain_Name) {
		this.captain_Name = captain_Name;
	}

	public String getOwned_By() {
		return owned_By;
	}

	public void setOwned_By(String owned_By) {
		this.owned_By = owned_By;
	}
}
