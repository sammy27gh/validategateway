package DataVariable;

import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;

public class DataVariableRequest {

	public static String createRequestBody(DataVariable datavariable) {

		String request = "{\"getWebsite_id\": {\"client_name\": \"" + datavariable.getWebsite_id()
				+ "\", \"Page_number\": \"" + datavariable.getPage_number() + "\", \"Keywords\" : \""
				+ datavariable.getKeywords() + "\" , \"Manufacturer_name\": [{\"issued_id_type\": \""
				+ datavariable.getManufacturer_name() + "\", \"Authorization\": \"" + datavariable.getAuthorization()
				+ "\"} ] }";

		return request;

	}

	private static VerifyFunctions verifyfunctions;

	public static Headers createRequestHeader(DataVariable datavariable) throws Throwable {
		verifyfunctions = new VerifyFunctions();
		// String bearerToken = verifyfunctions.fetchAPIToken("Unlimit");
		// Header reqIdHdr = new Header("request-id",
		// java.util.UUID.randomUUID().toString());
		// Header gtwCmpnyIdHdr = new Header("gateway-company-id",
		// datavariable.getAuthorization());
		// Header gtwUsrIdHdr = new Header("gateway-user-id",
		// datavariable.getGateway_user_id());
		// Header sessionIdHdr = new Header("session-id", datavariable.getSessionId());
		Header authorizationKeyHdr = new Header("Authorization",
				/* "Bearer  "+ bearerToken */"0091bf6a5a0837a5f8f7f630a1a1149722c4a44d896159125fa94259ec880bda4f9af54a41ff397dc9547ebfe8bf419392e015afd8b696709cb26451c1633cf0a5/01a66f27d1cbff7f101fa371510790a67e1f76194616e2145f3037206c71e5e8d8728b6b1773852dacb23ffadd8e22943df7c8d8077e4ed2c5ddd070a42e3e81");
		Headers headers = new Headers(/* reqIdHdr,gtwCmpnyIdHdr, gtwUsrIdHdr, sessionIdHdr, */ authorizationKeyHdr);
		return headers;

	}

	public static Headers createRequestParametersBase(DataVariable datavariable) {

		// Header reqIdHdr = new Header("website-id",
		// java.util.UUID.randomUUID().toString());
		Header reqIdHdr = new Header("website-id", datavariable.getWebsiteID());
		Header gtwCmpnyIdHdr = new Header("page-number", datavariable.getPage_number());
		Header gtwUsrIdHdr = new Header("keywords", datavariable.getKeywords());
		Header sessionIdHdr = new Header("manufacturer-name", datavariable.getManufacturer_name());
		// Header authorizationKeyHdr = new Header("Authorization", "Bearer "+
		// datavariable);
		Headers headers = new Headers(reqIdHdr, gtwCmpnyIdHdr, gtwUsrIdHdr, sessionIdHdr);
		return headers;

	}

}