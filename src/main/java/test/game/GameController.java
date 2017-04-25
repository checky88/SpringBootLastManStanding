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

import test.fixture.FixtureController;

@RestController
@RequestMapping("api/v1/")
public class GameController {

	
	
	@RequestMapping(value = "game", method = RequestMethod.GET)
	public int gameWeek() {
		FixtureController.getCurrentGameWeek();
		System.out.println("In game" + FixtureController.getCurrentGameWeek());
		return FixtureController.getCurrentGameWeek();
	}

	
}
