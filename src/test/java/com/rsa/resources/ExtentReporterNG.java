package com.rsa.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReporter() {
		String file = System.getProperty("user.dir")+"/reports/index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.config().setReportName("Web Automation Results");
		spark.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Arjun");
		return extent;
	}
}
