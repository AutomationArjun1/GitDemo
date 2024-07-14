package com.rsa.Streams;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sorting_Table_Elements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// webElementList
		List<WebElement> webElementList = driver.findElements(By.xpath("//table[@id='product' and @name='courses']//td[2]"));
		
		List<String> originalList = webElementList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		
		//sorted
		List<Object> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		Assert.assertFalse(originalList.equals(sortedList));
		
		
		List<WebElement> webElementList1 = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[1]"));
		
		List<String> originalList1 = webElementList1.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(originalList1);
		
		//sorted
		List<String> sortedList1 = originalList1.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList1);
		Assert.assertTrue(originalList1.equals(sortedList1));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//thead//span[contains(text(),'Veg/fruit')]")).click();
		
		List<WebElement> tableList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		List<String> original = tableList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sorted = original.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(original.equals(sorted));
		List<String> price;
		//price list of selected item
		do {
			List<WebElement> row = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			price = row.stream()
					.filter(s->s.getText().contains("Rice"))
					.map(s->getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			
			if(price.size()<1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
	}

	private static String getPriceVeggie(WebElement s) {
		String priceList =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceList;
	}

}
