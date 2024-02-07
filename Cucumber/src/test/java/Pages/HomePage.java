package Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
	//xpath for all the element in homepage
	String moveToSolutionButton = "//a[text()='Solutions']";
	String peopleManagementMenu = "//li[contains(text(),'People Management')]";
	String hrAdminMenu = "//h6/a[contains(text(),'HR Administration')]";
	
	
	public void openHomePage(String string) {
		//driver = new ChromeDriver();
		driver.get(string);
		driver.manage().window().maximize();
		
	}
	
	public void takeScreenshot(){
		((TakesScreenshot) driver).getScreenshotAs(  
                OutputType.FILE);
        System.getProperty("user.dir");
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(SrcFile, new File("A://DemoScreenShots//OrangeHomePage2.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
	}
	
	public void moveMouseToButton(String button) {
		Actions actions = new Actions(driver);
		
		switch(button){
		case "Solutions":
			WebElement solutions = driver.findElement(By.xpath(moveToSolutionButton));
			actions.moveToElement(solutions);
			actions.build().perform();
			break;
		case "People Management":
			WebElement peopleManagement = driver.findElement(By.xpath(peopleManagementMenu));
			actions.moveToElement(peopleManagement);
			actions.build().perform();
			break;
			
		case "HR Administrator":
			WebElement hrAdmin = driver.findElement(By.xpath(hrAdminMenu));
			actions.moveToElement(hrAdmin);
			actions.build().perform();
			//actions.moveToElement(hrAdmin).click();
			break;
			
		}
		
	}
	
	
	
	
	
}
