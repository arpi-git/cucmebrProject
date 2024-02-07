package restAssuredTest;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import apiFiles.Payload;


public class PostRequestFromOtherFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json").body(Payload.postRequest())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"));
		
		
		
		
	}

}
