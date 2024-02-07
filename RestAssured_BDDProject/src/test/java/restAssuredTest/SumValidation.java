package restAssuredTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import apiFiles.Payload;
import io.restassured.path.json.*;

public class SumValidation {
SoftAssert st = new SoftAssert();
	@Test
	public void sumOfCourses() {
		int sum=0;
		JsonPath js = ReUsableMethods.jsonResponse(Payload.CoursePrice());
		int count = js.getInt("courses.size()");
		System.out.println("course in the API are " +count);
		
		
		for(int i=0;i<count;i++) {
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price*copies;
			sum=sum+amount;		}
		int expsum = js.getInt("dashboard.purchaseAmount");
		System.out.println(sum);
	st.assertEquals(sum, 910,"sum does not match");
	st.assertEquals(sum, expsum);
	st.assertAll();
		
	}
	
}
