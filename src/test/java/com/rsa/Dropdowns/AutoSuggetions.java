package com.rsa.Dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetions {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		List<WebElement> options = driver.findElements(By.xpath
				("li[@class='ui-menu-item']//a"));
		for (WebElement option : options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
				System.out.println("test");
				break;
			}
			
		}
	}
}

