package test.customer;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.model.Customer;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {

	
	@RequestMapping(value = "customers", method = RequestMethod.GET)
	public List<Customer> list(){
		//System.out.println(CustomerStub.list());
		return CustomerStub.list();
	}
	
	
	@RequestMapping(value = "customers", method = RequestMethod.POST)
	public Customer create(@RequestBody Customer customer){
		return CustomerStub.create(customer);
	}
	
	@RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
	public Customer get(@PathVariable long id){
		return CustomerStub.get(id);
		
	}
	
	@RequestMapping(value = "customers/{id}", method = RequestMethod.PUT)
	public Customer update(@PathVariable long id, @RequestBody Customer customer){
		return CustomerStub.update(id, customer);
	}
	
	@RequestMapping(value = "customers/{id}", method = RequestMethod.DELETE)
	public Customer delete(@PathVariable long id){
		return CustomerStub.delete(id);
		
	}
}
