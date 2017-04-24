package test.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/hello")
	public String sayHi(){
		return "hi";
	}
}
