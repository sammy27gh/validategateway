package ApplicationDataTest;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

import DataVariable.DataVariable;
import DataVariable.DataVariableRequest;
import DataVariable.VerifyFunctions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fileReader.FileProcessor;

public class DataVariableTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DataVariableTest.class);

	public Response responseWhen;
	public Response responseThen;
	private static VerifyFunctions verifyfunctions;

	static DataVariable javaBean;
	static List<DataVariable> requestList = new ArrayList<DataVariable>();
	static Map<String, DataVariable> dataMap = new HashMap<String, DataVariable>();

	static {
		verifyfunctions = new VerifyFunctions();
		Map<String, String> columnMapping = new HashMap<String, String>();

		columnMapping.put("scenarioName", "scenarioName");
		columnMapping.put("website_id", "website_id");
		columnMapping.put("page_number", "page_number");
		columnMapping.put("keywords", "keywords");
		columnMapping.put("manufacturer_name", "manufacturer_name");
		// columnMapping.put("Authorization", "Authorization");

		String resources = "src/test/resources/environment/";
		String testDataFile = "/testdata/testdata.csv";
		String env = System.getProperty("env");

		requestList = new FileProcessor<DataVariable>().parseCSVToBeanList(resources + env + testDataFile,
				columnMapping, DataVariable.class); 

		Iterator<DataVariable> iterator = requestList.iterator();
		while (iterator.hasNext()) {
			javaBean = iterator.next();
			dataMap.put(javaBean.getScenarioName(), javaBean);

		}
		System.out.println(javaBean);
	}

	@Given("^I have a prescription Application$")
	public void i_have_a_prescription_Application() throws Throwable {
		LOGGER.info("Validate the Login Page");
		System.out.println("Let the man says that i am strong ");
	}

	@When("^I enter the correct UserName and Password$")
	public void i_enter_the_correct_UserName_and_Password() throws Throwable {

		try {
			// LOGGER.info("When I send a valid Get_Quote all the request fields");
			String ScenarioName = "Validate the UserName and Password";
			// LOGGER.debug("Input test data is: " + dataMap.get(ScenarioName));

			Headers requestHeaders = DataVariableRequest.createRequestHeader(dataMap.get(ScenarioName));
			Headers pathParameter = DataVariableRequest.createRequestParametersBase(dataMap.get(ScenarioName));
			// Headers requestHeaders1 =
			// DataVariableRequest.anotherRequestBody(datavariables)

			System.out.println(requestHeaders);
			System.out.println(pathParameter);

			// System.out.println(verifyfunctions.baseURI());
			verifyfunctions.baseURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.queryParam("website-id", 8037253).queryParam("page-number", 2).queryParam("keywords", "printers")
					.queryParam("manufacturer-name", "HP")

					// .headers(pathParameter)
					.headers(requestHeaders).when().get("/v2/product-search").then().statusCode(200).extract()
					.response();
		} catch (Exception e) {
			// LOGGER.error(e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail();
		}
		responseThen = responseWhen;
		System.out.println(responseThen.asString().toString());
	}

	@Then("^I should be able to see the HomePage$")
	public void i_should_be_able_to_see_the_HomePage() throws Throwable {

		try {
			// LOGGER.info("Then I receive valid Get_Quote response along with all
			// applicable fields");
			if (responseThen != null) {
				// LOGGER.info("Total Response for Get_Quote is: " + responseThen.asString());
				// String ScenarioName = "Send valid Get_Quote data";
				// Response outputs
				// verifyfunctions.responseObject(responseThen);
				// Assert True/False/Equals validations
				// Assert.assertTrue(responseThen.asString().contains("885631448229"));
				Assert.assertTrue(responseThen.asString().contains("HP"));
				// Assert.assertTrue(responseThen.asString().contains("contra_currency_code"));
				// Assert.assertTrue(responseThen.asString().contains("buy_or_sell"));
				// Assert.assertTrue(responseThen.asString().contains("base_currency_code"));
				// Assert.assertTrue(responseThen.asString().contains("contra_currency_code"));

			} else {
				Assert.fail();
			}

		} catch (Exception e) {
			e.getMessage();
			// LOGGER.error(e.getMessage());
			Assert.fail();
		}

	}

	@Given("^I enter an invalid userName and Password$")
	public void i_enter_an_invalid_userName_and_Password() throws Throwable {
		LOGGER.info("I want enter my userName and password");

	}

	@When("^i initiate the tool$")
	public void i_initiate_the_tool() throws Throwable {

		String intentionally = null;
		String itemName = "food";
		if (itemName.equals(intentionally)) {

			LOGGER.info(itemName);
		}
	}

	@Then("^I should be able to guide the tool$")
	public void i_should_be_able_to_guide_the_tool() throws Throwable {

		if (responseThen != null) {
			Assert.assertTrue(responseThen.asString().contains("HP"));
		}
	}

}
