package test.fixture;

import java.lang.reflect.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {

	private List<Links> _links;
	private Self self;
		
	
		public Self getSelf() {
		return self;
	}

	public void setSelf(Self self) {
		this.self = self;
	}

		public List<Links> get_links() {
			return _links;
		}
	
		public void set_links(List<Links> _links) {
			this._links = _links;
		}

	
	

	






}
