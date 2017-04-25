package test.model;

public class Customer {
	Long id;
	String name;
	String email;
	String teamChoice;
	
	
	public Customer() { }

	public Customer(Long i,String name,String email,String teamChoice) {
		this.id = i;
		this.name = name;
		this.email = email;
		this.teamChoice = teamChoice;
	}

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTeamChoice() {
		return teamChoice;
	}
	public void setTeamChoice(String teamChoice) {
		this.teamChoice = teamChoice;
	}

	
	
}
