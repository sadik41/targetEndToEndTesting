package com.bit.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	
	ChromeDriver driver;
	
	@Before
	public void openBrowser() {
		
		System.setProperty("webdriver.driver.chrome", "D:\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}
	
	@After
	public void closeBrowser() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
	}
}
