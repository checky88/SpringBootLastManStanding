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

import test.customer.CustomerStub;
import test.fixture.FixtureController;
import test.model.Customer;

@RestController
@RequestMapping("api/v1/")
public class GameController {

	public boolean responce = false;
	
	@RequestMapping(value = "game", method = RequestMethod.GET)
	public boolean DidIWin() {
		System.out.println("In game" + FixtureController.getCurrentGameWeek());
		calculateWin();
		return responce;
	}
	
	
	public void calculateWin(){
		System.out.println("calculating win");
		String TeamChosen = CustomerStub.get(1L).getTeamChoice();
		int gameweek = FixtureController.getCurrentGameWeek();
		 responce = FixtureController.getWinorLoss(gameweek, TeamChosen);
		
		
		
		 
		 
		
		 
		 
		 
	}
	
	

	
}
