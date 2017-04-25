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
	
	private final String accessToken = "3acf11744bd946098fe44176f6cc51a0";
	
	private static int currentGameWeek = 0;

	public static int getCurrentGameWeek() {
		return currentGameWeek;
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

	@RequestMapping("/fixture")
	public List<String> showFixture() {
		RestTemplate restTemplate = new RestTemplate();

		List<Fixture> fixture = restTemplate
				.getForObject("http://api.football-data.org/v1/competitions/426/fixtures?matchday=1", Fixture.class)
				.getFixtures();
		 List<String> response = new ArrayList<String>();

		for (Fixture elem : fixture) {
			response.add(elem.getHomeTeamName() + " V  " + elem.getAwayTeamName());
			if (elem.getMatchday() == 1) {
				// response.add(elem.getHomeTeamName() + " V " +
				// elem.getAwayTeamName());
				// System.out.println(elem.getResult().getGoalsAwayTeam()+"RESULT
				// ...... ");
				System.out.print(elem.getHomeTeamName() + " V  " + elem.getAwayTeamName());
				if (elem.getResult().getGoalsHomeTeam() > elem.getResult().getGoalsAwayTeam()) {
					System.out.println(" The Winner Was " + elem.getHomeTeamName());
				} else if (elem.getResult().getGoalsHomeTeam() < elem.getResult().getGoalsAwayTeam()) {
					System.out.println(" The Winner Was " + elem.getAwayTeamName());
				} else {
					System.out.println(" It was a DRAW ");
				} // end else

			} // end if
		} // end for

		return response;


	}

	@RequestMapping(value = "fixtures", method = RequestMethod.GET)
	public List<Fixture> list() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", accessToken);
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		Fixture fixture  = restTemplate.exchange("http://api.football-data.org/v1/competitions/426/fixtures", HttpMethod.GET, entity , Fixture.class).getBody();
		
		response = fixture.getFixtures();
		
		for (Fixture elem : response) {
			if(elem.getStatus().equals("TIMED") && currentGameWeek == 0 ){
				currentGameWeek=elem.getMatchday();
				System.out.println("The Game Week is currently " + elem.getMatchday());
			}
			
		}
        
		return response;
	}

	@RequestMapping(value = "fixtures/{id}", method = RequestMethod.GET)
	public int get(@PathVariable int id) {
		 response.get(id);
		
		System.out.println("Hello world"+id);
		
		return 0;

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
