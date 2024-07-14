package com.rsa.quiz;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class checkboxQuiz {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement checkbox =  driver.findElement(By.id("checkBoxOption1"));
		checkbox.click();
		if(checkbox.isSelected()) {
			checkbox.click();
			System.out.println("chcekbox is unselected");
		}
		
		
		
		List<WebElement> numberOfCheckboxs = driver.findElements(By.xpath("//input[contains(@type, 'checkbox')]"));
		System.out.println(numberOfCheckboxs.size()+" checkboxes");
		
		
		
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Arjun");
		driver.findElement(By.name("email")).sendKeys("Arjun@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Arjun123");
		driver.findElement(By.id("exampleCheck1")).click();
		
		//dropdowns for gender
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderDropdown =new Select(dropdown);
		genderDropdown.selectByIndex(0);
		
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.id("inlineRadio2")).click();
		
		driver.findElement(By.name("bday")).sendKeys("12/15/2000");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText());
//		driver.close();
	}
	


}
