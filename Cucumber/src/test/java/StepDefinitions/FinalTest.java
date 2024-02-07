package StepDefinitions;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
///import org.openqa.selenium.chrome.ChromeDriver;
///import org.openqa.selenium.interactions.Actions;

import Pages.HomePage;
//import io.cucumber.java.en.And;
///import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FinalTest{
	WebDriver driver;	
	String string,button;
HomePage homePage;

	@Given("I open Url {string}")
		public void openURL(String string) {
		homePage= new HomePage();
		homePage.openHomePage(string);
		homePage.takeScreenshot();
		}
	
	
	@When ("I move mouse on {string}")
	public void clickButton(String button) {
	//	Actions actions = new Actions(driver);
		homePage.moveMouseToButton(button);
		
		driver.quit();
		
		}
	
	///from call
	 @Then("I navigate to {string} page")

	    public void i_navigate_to(String pageName) {

	     //   homePage.VerifyNavigatedTo(pageName);

	    }

	 

	    @Then("I verify Page Url {string}")

	    public void i_verify_page_url(String string) {

	        // Write code here that turns the phrase above into concrete actions

	        throw new io.cucumber.java.PendingException();

	    }

	 

	 

	    @Then("I close Application")

	    public void iCloseApplication() {

	       /// homePage.quitApp();

	    }

}





///driver.findElement(By.xpath("//li[contains(text(),\"People Management\")]/ancestor::li[@class=\"nav-item\"]")).click();
//driver.findElement(By.xpath("//a[contains(text(),\"HR Administration\")]/ancestor::h6[@class=\"list-sub-menu-title\"]")).click();