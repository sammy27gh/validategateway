package ApplicationDataTest;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class visionTest {

	public Response responseWhen;
	public Response responseThen;
	
	@Test
	public void firstTest() {
		
		try { 
		String ScenarioName = "Given that i have a valid test";
		given().contentType(com.jayway.restassured.http.ContentType.JSON).queryParam("website-id", 8037253)
				.queryParam("page-number", 2).queryParam("keywords", "printers").queryParam("manufacturer-name", "HP")
				.headers("Authorization",
						"00806df857c2f579e0fe2ba2ba82c5f0425fc6689295cfb50b2b81180a973d5fb7d98c5bfeeaa92ce2f778b5a3cfb2ade16081236993d3640e78c7215bf246dbcb/1095a2df3a66d6b14e4136475d81d00fd22c5deea7f7e58a26b909f0bc2d09c215b8e1dbb7f9051a40ef9a494a3fe2c761a5fdef869bcb04a6146f9a84dd33a1")
				.when()
				.get("https://product-search.api.cj.com/v2/product-search")
				.then().statusCode(200)
				.extract().response();
		
		} catch (Exception e) {
			//LOGGER.error(e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail();
		}
		responseThen = responseWhen;
     System.out.println(responseThen.asString().toString());
	//return null;
	}


	}

