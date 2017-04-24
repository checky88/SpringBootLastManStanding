package test.fixture;

import java.util.List;


public class Result {
	private List<Result> results;
	private int goalsHomeTeam;
    private int goalsAwayTeam;
	
	
	public int getGoalsHomeTeam() {
		return goalsHomeTeam;
	}
	public void setGoalsHomeTeam(int goalsHomeTeam) {
		this.goalsHomeTeam = goalsHomeTeam;
	}
	public int getGoalsAwayTeam() {
		return goalsAwayTeam;
	}
	public void setGoalsAwayTeam(int goalsAwayTeam) {
		this.goalsAwayTeam = goalsAwayTeam;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}

}
