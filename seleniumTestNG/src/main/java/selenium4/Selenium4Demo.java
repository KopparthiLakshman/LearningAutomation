package selenium4;

import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ButtonReleaseAction;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Selenium4Demo {

	public WebDriver driver;

	//	public Selenium4Demo(WebDriver driver) {
	//		WebDriverManager.chromedriver().setup();
	//		this.driver = driver;
	//	}

	@Test
	public void name() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://www.google.com");

		//3.0
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ele = driver.findElement(By.xpath("//img[contains(@id, 'hplogo')]")); 

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(ElementNotVisibleException.class);

		ele = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id(""));
			};
		});

		File screenshotAs = ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,new File("Google.png"));
		System.out.println("Title of the web page that is opoened :: " +driver.getTitle());
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
