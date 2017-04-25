package test.fixture;

import java.util.List;

public class Self {
	private List<Self> self;
	private String href;
	
	public List<Self> getSelf() {
		return self;
	}
	public void setSelf(List<Self> self) {
		this.self = self;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	

}
