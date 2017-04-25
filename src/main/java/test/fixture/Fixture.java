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


	private int fixtureId;
	private Links _links;
	private String date;
	private String status;
	private int matchday;
	private String homeTeamName;
	private String awayTeamName;

	private Result result;
	
	

	public int getFixtureId() {
		String theString = get_links().getSelf().getHref();
		theString = theString.substring(theString.length() - 6);
		if(!theString.endsWith("es")){
		 fixtureId = Integer.parseInt(theString);
		}
		return fixtureId;
	}

	public void setFixtureId(int fixtureId) {
		
		this.fixtureId = fixtureId;
		
	}

	public Links get_links() {
		return _links;
	}

	public void set_links(Links _links) {
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
	public static Fixture get(int id) {
		return Fixture.get(id);
	}



}
