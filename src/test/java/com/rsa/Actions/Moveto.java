package com.rsa.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v123.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;

public class Moveto {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		
		//build().perform(); -> perform();
		
		//convert from small letter to caps at the time of entering.
		a.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("arjun").doubleClick().perform();
		
		//move to element and click on rightclick. 
		a.moveToElement(move).contextClick().perform();
	}

}
