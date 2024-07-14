package com.rsa.Dropdowns;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		try {
//		driver.get("https://www.spicejet.com/");
//		//Thread.sleep(10000);
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		Alert alert =wait.until(ExpectedConditions.alertIsPresent());
//		System.out.println("------>Alert Texty "+ alert.getText());
//		driver.switchTo().alert().accept();
//		}
//		catch(Exception e) {
//			System.out.println("text= "+e.getMessage());
//		}
//		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.findElement(By.className("css-1dbjc4n"));
//		driver.findElement(By.xpath("//div[text()='Goa Airport']")).click();
//		driver.findElement(By.xpath("//div[text()='TIR']")).click();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(5000);
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//li[.=' Goa (GOI)']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();// Using parent to child releation with using index
		Thread.sleep(2000);
		WebElement currentDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
		Thread.sleep(2000);
		currentDate.click();
		
		
		System.out.println(currentDate.getText()); 
		driver.close();

	}

}
