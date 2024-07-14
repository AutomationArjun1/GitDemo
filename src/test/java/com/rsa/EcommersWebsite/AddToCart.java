package com.rsa.EcommersWebsite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart {

	@Test
	public void product() throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("malli151828@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Malli@828");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product-> product
				.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartSection = driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match = cartSection.stream().anyMatch(cart-> cart.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		
		Actions a = new Actions(driver);
		WebElement moving = driver.findElement(By.cssSelector(".totalRow button"));
		a.moveToElement(moving).click().perform();
		
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		WebElement placeOrder = driver.findElement(By.cssSelector("div .btnn"));
		a.moveToElement(placeOrder).click().perform();
		
		String orderConfirmation = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(orderConfirmation, "THANKYOU FOR THE ORDER.");
	}

}
