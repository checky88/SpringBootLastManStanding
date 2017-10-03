package test.model;

import java.util.List;

import test.competition.Competition;
import test.game.GameController;

public class Customer extends Competition   {
	Long id;
	String name;
	String email;
	List<String> teamChoice;
	Boolean winLoose;
	
	


	public Customer(Long i, String name, String email, List<String> teamChoice, Boolean winLoose, int startWeek) {
		super(startWeek);
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

	public List<String> getTeamChoice() {
		return teamChoice;
	}

	public void setTeamChoice(List<String> teamChoice) {
		this.teamChoice = teamChoice;
	}

	public Boolean getWinLoose() {
		this.winLoose = GameController.DidIWin(this.getStartWeek(),this.id);
		return winLoose;
	}
	

}
