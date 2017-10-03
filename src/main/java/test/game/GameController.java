package test.game;

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
import test.customer.CustomerStub;
import test.fixture.FixtureController;
import test.model.Customer;

@RestController
@RequestMapping("api/v1/")
public class GameController {

	public static boolean responce = false;
	
	@RequestMapping(value = "game", method = RequestMethod.GET)
	public static boolean DidIWin(int startWeek, Long id) {
		System.out.println("In game" + FixtureController.getCurrentGameWeek());
		System.out.println("calculating win");
		List<String> TeamChosen = CustomerStub.get(id).getTeamChoice();
		int gameweek = FixtureController.getCurrentGameWeek();
		responce = FixtureController.evaluateAllFixtures(startWeek,gameweek, TeamChosen);
		return responce;
	}
		
	
}
