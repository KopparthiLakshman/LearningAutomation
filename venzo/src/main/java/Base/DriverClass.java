package Base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DriverClass {

	WebDriver driver;
	public WebDriver launchChromeBrowser(String url){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}


	public void addItemsToCart(WebDriver driver) throws InterruptedException {
		HashMap<String, String> itemPricesInCart = null;
		HashMap<String, String> itemPricesInPage = null;
		ArrayList<String> itemName = new ArrayList<String>();
		itemName.add("Sauce Labs Fleece Jacket");
		itemName.add("Sauce Labs Backpack");

		itemPricesInPage = XpathFormationForCartItems(driver, itemName);
		driver.findElement(By.xpath("//div[@id='contents_wrapper']/div/div[2]/a")).click();
		itemPricesInCart = getPricesFromCart(driver, itemName);

		System.out.println(itemPricesInPage);
		System.out.println(itemPricesInCart);

		Assert.assertEquals(itemPricesInPage, itemPricesInCart, " Prices are as expected ");
	}


	private HashMap<String, String> XpathFormationForCartItems(WebDriver driver, ArrayList<String> items) throws InterruptedException {

		WebElement Item1_webelement;
		HashMap<String,String> priceValues = new HashMap<String,String>();
		Actions act = new Actions(driver);
		for (String itemName : items ) {
			String price_xpath = "//div[text()='"+itemName+"']/ancestor::div[1]/following-sibling::div/div";
			String item_xpath = "//div[text()='"+itemName+"']/ancestor::div[1]/following-sibling::div/button";
			String priceValue = driver.findElement(By.xpath(price_xpath)).getText();
			priceValues.put(itemName, priceValue.substring(1, priceValue.length()));
			Item1_webelement = driver.findElement(By.xpath(item_xpath));
			Thread.sleep(2000);
			act.moveToElement(Item1_webelement).click().perform();
		}
		return priceValues;
	}


	private HashMap<String, String> getPricesFromCart(WebDriver driver, ArrayList<String> itemName) {

		HashMap<String,String> checkoutPriceValues = new HashMap<String,String>();
		for (String item : itemName) {
			String price_checkout_page_xpath = "//div[text()='"+item+"']/ancestor::div[1]/div[2]/div";
			String priceValue = driver.findElement(By.xpath(price_checkout_page_xpath)).getText();
			checkoutPriceValues.put(item, priceValue);
		}
		return checkoutPriceValues;
	}


}
