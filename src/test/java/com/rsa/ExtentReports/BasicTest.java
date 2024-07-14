package com.rsa.ExtentReports;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BasicTest {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		// extentReport extent  System.getProperty("user.dir")+"/reports/
		String path = System.getProperty("user.dir")+"/reports/index.html";
		//File file = new File("report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setReportName("Web Automation Results");
		spark.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Arjun");
	}

	@Test
	public void base() {
		ExtentTest test = extent.createTest("Intitial Demo");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.fail("Thow the exception");
		//driver.close();
		extent.flush();
		
	}
}
