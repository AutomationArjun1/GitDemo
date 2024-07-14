package com.rsa.quiz;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingAllItems {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new  ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		//select radio button
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		Thread.sleep(3000);
		WebDriverWait w= new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		//dropdown
		WebElement option = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(option);
		dropdown.selectByValue("consult");
		
		//sign in
		Thread.sleep(3000);
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
		 List<WebElement> products =driver.findElements(By.cssSelector(".btn.btn-info"));
		 for (int i = 0; i < products.size(); i++) {
			products.get(i).click();
		}
		 driver.findElement(By.partialLinkText("Checkout")).click();
	}

}
