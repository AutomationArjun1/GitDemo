package com.rsa.quiz;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollBy {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
//		int numberOfColumns = driver.findElements(By.cssSelector(".table-display th")).size();
//		System.out.println("number Of Columns : "+numberOfColumns);
//		int numberOfRows = driver.findElements(By.cssSelector(".table-display tr")).size()-1;
//		System.out.println("number Of Rows : "+numberOfRows);
//		
//		List<WebElement> values = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
//		//String
//		for (int i = 0; i < values.size(); i++) {
//			System.out.println(values.get(i).getText());
		
		WebElement table=driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
		
		
	}

}
