package restAssuredTest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import apiFiles.Payload;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class DynamicJson {

	@Test
	public void addBook() {
		RestAssured.baseURI ="http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").
		body(Payload.AddBook("abc","1234")).
		when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).
		extract().asString();
		
		JsonPath js = ReUsableMethods.jsonResponse(response);
		Object id = js.get("ID");
		System.out.println(id);
	}
}
