package restAssuredTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import apiFiles.Payload;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class DynamicJsonWithDataProvider {

	@Test(dataProvider="bookData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI ="http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json").
		body(Payload.AddBook(isbn,aisle)).
		when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).
		extract().asString();
		
		JsonPath js = ReUsableMethods.jsonResponse(response);
		Object id = js.get("ID");
		System.out.println(id);
		
		
	}
	
	
	@Test(dataProvider="bookData")
	public void deleteBook(String isbn, String aisle) {
		RestAssured.baseURI ="http://216.10.245.166";
		String id = isbn+aisle;
		System.out.println(id);
		String respDelete = given().log().all().header("Content-Type","application/json").
		body(Payload.DeleteBook(id)).
		when().post("Library/DeleteBook.php").then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath jsDelete = ReUsableMethods.jsonResponse(respDelete);
		Object dltmsg = jsDelete.get("msg");
		System.out.println("id- "+id+ " has been update with API message " +dltmsg);
	
	}
	
	
	
	
	//arrays is collection of elements
	@DataProvider(name ="bookData")
	public Object[][] getData() {
		Object[][] arr = {{"ar","123"},{"ni","345"},{"sa","321"},{"jh","546"}};

		return arr;
	}
	
	
	
	
	
	
}
