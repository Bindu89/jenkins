package com.trainning.AutomateFireBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class tc1  {
	

	static ExtentReports extent;
	static ExtentTest homeTest;
	
	public static void main(String[] args) throws InterruptedException {
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/tc1.html",true);
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dsp40\\eclipse-workspace\\\\Selenium\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		homeTest=extent.startTest("Launch Application");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://selenium-prd.firebaseapp.com/");
        
		System.out.println("Application Launched Successfully");
		Thread.sleep(5000);
		
		//Enter the Username
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		emailUserName.sendKeys("admin123@gmail.com");
		homeTest.log(LogStatus.PASS,"username entered successfully");
		System.out.println("username entered successfully");
		
		//Enter the Password
		WebElement password=driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		System.out.println("password entered successfully");
		
		//Click on login Button
		WebElement loginButton=driver.findElement(By.xpath("//button[@onclick='login()']"));
		loginButton.click();
		System.out.println("User logged in Successfully");
		homeTest.log(LogStatus.PASS,"Button Clicked successfully");
		
		//click on HOme Tab
		Thread.sleep(5000);
		WebElement HomeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		HomeTab.click();
		System.out.println("HomeTab is clicked Successfully");
		
		//Enter the Name
		WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
		Name.clear();
		Name.sendKeys("bindu");
		
		//Enter Father Name
		WebElement FatherName = driver.findElement(By.xpath("//input[@id='lname']"));
		FatherName.clear();
		FatherName.sendKeys("sivayya");
		
		//Enter Postal Code
		WebElement postalCode = driver.findElement(By.id("postaladdress"));
		postalCode.clear();
		postalCode.sendKeys("92081");
		
		//Enter Personal address
		WebElement personalAddress = driver.findElement(By.id("personaladdress"));
		personalAddress.clear();
		personalAddress.sendKeys("california");
		//Radio BUtton
		WebElement GenderFemale = driver.findElement(By.xpath("//input[@value='female']"));
		GenderFemale.click();
		//select the City from the dropdown
		Select City =new Select(driver .findElement(By.name("city")));
		City.selectByVisibleText("MUMBAI");
		Select Course=new Select(driver.findElement(By.name("course")));
		Course.selectByValue("mba");
		//select the district from drop down
		Select district = new Select(driver.findElement(By.id("district")));
		district.selectByValue("mumbai");
		Select State = new Select(driver.findElement(By.id("state")));
		State.selectByValue("bca");
		//Key in pincode
		WebElement pincode = driver.findElement(By.xpath("//input[@id='pincode']"));
		pincode.clear();
		pincode.sendKeys("77494");
		//Key in emailid
		WebElement email = driver.findElement(By.xpath("//input[@id='emailid']"));
		email.clear();
		email.sendKeys("bin4585@gmail.com");
		//Click Submit
		 WebElement Submit = driver.findElement((By.xpath("//button[@class='bootbutton']")));
		Submit.click();
		//-----------------------------------------------------------------//
		//switch to Alert and print the text from the Alert
		WebElement SwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		SwitchTo.click();
		WebElement Alert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		Alert.click();
		WebElement WindowsAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		WindowsAlert.click();
		
		Alert windowsAlert = driver.switchTo().alert();
			
		String alertText = windowsAlert.getText();
		System.out.println("Alert Text is" +alertText);
		Thread.sleep(4000);
		windowsAlert.accept();
		//switch to prompt Alert and dismiss the text from the Alert
		WebElement promtAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
        promtAlert.click();
        Thread.sleep(4000);
        Alert promptalert = driver.switchTo().alert();
        Thread.sleep(4000);
        promptalert.sendKeys("bindu");
        Thread.sleep(4000);
        promptalert.accept();
        extent.endTest(homeTest);
        extent.flush();
        extent.close();
        driver.close();
       }

}	}