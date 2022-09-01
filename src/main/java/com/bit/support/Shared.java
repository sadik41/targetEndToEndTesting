package com.bit.support;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shared {
	
	ChromeDriver driver;
	
	SharedData sd = new SharedData();

	public Shared(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void openWebSite(String url) {
		driver.get(url);
	}

	public void verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		boolean r = actualTitle.equals("Target : Expect More. Pay Less.");
		System.out.println("Target HomePage Title verify result is : " + r);
	}

	public void verifyUrl(String ExpectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		boolean r = actualUrl.contains("https://www.target.com/");
		System.out.println("Target HomePage Url verify result is : " + r);
	}

	public void targetLogoVerify() {
		boolean logo = driver.findElement(By.cssSelector("#headerPrimary>a:nth-of-type(1)")).isDisplayed();
		System.out.println("TargetLogoVerifyResult : " + logo);
	}
	
	public void searchElement() {
		driver.findElement(By.id("search")).sendKeys("kids shoes");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void verifyKidsShoesTitle() {
		String actualTitle = driver.getTitle();
		boolean r = actualTitle.equals("Kids Shoes : Target");
		System.out.println("Target Kids page Title verify result is : " + r);
	}
	
	public void verifyKidShoesUrl() {
		String actualUrl = driver.getCurrentUrl();
		boolean r = actualUrl.contains("https://www.target.com/s?searchTerm=kids+shoes");
		System.out.println("Target KidsShoes Url verify result is : " + r);
	}
	
	public void printProductListOfKidsShoesPage() {
		String text = driver.findElement(By.cssSelector(".styles__StyledCol-sc-fw90uk-0.dzjEGC>div>div:first-of-type>h2")).getText();
		System.out.println("Kids Shoes search result : "+text);
	}
	
	public void clickAnyElement(By by) {
		driver.findElement(by).click();
	}
	
	public void kidsShoes1stProductTitleVerify() {
		String actualTitle = driver.getTitle();
		boolean r = actualTitle.equals(sd.shoesPage1stProductTitle);
		System.out.println("1st product of the kids shoes page title verify result is : "+r);
	}
	
	public void kidsShoes1stProductUrlVerify() {
		String actualUrl = driver.getCurrentUrl();
		boolean r = actualUrl.contains(sd.shoesPage1stProductUrl);
		System.out.println("1st product of the kids shoes page url verify result is : "+r);
	}
	
	public void cardPageTitleVerify() {
		String actualTitleCardPage = driver.getTitle();
		boolean result = actualTitleCardPage.equals(sd.cardPageTitle);
		System.out.println("Card page title Result is : "+result);
	}
	
	public void cardPageUrlVerify() {
		String actualUrlCardPage = driver.getCurrentUrl();
		boolean result = actualUrlCardPage.contains(sd.cardPageUrl);
		System.out.println("Card page URL Result is : "+result);
	}
	
	public void writeInWebPage(By by,String sendKeys ) {
		driver.findElement(by).sendKeys(sendKeys);
	}

	public void printTheErrorOfSignInPage() {
		String text = driver.findElement(By.xpath("//div[contains(text(),'Sorry, something went wrong. Please try again.')]")).getText();
		System.out.println("Login Page error is : "+text);
		
	}

}
