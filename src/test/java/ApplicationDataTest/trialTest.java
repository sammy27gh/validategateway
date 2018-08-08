package ApplicationDataTest;

import static com.jayway.restassured.RestAssured.given;

import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;

import DataVariable.DataVariableRequest;

public class trialTest {
	public static Response responseWhen;
	public Response responseThen;
	public static void main(String args []){
				  // System.out.println(verifyfunctions.baseURI());
	String BaseURL= "	https://product-search.api.cj.com/v2/product-search?website-id=8037253&page-number=2&keywords=printers&manufacturer-name=HP";
					responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
		             .headers("Authorization","0091bf6a5a0837a5f8f7f630a1a1149722c4a44d896159125fa94259ec880bda4f9af54a41ff397dc9547ebfe8bf419392e015afd8b696709cb26451c1633cf0a5/01a66f27d1cbff7f101fa371510790a67e1f76194616e2145f3037206c71e5e8d8728b6b1773852dacb23ffadd8e22943df7c8d8077e4ed2c5ddd070a42e3e81" )
		             .when()
		             .get(BaseURL)
		             .then()
					.statusCode(200)
					.extract()
					.response();
					System.out.println(responseWhen.asString().toString());
	}
	
}
