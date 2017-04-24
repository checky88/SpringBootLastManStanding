package test.fixture;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

	private List<Links> _links;
	private String href;
	
	 @JsonProperty("href")
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@JsonProperty("_links")
	public List<Links> getLinks() {
		return _links;
	}
	@JsonProperty("_links")
	public void setLinks(List<Links> _links) {
		this._links = _links;
	}

	
	

}
