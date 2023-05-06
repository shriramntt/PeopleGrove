package com.resources;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Resuable_Methods {

	public static WebDriver driver;   // class level variable
	public static Actions act;
	public static Robot r;

	public static WebDriver chromeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		return driver = new ChromeDriver(options);
	}

	
	// fireFox
	
	
	// edge
	public static WebDriver edgeBrowser() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");

		System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		return driver = new EdgeDriver(options);
	}
	
	
	// oneSingle Method

	public static WebDriver browser(String browserName) {
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");

			 driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");

			 driver = new EdgeDriver(options);
		}
		else {
			System.out.println("Invalid BrowserName");
		}
		return driver;
	}


		// get(String url)
	public static void loadUrl(String url) {      
		driver.get(url);
	}
	
	public static void loadUrl(String option,String url) {
		if(option.equalsIgnoreCase("get")) {
			driver.get(url);
		}
		else if(option.equalsIgnoreCase("to")) {
			driver.navigate().to(url);
		}
	}
	
	public static String  getUrl() {
		return driver.getCurrentUrl();
	}
	
	// similar Method ==> getTitle , getWindowHandle , getWindowHandles 
	
	public void reload() {
		driver.navigate().refresh();
	}
	
	public static void navigation(String option) {
		if(option.equalsIgnoreCase("f")) {
			driver.navigate().forward();
		}
		else if(option.equalsIgnoreCase("b")) {
			driver.navigate().back();
		}
		else if(option.equalsIgnoreCase("r")) {
			driver.navigate().refresh();
		}
	}
	
	
	// close & quit
	public static void tearDown(String option) {
		if(option.equalsIgnoreCase("q")) {
			driver.quit();
		}
		else if(option.equalsIgnoreCase("c")) {
			driver.close();
		}
	}
	
	
	// webelements methods [sendKeys , click , getText , getAttribute , isEnabled....getCssValue , submit,getTagName] 
	
	public static void enterText(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	public static void click(WebElement ele) {
		ele.click();
	}
	
	public static String retrieveText(WebElement element) {
		return element.getText();
	}
	
	
	// webPage
	public static void webPageScreenshot(String pathName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		try {
			FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),  new File(pathName));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	//webElement
	public static void webElementScreenshot(WebElement ele,String pathName) {
		try {
			FileHandler.copy(ele.getScreenshotAs(OutputType.FILE),  new File(pathName));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	// waits
	public static void fixedWait(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void elementWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	
	// alert
	public static void  simpleAlert() {
		driver.switchTo().alert().accept();
	}

	public static String retrieveAlertText() {
		return driver.switchTo().alert().getText();
	}
	
	
	public void confirmAlert(String option) {
		if(option.equalsIgnoreCase("a")) {		
			driver.switchTo().alert().accept();
		}
		else if(option.equalsIgnoreCase("d")){
			driver.switchTo().alert().dismiss();
		}
	}
	
	// mouseActions
	public static void mouseActions(String option,WebElement ele) {
		 act = new Actions(driver);
		
		if(option.equalsIgnoreCase("mouseHover")) {
			act.moveToElement(ele).perform();
		}
		else if(option.equalsIgnoreCase("rightClick")) {
			act.contextClick(ele).perform();
		}
	}
	
	// dragAndDrop
	public static void dragAndDrop(WebElement ele1,WebElement ele2) {
		 act = new Actions(driver);
		 act.dragAndDrop(ele1, ele2);
	}
	
	
	// robotKeys
	public static void downArrowKey(int size) {

		try {
			r = new Robot();
		} catch (AWTException e) {

			e.printStackTrace();
		}
		for(int i =1;i<=size;i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
	}
	
	public static void enterKey() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	// dropDown
	
	// Frames
	
	public static void javScriptCommands(String option,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		if(option.equalsIgnoreCase("scroll")) {
			js.executeScript("arguments[0].scrollIntoView()", ele);
		}
		else if(option.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click()", ele);
		}
		//sendKeys		
	}
	
}
