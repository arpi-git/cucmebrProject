package restAssuredTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.asserts.SoftAssert;

import apiFiles.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

public class ExtractResponseForPostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick").header("Content-Type","application/json").body(Payload.postRequest())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		
		System.out.println(response);
		
		
		JsonPath js = new JsonPath(response);//parse json
		String pid = js.getString("place_id");
		System.out.println(pid);
		
		
		String newAdd = "701 winter walk, USA";
		given().queryParam("key", "qaclick").header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+pid+"\",\r\n"
				+ "\"address\":\""+newAdd+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		


		
		
		  
		  String getResp = given().log().all().queryParam("key", "qaclick123").
				  queryParam("place_id",pid)
		  .when().get("maps/api/place/get/json")
		  .then().assertThat().log().all().statusCode(200).extract().response().asString();
		 
		JsonPath jsonResponse = ReUsableMethods.jsonResponse(getResp);
	///JsonPath js1 = new JsonPath(getResp);//instaed this line added above reusable method
	String ActualAdd = jsonResponse.getString("address");
		System.out.println(ActualAdd);
		
		SoftAssert st = new SoftAssert();
		st.assertEquals(newAdd, ActualAdd,"address not matched");
		
		st.assertAll();
		
	}

}
