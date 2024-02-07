package restAssuredTest;

import org.testng.Assert;

import apiFiles.Payload;
import io.restassured.path.json.JsonPath;

public class ComplextJsonParse {
public static void main(String[] args) {
	
	JsonPath js = ReUsableMethods.jsonResponse(Payload.CoursePrice());
	
	int count = js.getInt("courses.size()");
	System.out.println("course in the API are " +count);
	
	int amount = js.getInt("dashboard.purchaseAmount");
	System.out.println("Purchase amount is " +amount);
	
	
	for(int i =0 ;i<count;i++) {
	String title =js.get("courses["+i+"].title");
	int bookPrice = js.getInt("courses["+i+"].price");
	System.out.println("book " +title +" price is " +bookPrice);
	}
	
	int RPACopiesSold = js.getInt("courses[2].copies");
	System.out.println("RPA copies sold are " +RPACopiesSold);
	
	for(int i =0 ;i<count;i++) {
		String coursetitle =js.get("courses["+i+"].title");
		if(coursetitle.equalsIgnoreCase("RPA")) {
			int RPAcopies = js.getInt("courses["+i+"].copies");
			System.out.println("RPA copies sold are value without direct index are " +RPAcopies);
			break;
		}
		
	}

	int sum=0;
	for(int i =0 ;i<count;i++) {
		
		int bookPrice = js.getInt("courses["+i+"].price");
		int copies = js.getInt("courses["+i+"].copies");
		int totalPrice = bookPrice*copies;
		sum = sum+totalPrice;
		}
	System.out.println(sum);
	Assert.assertEquals(sum, amount," purchase amount does notmatch with actual amount");
	
	
}
	
	
	
	
}
