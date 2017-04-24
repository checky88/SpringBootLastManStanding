package test.fixture;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)
public class Fixture {

	
	private List<Fixture> fixtures;
	
	private Links _links;
	private String date;
	private String status;
	private int matchday;
	private String homeTeamName;
	private String awayTeamName;

	private Result result;
	

    @JsonProperty("_links")
	public Links getLinks() {
		return _links;
	}

    @JsonProperty("_links")
	public void setLinks(Links _links) {
		this._links = _links;
	}

	public String getAwayTeamName() {
		return awayTeamName;
	}

	public String getDate() {
		return date;
	}

	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public int getMatchday() {
		return matchday;
	}

	public Result getResult() {
		return result;
	}

	public String getStatus() {
		return status;
	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public void setMatchday(int matchday) {
		this.matchday = matchday;
	}

	public void setResult(Result result) {
		this.result = result;
		// this.goalsAwayTeam = result.getGoalsAwayTeam();
		// this.goalsHomeTeam = result.getGoalsHomeTeam();
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	//getting a fixture by ID 
	public static Fixture get(Long id) {
		return Fixture.get(id);
	}



}
