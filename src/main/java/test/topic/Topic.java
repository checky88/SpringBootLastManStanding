package test.topic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Topic {

	private String id;
	private String name;
	private String discription;

	public Topic() {

	}

	public Topic(String id, String name, String discription) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
	}

	public String getDiscription() {
		return discription;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
