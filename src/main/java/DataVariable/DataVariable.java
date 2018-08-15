package DataVariable;

// perhaps we are making soeme changes....
public class DataVariable {

	private String WebsiteID;

	public String getWebsiteID() {
		return WebsiteID;
	}

	public void setWebsiteID(String websiteID) {
		WebsiteID = websiteID;
	}

	private String ScenarioName;

	public String getScenarioName() {
		return ScenarioName;
	}

	public void setScenarioName(String scenarioName) {
		ScenarioName = scenarioName;
	}

	private String website_id;
	private String page_number;
	private String keywords;
	private String manufacturer_name;
	private String Authorization;

	public String getWebsite_id() {
		return website_id;
	}

	public void setWebsite_id(String website_id) {
		this.website_id = website_id;
	}

	public String getPage_number() {
		return page_number;
	}

	public void setPage_number(String page_number) {
		this.page_number = page_number;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	public String getAuthorization() {
		return Authorization;
	}

	public void setAuthorization(String authorization) {
		Authorization = authorization;
	}

	@Override
	public String toString() {

		return "scenarioName= " + ScenarioName + ", website_id=" + website_id + ",page_number =" + page_number + ""
				+ ",keywords =" + keywords + ",manufacturer_name =" + manufacturer_name + ", Authorization= "
				+ Authorization + "";

	}

}