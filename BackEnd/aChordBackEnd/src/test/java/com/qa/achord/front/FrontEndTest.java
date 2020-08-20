//package com.qa.achord.front;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//
//public class FrontEndTest {
//	
//static ChromeDriver driver;
//	
//	@Before
//	public void init() {
//		System.setProperty("webdriver.chromer.driver", "D:\\QA\\aChord\\BackEnd\\aChordBackEnd");
//		
//		 driver = new ChromeDriver();
//		
//	}
//	
//	
//	@AfterClass
//	public static void deleteTestUser() {
//		 driver = new ChromeDriver();
//		
//		WebElement target;
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/Login.html");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/input");
//		target.sendKeys("admin");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/input");
//		target.sendKeys("secret");
//		
//		driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[3]/div[1]/input").click();
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/adminUsers.html");
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		
//		driver.findElementById("deleteThis").click();
//		
//	}
//	
//	
//	@Test
//	public void register() throws InterruptedException{
//		WebElement target;
//		
//		/////////////////////////register
//		driver.get("file:///D:/QA/aChord/FrontEnd/Register.html");
//
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/div[1]/div/input");
//		target.sendKeys("testFirstname");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/div[2]/div/input");
//		target.sendKeys("testLastname");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/div[1]/div/input");
//		target.sendKeys("testUsername");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/div[2]/div/input");
//		target.sendKeys("testPassword");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[3]/div/div/input");
//		target.sendKeys("testEmail@test.com");
//		
//		driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[4]/div[1]/input").click();
//		
//		
//	}
//	
//	@Test
//	public void viewCourseChord() throws InterruptedException{
//		WebElement target;
//		
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/Login.html");
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/input");
//		target.sendKeys("testUsername");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/input");
//		target.sendKeys("testPassword");
//		driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[3]/div[1]/input").click();
////		
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElementByXPath("/html/body/header/nav[1]/div/ul[1]/li[1]/a/h5").click();
//////
//////		
//////		
//////	
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElementByXPath("/html/body/div[1]/div[2]/div[1]/div/a[2]").click();
////	
////		driver.findElementByXPath("/html/body/div[1]/div[2]/button").click();
////		
//		
//	}
//	
//	@Test
//	public void viewAllChord() throws InterruptedException{
//		WebElement target;
//		
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/Login.html");
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/input");
//		target.sendKeys("testUsername");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/input");
//		target.sendKeys("testPassword");
//		driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[3]/div[1]/input").click();
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/allChords.html");
////		
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElementByXPath("/html/body/header/nav[1]/div/ul[1]/li[1]/a/h5").click();
//////
//////		
//////		
//////	
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElementByXPath("/html/body/div[1]/div[2]/div[1]/div/a[2]").click();
////	
////		driver.findElementByXPath("/html/body/div[1]/div[2]/button").click();
////		
//		
//	}
//	
//	@Test
//	public void viewMyProfile() throws InterruptedException{
//		WebElement target;
//		
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/Login.html");
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[1]/input");
//		target.sendKeys("testUsername");
//		
//		target = driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[2]/input");
//		target.sendKeys("testPassword");
//		driver.findElementByXPath("/html/body/div[1]/div/div/fieldset/div[3]/div[1]/input").click();
//		
//		driver.get("file:///D:/QA/aChord/FrontEnd/MyProfile.html");
//	
//		
//	}
//	
////	@Test
////	public void EndTest() throws InterruptedException{
////		WebElement target;
////		
////		
////		driver.get("file:///D:/QA/aChord/FrontEnd/Login.html");
////	
////		
////	}
//
//}
