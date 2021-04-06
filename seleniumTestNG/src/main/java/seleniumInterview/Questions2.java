	package seleniumInterview;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchContextException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Verify;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Questions2 {
	public static void main(String[] args) throws InterruptedException {

		/**
		 * Different Types of Xpath and their Axes methods
		 * 
		 * contains(), text(), starts-with(), ends-with(), 
		 * following
		 * following-sibling
		 * preceding
		 * preceding-sibling
		 * descendants
		 * parent
		 * child
		 * ancestor
		 *  
		 * 
		 * `
		 *
		 * Absolute XPath -
		 * /html/body/div[2]/div[1]/div/h4[1]/b/html[1]/body[1]/div[2]/div[1]/div[1]/h4[
		 * 1]/b[1] Relative Xpath - //div[2]/div[1]/div[1]/h4[1]/b[1]
		 * Xpath=//input[@name='uid'] Xpath=//input[@type='text'] Xpath=
		 * //label[@id='message23'] Xpath= //input[@value='RESET']
		 * Xpath=//*[@class='barone'] Xpath=//a[@href='http://demo.guru99.com/'] Xpath=
		 * //img[@src='//cdn.guru99.com/images/home/java.png']
		 * 
		 * Xpath=//*[contains(@name,'btn')]
		 * 
		 * Xpath=//*[contains(text(),'here')]
		 * 
		 * Xpath=//*[@type='submit' or @name='btnReset'] Xpath=//*[@type='submit'
		 * and @name='btnReset']
		 * 
		 * Xpath=//label[starts-with(@id,'message')]
		 * 
		 * Xpath=//td[text()='UserID']
		 * 
		 * driver.findElement(By.xpath("@id[name='Submit']//following-sibling::td[2]]"))
		 * ;
		 * 
		 * Xpath=//*[text()='Enterprise Testing']//ancestor::div
		 * 
		 * driver.findElement(By.xpath("@id[name='Submit']//child::td[2]]"));
		 * driver.findElement(By.xpath("Xpath=//*[@id='rt-feature']//parent::div"));
		 * 
		 * Xpath=//*[@type='submit']//preceding::input
		 * 
		 * driver.findElement(By.xpath("@id[name='Submit']//preceeding-sibling::td[2]]")
		 * );
		 * 
		 * Xpath=//*[@id='rt-feature']//descendant::a[1]
		 */
		/**===================================================================================================================================
		 **/
		/**Locators in selenium : 
		 * id
		 * Name
		 * ClassName
		 * ss
		 * Xpath - Absolute xpath
		 * 		 - Relative xpath/ Dymanic xpath
		 * 				-	input[starts-with(@id,'ctrl')]	
		 * 				-	input[ends-with(@id,'_userName')]
		 * 				-	input[contains(@id,'userName')] , input[contains(text(),'userName')]
		 * CSS Selector
		 * 	-	input[id^='ctrl']
		 * 	-	input[id$='_userName']
		 * 	-	input[id*='userName']
		 * Linkedtext
		 * PartialLinkedtext
		 * */

		/**===================================================================================================================================
		 **/

		WebDriver driver ;
		System.setProperty("webdriver.chrome.driver", "D:\\EclipseWorkSpace_01_03_2015\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

//		chrominum driver 
//		remote webdriver
//		search context
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(""))));


		Wait<WebDriver> waitF = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(NoSuchContextException.class)
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class)
				.ignoring(ElementNotSelectableException.class)
				.ignoring(ElementNotVisibleException.class);


		WebElement eleF = waitF.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("@id selector"));
			}
		});

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");

		//3.0
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.xpath("//img[contains(@id, 'hplogo')]")); 

		String windowHandle = driver.getWindowHandle();

		Set<String> wHandles = driver.getWindowHandles();

		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();

		WebElement selElement = null;
		Select sel = new Select(selElement);
		
		sel.isMultiple();
		sel.getAllSelectedOptions();
		
		sel.selectByIndex(0);
		sel.selectByValue("Vlaue");
		sel.selectByVisibleText("Visible Text");
		
		selElement.isSelected();
		
		sel.deselectAll();
		sel.selectByIndex(0);
		List<WebElement> options = sel.getOptions();
		WebElement webElement = options.get(2);
		ListIterator<WebElement> listIterator = options.listIterator();
		selElement.isSelected();
		
		WebElement sourceElement = null;
		WebElement targetElement = null;

		Actions act = new Actions(driver);

		act.contextClick(ele); // To right click on the element
		act.doubleClick(ele);
		
		act.contextClick(); // To right click on the element
		act.doubleClick();

		// Example for method overloading
		act.moveToElement(ele);
		act.moveToElement(ele, 10, 10);
		
		driver.switchTo().window("");
		
		act.clickAndHold(sourceElement).
		pause(Duration.ofSeconds(10)).
		moveToElement(targetElement).
		release().build().perform();

		act.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id("")));

		act.dragAndDropBy(sourceElement, 100, 150);


/**		
 * Examples for method overloading in selenium
 * 
//		public Actions clickAndHold(WebElement target) {
//		public Actions clickAndHold() {
//		public Actions release(WebElement target) {
//		public Actions release() {
//		public Actions click(WebElement target) {
//		public Actions click() {
		
	*/	
		
		StringTokenizer str = new StringTokenizer("Sun rises in the EAST", " ");
		
		driver.navigate().forward();
		driver.navigate().back();
//		driver.navigate().to("URL");  Overloaded method
		driver.navigate().refresh();
		driver.manage().deleteAllCookies();
		driver.getTitle();
		

		driver.manage().window().getPosition().getX();
		driver.manage().window().getPosition().getY();

		Point position = driver.manage().window().getPosition();
		position.getX();
		position.getY();
		
//		DesiredCapabilities capabilities = DesiredCapabilities.
				
				
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("C:\\Lakshman\\Desktop\\screen.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.get("");
		driver.getCurrentUrl();
		driver.getTitle();

		WebElement element = driver.findElement(By.className("_2AkmmA _29YdH8"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		// This  will scroll down the page by  1000 pixel vertical		
		jse.executeScript("window.scrollBy(0,1000)");

		// This  will scroll down the page by  1000 pixel horizontally		
		jse.executeScript("window.scrollBy(1000, 0)");

		// To scroll the page till the web element 
		jse.executeScript("arguments[0].scrollIntoView();", element);

		// How to scroll the page till the bottom
		jse.executeScript("windows.scrollTo(0,document.body.scrollHeight)");

		// Horizontal scrolling
		jse.executeScript("window.scrollBy(14350, 0)");

		//Scroll the weblement
		element = driver.findElement(By.className("_2AkmmA _29YdH8"));
		element.sendKeys(Keys.END);


		//how to scroll the page dynamically
		long initialheight = (Long) (jse.executeScript("return document.body.scrollHeight"));

		while(true){

			long finalheight = (Long) jse.executeScript("windows.scrollTo(0,document.body.scrollHeight)");
			Thread.sleep(1000);
			initialheight = (Long) (jse.executeScript("return document.body.scrollHeight"));
			if(finalheight == initialheight)
				break;
			initialheight = finalheight;
		}

			// override  - Assert methods
			Assert.assertTrue(true);
			Assert.assertEquals(1, 1);
			Assert.assertEquals(true, 1==1, "String Mesage");
			
			Verify.verify(false, null, 0);
	}
}