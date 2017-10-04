package test.fixture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import test.competition.Competition;
import test.model.Customer;

@RestController
@RequestMapping("api/v1/")
public class FixtureController {

	private List<Fixture> response;

	private List<Fixture> headToHeadResponse;
	private final static String accessToken = "3acf11744bd946098fe44176f6cc51a0";

	private static int currentGameWeek = 1;

	private static int numFixtures;

	public static int getCurrentGameWeek() {
		return currentGameWeek;
	}

	public static int getNumFixtures() {
		return numFixtures;
	}

	@RequestMapping("/result")
	public List<Fixture> outputresults() {
		RestTemplate restTemplate = new RestTemplate();
		List<Fixture> fixture = restTemplate
				.getForObject("http://api.football-data.org/v1/competitions/445/fixtures", Fixture.class).getFixtures();
		for (Fixture elem : fixture) {
			// System.out.println(elem.getLinks());
		}

		return fixture;

	}
	
	
	@RequestMapping("/evaluateFixtures")
	public static boolean evaluateAllFixtures(int startWeek, int gameweek, List<String> teamChosen) {
		int startweek = startWeek;
		int team = 0;
		boolean win = false;
		int weeksPlayed = gameweek - startweek;
				
		while(startweek < gameweek ){

		List<Fixture> listResponse = apiCall(startweek);
		List<String> response = new ArrayList<String>();
		List<String> winners = new ArrayList<String>();

		for (Fixture elem : listResponse) {
			response.add(elem.getHomeTeamName() + " V  " + elem.getAwayTeamName());
				System.out.print(elem.getHomeTeamName() + " V  " + elem.getAwayTeamName());
				if (elem.getResult().getGoalsHomeTeam() > elem.getResult().getGoalsAwayTeam()) {
					System.out.println(" The Winner Was " + elem.getHomeTeamName());
					winners.add(elem.getHomeTeamName());
				} else if (elem.getResult().getGoalsHomeTeam() < elem.getResult().getGoalsAwayTeam()) {
					System.out.println(" The Winner Was " + elem.getAwayTeamName());
					winners.add(elem.getAwayTeamName());
				} else {
					System.out.println(" It was a DRAW ");
				} // end else
		} // end for
		
		if(teamChosen.size() <= weeksPlayed){
			if (winners.contains(teamChosen.get(team))) {
				System.out.println("Your still in");
				win = true;
			} else {
				System.out.println("Your out");
				win = false;
				break;
			}			
		}else{
			System.out.println("You Have Not Selected enough teams you will be auto selected");
			///in here i will add logic to auto draft a unselected team 
			
		}
		team++;
		startweek++;
		}
		return win;
	}

	@RequestMapping(value = "fixtures", method = RequestMethod.GET)
	public List<Fixture> list() {

		response =apiCall(0);		

		for (Fixture elem : response) {
			if (elem.getStatus().equals("TIMED")) {
				currentGameWeek = elem.getMatchday();
				System.out.println("The Game Week is currently " + elem.getMatchday());
				break;
			}

		}

		return response;
	}

	@RequestMapping(value = "fixtures/{id}", method = RequestMethod.GET)
	public Fixture get(@PathVariable int id) {
		return response.get(id);
	}
	


	@RequestMapping(value = "headtohead/{id}", method = RequestMethod.GET)
	public List<Fixture> post(@PathVariable int id) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", accessToken);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = "http://api.football-data.org/v1/fixtures/" + id;
		Fixture fixture = restTemplate.exchange(url, HttpMethod.GET, entity, Fixture.class).getBody();

		headToHeadResponse = fixture.getFixture();

		return headToHeadResponse;
	}
	
	@RequestMapping(value = "gameweek/{id}", method = RequestMethod.GET)
	public List<Fixture> postGameweek(@PathVariable int id) {
		response = apiCall(id);
		return response;
	}

	/// test method remove at the end
	@RequestMapping(value = "/ray")
	public List<Fixture> testing() {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", accessToken);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Fixture fixture = restTemplate.exchange("http://api.football-data.org/v1/competitions/426/fixtures",
				HttpMethod.GET, entity, Fixture.class).getBody();

		response = fixture.getFixtures();

		return response;

	}
	
	public static List<Fixture> apiCall(int startweek){
		
		String ApiAddress;
		
		if (startweek > 0){
			ApiAddress = "http://api.football-data.org/v1/competitions/445/fixtures?matchday=" + startweek;
		}else
			ApiAddress = "http://api.football-data.org/v1/competitions/445/fixtures";
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", accessToken);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		Fixture fixture = restTemplate.exchange(ApiAddress,
					HttpMethod.GET, entity, Fixture.class).getBody();
		
		List<Fixture> responce = fixture.getFixtures();
		
		numFixtures = fixture.getFixtures().size();
		
		return responce;
		
	}

}
