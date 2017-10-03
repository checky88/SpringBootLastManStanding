package test.competition;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@EnableAutoConfiguration(exclude = HypermediaAutoConfiguration.class)
public class Competition {

	// for the time being setting to 5 will revist and let master enter start week
	private int startWeek = 5;
	
	public Competition(int startWeek) {
		this.startWeek = 5;
	}

	public int getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	
}
