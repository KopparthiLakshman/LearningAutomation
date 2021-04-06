
package selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Selenium4Demo extends Assert{

	public WebDriver driver;
	
	/**
	 * 	public Selenium4Demo(WebDriver driver) {
			WebDriverManager.chromedriver().setup();
			this.driver = driver;
		}
	*/
	@Test
	public void name() throws IOException {



		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.findElement(By.id("")).isSelected();
		
		driver.findElement(By.id("")).getAttribute("bgcolor");
		
		driver.get("http://www.google.com");

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.DAYS);
		
		String windowHandle = driver.getWindowHandle();
		
		HashSet<String> hset = new HashSet<String>();
		
		for (String string : hset) {
			
		}
		Iterator<String> iterator2 = hset.iterator();
		
		
		//3.0
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.xpath("//img[contains(@id, 'hplogo')]")); 

		ele.sendKeys(Keys.SHIFT);

		Select sel = new Select(ele);
		driver.navigate();
		
		
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.SHIFT);
		act.contextClick();
		act.doubleClick();

		act.keyDown(Keys.CONTROL).sendKeys(Keys.NUMPAD0, Keys.CLEAR).build().perform();
		
		ele.isDisplayed();
		
		sel.deselectByIndex(1);
		
		
		List<WebElement> options = sel.getOptions();
		
		
		WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitt.until(ExpectedConditions.alertIsPresent());



				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class)
				.ignoring(NoAlertPresentException.class)
				;

		ele = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(""));
			};
		});

		
		// Selenium 4
		File screenshotAs = ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,new File("Google.png"));
		System.out.println("Title of the web page that is opoened :: " +driver.getTitle());

		WebDriver frame = driver.switchTo().frame(0).switchTo().frame(1).switchTo().frame(2);
		frame.switchTo().defaultContent();
		frame.switchTo().parentFrame();

		String parrWind = driver.getWindowHandle();

		Set<String> allWinds = driver.getWindowHandles();
		allWinds.size();

		Iterator<String> iterator = allWinds.iterator();


		for (String string2 : allWinds) {
			if(string2.equals("NewWindow"))
				driver.switchTo().window(string2);
		}


	}


	/*
	 * 
	 public Actions release(WebElement target) {
    if (isBuildingActions()) {
      action.addAction(new ButtonReleaseAction(jsonMouse, (Locatable) target));
    }

    return moveInTicks(target, 0, 0).tick(defaultMouse.createPointerUp(LEFT.asArg()));
  }

  public Actions release() {
    if (isBuildingActions()) {
      action.addAction(new ButtonReleaseAction(jsonMouse, null));
    }

    return tick(defaultMouse.createPointerUp(Button.LEFT.asArg()));
  }

  public Actions click(WebElement target) {
    if (isBuildingActions()) {
      action.addAction(new ClickAction(jsonMouse, (Locatable) target));
    }

    return moveInTicks(target, 0, 0).clickInTicks(LEFT);
  }

  public Actions click() {
    if (isBuildingActions()) {
      action.addAction(new ClickAction(jsonMouse, null));
    }

    return clickInTicks(LEFT);
  }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public class RemoteWebDriver implements WebDriver,
	 */



	@AfterSuite
	private void endOfTheTest() {
		driver.quit();
	}
}
