package com.bit.test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bit.support.Shared;
import com.bit.support.SharedData;

public class Scenario {

	ChromeDriver driver;
	
	Shared s;
	
	SharedData sd = new SharedData();
	
	
	public Scenario(ChromeDriver driver) {
		
		this.driver = driver;
	}
	
	/*targetEndToEndScenario
	 * Open Chrome browser
	 * navigate to Target.com 
	 * verify title 
	 * verify url 
	 * verify target logo is displayed 
	 * search for "Kids shoes"
	 * verify title 
	 * verify url 
	 * print how many product has been displayed based on the search 
	 * ex: 753 results for “kids shoes”
	 * store the title of the 1st product in a variable 
	 * Select the first product 
	 * verify title 
	 * verify url 
	 * store the title of the product in a variable
	 * verify title from search page match title in product detail page 
	 * select any size 
	 * select any quantity 
	 * click on add to cart 
	 * click on X icon and close the cart modal 
	 * click on cart icon and navigate to cart page 
	 * verify title 
	 * verify url 
	 * click on Sign In to check out button 
	 * enter any email 
	 * enter any password 
	 * click on Sign in button 
	 * verify that error displayed as "We can't find your account." 
	 * print the error 
	 */
	
	public void targetEndToEndScenario() throws InterruptedException {
		
		s = new Shared(driver);
		// open the target web site
		s.openWebSite(sd.targetUrl);
		
		//target home page title and url verify
		s.verifyTitle(sd.expectedTitle);
		s.verifyUrl(sd.targetUrl);
		
		// target logo verify
		s.targetLogoVerify();
		
		// search the kids shoes on the search bar in the taget web site
		s.searchElement();
		Thread.sleep(5000);
		
		//   verify kids shoes page title and url
		s.verifyKidsShoesTitle();
		s.verifyKidShoesUrl();
		s.printProductListOfKidsShoesPage();
		Thread.sleep(5000);
		
		// click the 1st product in the kidsShoes page
		s.clickAnyElement(By.xpath("//section/div/div[1]//div[@class='ProductCardImage__ContentWrap-sc-rhvnbj-3 hywtBg']/a/div[1]/picture/img"));
		
		Thread.sleep(5000);
		s.kidsShoes1stProductTitleVerify();
		
		Thread.sleep(2000);
		s.kidsShoes1stProductUrlVerify();
		
		//select the size of first product of kids shoes page
		
		s.clickAnyElement(By.xpath("(//div[@class='children'])[2]/div[2]/a"));
		Thread.sleep(5000);
		
		// select the quantity of 1st product of kids shoes page
		s.clickAnyElement(By.xpath("//button[starts-with(@id,'select-')]")); // click the quantity drop down
		Thread.sleep(5000);
		
		s.clickAnyElement(By.cssSelector(".OptionsList-sc-vjpj0n-0.kkpuJb>li:nth-of-type(3)>a")); // click the actual quantity
		
		Thread.sleep(3000);
		
		// Add to Cart 
		s.clickAnyElement(By.xpath("//button[contains(text(),'Add to cart')]")); // click add to cart
		
		Thread.sleep(3000);
		
		// click to X icon on add to cart page
		s.clickAnyElement(By.xpath("//button[@class='styles__IconButtonStyles-sc-18jd2v4-0 idmogC styles__StyledBaseIconButton-sc-136p0tp-0 jUTaOX']/span"));
		Thread.sleep(3000);
		
		// click on card icon and navigate
		s.clickAnyElement(By.xpath("//a[@class='styles__PrimaryHeaderLink-sc-srf2ow-1 styles__CartLink-sc-vxcbjb-0 elbitu kRQaKP']/div"));
		Thread.sleep(3000);
		
		//Verify card page title and url
		s.cardPageTitleVerify(); // title verify
		Thread.sleep(2000);
		
		s.cardPageUrlVerify(); // url verify
		Thread.sleep(2000);
		
		// click on sign to check out button
		s.clickAnyElement(By.xpath("//nav[@id='headerPrimary']/a[4]"));
		Thread.sleep(2000);
		s.clickAnyElement(By.xpath("(//ul[@class='styles__ListUl-sc-diphzn-4 fWZJzZ']/li)[1]/a"));
		Thread.sleep(2000);
		
		// enter any email and password
		s.writeInWebPage(By.id("username"), "hsjdu@gmail.com");
		s.writeInWebPage(By.name("password"), "Dsrt#@$12343");
		
		Thread.sleep(2000);
		
		s.clickAnyElement(By.id("login")); // click on login button
		
		s.printTheErrorOfSignInPage(); // print the error of sign in page
}

}
