package test.fixture;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/")
public class FixtureController {
	private List<String> response = new ArrayList<String>();
	
	private final String accessToken = "3acf11744bd946098fe44176f6cc51a0";

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

		/*
		 * List<Fixture> fixture = restTemplate .getForObject(
		 * "http://api.football-data.org/v1/competitions/426/fixtures?",
		 * Fixture.class) .getFixtures();
		 */

		List<Fixture> fixture = restTemplate
				.getForObject("http://api.football-data.org/v1/competitions/426/fixtures?matchday=1", Fixture.class)
				.getFixtures();

		int count = 1;

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

		/*
		 * List<String> response = new ArrayList<String>(); for (Fixture
		 * fixture: wrapper.getFixtures()){ fixtureService.save(fixture);
		 * response.add("Saved person: " + fixture.toString());
		 */

		// return response;
	}

	@RequestMapping(value = "fixtures", method = RequestMethod.GET)
	public List<Fixture> list() {
		RestTemplate restTemplate = new RestTemplate();
		
		List<Fixture> fixture = restTemplate
				.getForObject("http://api.football-data.org/v1/competitions/426/fixtures", Fixture.class)
				.getFixtures();
		
		

		return fixture;
	}

	@RequestMapping(value = "fixtures/{id}", method = RequestMethod.GET)
	public int get(@PathVariable long id) {
		System.out.println("Hello world"+id);
		
		return 0;

	}
	
	
	///test method remove at the end
	@RequestMapping(value = "/ray")
	public void testing() {
		long id = 150841;
		//Fixture.get();

		RestTemplate restTemplate = new RestTemplate();
	   
		ResponseEntity<Fixture> fixture;
	 
	    HttpHeaders httpHeaders = this.createHeaders();
	    		
	    String url = "http://api.football-data.org/v1/competitions/426/fixtures";
	    fixture = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(httpHeaders), Fixture.class);

	}
	
	
	
	private HttpHeaders createHeaders(){
	    HttpHeaders headers =  new HttpHeaders(){
	          {
	             
	             String authHeader = "X-Auth-Token " + new String( accessToken );
	             set( "Authorization", authHeader );
	          }
	       };
	       //headers.add("Content-Type", "application/xml");
	       //headers.add("Accept", "application/xml");

	       return headers;
	}



}
