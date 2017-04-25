package test.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.model.Customer;

public class CustomerStub {
	private static Map<Long, Customer> custs = new HashMap<Long, Customer>();
	private static Long idIndex = 3L;

	//populate initial customers
	static {
		Customer a = new Customer(1L, "Raymond Kelly","Raykelly@email.com","Hull");
		custs.put(1L, a);
		Customer b = new Customer(2L, "Raymond Kelly","Raykelly@email.com","Hull");
		custs.put(2L, b);
		Customer c = new Customer(3L, "Raymond Kelly","Raykelly@email.com","Hull");
		custs.put(3L, c);
		
	}

	public static List<Customer> list() {
		return new ArrayList<Customer>(custs.values());
	}

	public static Customer create(Customer cust) {
		idIndex += idIndex;
		cust.setId(idIndex);
		custs.put(idIndex, cust);
		return cust;
	}

	public static Customer get(Long id) {
		return custs.get(id);
	}

	public static Customer update(Long id, Customer cust) {
		custs.put(id, cust);
		return cust;
	}

	public static Customer delete(Long id) {
		return custs.remove(id);
	}
}
