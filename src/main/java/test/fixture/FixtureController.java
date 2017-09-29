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

import test.model.Customer;

@RestController
@RequestMapping("api/v1/")
public class FixtureController {
	
	private List<Fixture> response;
	
	private List<Fixture> headToHeadResponse;
	private final String accessToken = "3acf11744bd946098fe44176f6cc51a0";
	
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
				.getForObject("http://api.football-data.org/v1/competitions/426/fixtures", Fixture.class)
				.getFixtures();
		for (Fixture elem : fixture) {
			//System.out.println(elem.getLinks());
		}
		
		
		return fixture;

	}

	@RequestMapping("/winorloss")
	public static boolean getWinorLoss(int gameweek, String TeamChosen) {
		RestTemplate restTemplate = new RestTemplate();

		List<Fixture> fixture = restTemplate
				.getForObject("http://api.football-data.org/v1/competitions/426/fixtures?matchday=1", Fixture.class)
				.getFixtures();
		 List<String> response = new ArrayList<String>();
		 List<String> winners = new ArrayList<String>();
		 boolean win = false;
				
		for (Fixture elem : fixture) {
			response.add(elem.getHomeTeamName() + " V  " + elem.getAwayTeamName());
			if (elem.getMatchday() == gameweek) {
				// response.add(elem.getHomeTeamName() + " V " +
				// elem.getAwayTeamName());
				// System.out.println(elem.getResult().getGoalsAwayTeam()+"RESULT
				// ...... ");
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
			} // end if
		} // end for
		
		if(winners.contains(TeamChosen)){
			System.out.println("You Win");
			win = true;
			return win;
		}
		else{
			System.out.println("You Loose");
			win = false;
			return win;
		}


	}

	@RequestMapping(value = "fixtures", method = RequestMethod.GET)
	public List<Fixture> list() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Auth-Token", accessToken);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Fixture fixture  = restTemplate.exchange("http://api.football-data.org/v1/competitions/426/fixtures", HttpMethod.GET, entity , Fixture.class).getBody();
		
		response = fixture.getFixtures();
		
		numFixtures = fixture.getFixtures().size();
		
		for (Fixture elem : response) {
			if(elem.getStatus().equals("TIMED") && currentGameWeek == 0 ){
				currentGameWeek=elem.getMatchday();
				System.out.println("The Game Week is currently " + elem.getMatchday());
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
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", accessToken);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		String url = "http://api.football-data.org/v1/fixtures/"+id;
		Fixture fixture  = restTemplate.exchange(url, HttpMethod.GET, entity , Fixture.class).getBody();
		
		headToHeadResponse = fixture.getFixture();
		
		return headToHeadResponse;
	}
	
	
	
	///test method remove at the end
	@RequestMapping(value = "/ray")
	public List<Fixture> testing() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", accessToken);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Fixture fixture  = restTemplate.exchange("http://api.football-data.org/v1/competitions/426/fixtures", HttpMethod.GET, entity , Fixture.class).getBody();
		
		response = fixture.getFixtures();

		return response;

	}
	
	
	




}
