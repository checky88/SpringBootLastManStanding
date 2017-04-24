package test.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return Arrays.asList(
				new Topic("srping", "Spring Framework", "Spring Framework Description"));
				
	}
	
	
	@RequestMapping("/showme")
	public String show(){
		RestTemplate restTemplate = new RestTemplate();
		/*ResponseEntity<List<Topic>> rateResponse =
		        restTemplate.exchange("https://bitpay.com/api/rates",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Topic>>() {
		            });
		List<Topic> rates = rateResponse.getBody();
		System.out.println("topic = " + rates);
		
		for(Topic elem : rates){
	        System.out.println(elem+"  ");
		}*/
		
		//http://api.citybik.es/v2/networks/dublinbikes
		 Topic[] topic = restTemplate.getForObject("http://localhost:8888/topics", Topic[].class);
	       // System.out.println("Name:    " + topic[0].getName());
	
	        for(int i = 0; i<topic.length; i++){
		        System.out.println(topic[i].getName()+" LOOPING ");
	        }
		/*
		 * RestTemplate restTemplate = new RestTemplate();
		Topic topic = restTemplate.getForObject("http://localhost:8888/topics", Topic.class);
		System.out.println("topic = " + topic.getName());
		*/
		
		return "hi";
	}
}
