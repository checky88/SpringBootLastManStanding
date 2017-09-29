package test.model;

import test.game.GameController;

public class Customer {
	Long id;
	String name;
	String email;
	String teamChoice;
	Boolean winLoose;

	public Customer() {
	}

	public Customer(Long i, String name, String email, String teamChoice, Boolean winLoose) {
		this.id = i;
		this.name = name;
		this.email = email;
		this.teamChoice = teamChoice;
		this.winLoose = winLoose;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeamChoice() {
		return teamChoice;
	}

	public void setTeamChoice(String teamChoice) {
		this.teamChoice = teamChoice;
	}

	public Boolean getWinLoose() {
		this.winLoose = GameController.DidIWin(this.id);
		return winLoose;
	}

	public void setWinLoose(Boolean winLoose) {
		this.winLoose = GameController.DidIWin(this.id);
		// this.winLoose = winLoose;
	}

}
