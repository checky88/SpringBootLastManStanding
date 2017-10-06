package test.fixture;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)
public class Fixture {


	@Autowired
	private FixtureController fixtureController = new FixtureController();
	
	private static int count;
	//getting a fixture by ID 
	public static Fixture get(int id) {
		return Fixture.get(id);
	}

	private List<Fixture> fixtures;
	@JsonProperty("fixture")
	private List<Fixture> fixture;
	private int listId;
	private int fixtureId;
	private Links _links;
	private String date;
	private String status;
	private int matchday;

	private String homeTeamName;
	
	private String awayTeamName;

	private Result result;

	public Links get_links() {
		return _links;
	}
	
	public String getAwayTeamName() {
		return awayTeamName;
	}

	public String getDate() {
		return date;
	}

	public List<Fixture> getFixture() {
		return fixture;
	}

	public int getFixtureId() {
		String theString = get_links().getSelf().getHref();
		theString = theString.substring(theString.length() - 6);
		if(!theString.endsWith("es")){
		 fixtureId = Integer.parseInt(theString);
		}
		return fixtureId;
	}

	public List<Fixture> getFixtures() {
		return fixtures;
	}

	public String getHomeTeamName() {
		return homeTeamName;
	}

	public int getListId() {
		listId = count;
		count++;
		if(count == fixtureController.getNumFixtures()){
		 count = 0;
		}
		return listId;
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

	public void set_links(Links _links) {
		this._links = _links;

	}

	public void setAwayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFixture(List<Fixture> fixture) {
		this.fixture = fixture;
	}

	public void setFixtureId(int fixtureId) {
		this.fixtureId = fixtureId;	
	}

	public void setFixtures(List<Fixture> fixtures) {
		this.fixtures = fixtures;
	}

	public void setHomeTeamName(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public void setListId(int listId) {
		this.listId = listId;
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



}
