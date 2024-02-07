package org.example;

 

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class ScreenShotsDemo {
 
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orangehrm.com/");
         Thread.sleep(5000);
 
//        String str = System.getProperty("user.dir") + "/"; // Current dir
 
        ((TakesScreenshot) driver).getScreenshotAs(  
                OutputType.FILE);
        System.getProperty("user.dir");
        File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile, new File("A://DemoScreenShots//OrangeHomePage.jpeg"));

        driver.quit();

    }

}