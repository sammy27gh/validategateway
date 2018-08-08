package DataVariable;
import static com.jayway.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Properties;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;
import org.slf4j.*;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.slf4j.Logger;


/**
 * Verify Functions class has all the reusable functions required 
 */

public class VerifyFunctions {

	public Properties properties = null;
	public Response response = null;
	public Response responseWhen;
	private static final Logger LOGGER = LoggerFactory.getLogger(VerifyFunctions.class);

	/**
	 * Setting the value for Rest Assured Base URI  
	 * @return 
	 */

	public String baseURI() {
		try{
		properties = configProperties();
		RestAssured.baseURI = properties.getProperty("baseURI").toString();
		LOGGER.debug(RestAssured.baseURI.toString());
		if ((properties.getProperty("baseURI")).contains("api-"))
		{
            setCertification();
       } 
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return RestAssured.baseURI;
	}
	
    /**
     * Installing mutual SSL certificate for Cert environment    
     */
     public void setCertification() {
       try{
           properties = configProperties();
           KeyStore keyStore = null;
           SSLConfig config = null;
           String password = "ktCert";
           keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(
               new FileInputStream("src/test/resources/environment/CERTIFICATION/2000000500-tst.p12"), password.toCharArray());
        SSLSocketFactory clientAuthFactory = new SSLSocketFactory(keyStore, password);
        config = new SSLConfig().with().sslSocketFactory(clientAuthFactory);
        RestAssured.config = RestAssured.config().sslConfig(config);
           }
           catch(Exception e)
           {
                 LOGGER.error(e.getMessage());
           }
     }


	/**
	 * Setting the value for Rest Assured API Token URI  
	 */
	public void baseAPITokenURI() {
		try{
		properties = configProperties();
		RestAssured.baseURI = properties.getProperty("apiTokenURI");
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
	}


	/**
	 * Setting the value for Rest Assured WSO2 Sand box URI  
	 */
	public String apiAuthorization(String Ratelimit) {
		String apiAuthorization = "";
		try{
		properties = configProperties();
		apiAuthorization = properties.getProperty("apiAuthorization"+Ratelimit);
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return apiAuthorization;
	}
	
	
	/**
	 * Outputs for Response time and Response codes    
	 * @param Response response      
	 */
	public void responseObject(Response response) {
		try {
			this.response = response;
			// Response outputs
			//LOGGER.info("Response time in milliseconds: " + response.getTime());
			LOGGER.info("Response code: " + response.statusCode());
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}
	
	/**
	 * Bearer token generation
	 * @return String      
	 */
	public String fetchAPIToken(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Deals FX-Ratesheets FX-Dealing-Quotes FX-Quotes").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}
	
// fetch APi token with only scope = FX-DEALS
	
	public String fetchAPIToken_Deals(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Deals").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}

// fetch API token with only scope =  FX-Rates sheets
	public String fetchAPIToken_RatesSheet(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Ratesheets").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}

// fetch API token with only scope = FX-Dealing- Quotes
	public String fetchAPIToken_DealingQuotes(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Dealing-Quotes").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}

// fetch API token with only scope  = 	FX quotes 
	public String fetchAPIToken_FXquotes(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Quotes").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}

	// For cross api Testing for using cert as the auth code
		public String fetchAPIToken_Cert(String Ratelimit) throws Throwable {
			String bearerToken = "";
			String apiAuthorization = apiAuthorization(Ratelimit);
			try {	
				VerifyFunctions verifyfunctions = new VerifyFunctions();
				verifyfunctions.baseAPITokenURI();
				responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
						.header("Content-Type","application/x-www-form-urlencoded")
						.header("Authorization",apiAuthorization)					
						.when().post("/token?grant_type=client_credentials&scope=FX-Deals FX-Ratesheets FX-Dealing-Quotes FX-Quotes").then()
						.extract().response();
				System.out.println("GetToken");
				System.out.println(responseWhen.asString());
				 bearerToken = ((String) responseWhen.path("access_token")).trim();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return bearerToken;		
		}
	
	public String fetchAPIToken_Sandbox(String Ratelimit) throws Throwable {
		String bearerToken = "";
		String apiAuthorization = apiAuthorization(Ratelimit);
		try {	
			VerifyFunctions verifyfunctions = new VerifyFunctions();
			verifyfunctions.baseAPITokenURI();
			responseWhen = given().contentType(com.jayway.restassured.http.ContentType.JSON)
					.header("Content-Type","application/x-www-form-urlencoded")
					.header("Authorization",apiAuthorization)					
					.when().post("/token?grant_type=client_credentials&scope=FX-Quotes").then()
					.extract().response();
			System.out.println("GetToken");
			System.out.println(responseWhen.asString());
			 bearerToken = ((String) responseWhen.path("access_token")).trim();
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		return bearerToken;		
	}

	/**
	 * Load parameters value from the config.properties file   
	 * @return Properties      
	 */
	public Properties configProperties() {
		Properties properties = new Properties();
		InputStream input = null;

		try {
			String env = System.getProperty("env");
			input = new FileInputStream("src/test/resources/environment/"+env+"/config.properties");
			// load a properties file
			properties.load(input);

		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOGGER.error(e.getMessage());
				}
			}
		}
		return properties;
	}
	
	/**
	 * Setting the value for Rate Throttle Limit    
	 * @return int      
	 */
	public String rateThrottleLimit(String Ratelimit) throws Throwable {
		String rateThrottleLimit = "";
		try
		{
		properties = configProperties();
		rateThrottleLimit = properties.getProperty(Ratelimit);	
		}
		catch (Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return rateThrottleLimit;	
	}
}