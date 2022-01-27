package org.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver chromeLaunch() {
		
		WebDriverManager.chromedriver().setup();
		
		return driver=new ChromeDriver();
	}

public static void edgeLaunch() {
	
	WebDriverManager.edgedriver().setup();
	
	driver=new EdgeDriver();
}
	
	public static void firefoxLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	
	//2.url launch
	
	public static void urlLaunch(String url) {
		
		driver.get(url);
		
	}
	
	//3.send keys
	
	public static void sendkeys(WebElement e, String data) {
		e.sendKeys(data);
		
	}
	
	
		//4.click
	
	public static void click(WebElement e) {
		e.click();

	}
	
	//5.gettittle
	
	public static String getTittle() {
		String title = driver.getTitle();
		return title;
		
	}
	
	//6.current url
	
	public static String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	
	//7.quit
	
	public static void quit() {
		driver.quit();

	}
	
	//8.action Drag and Drop
	
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}
	
	//9.click actions                       
	
	public static void clickact(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.moveToElement(WebElement).perform();
	}
	
	//10.move to element (actions)
	
	public static void moveToElement(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.moveToElement(WebElement).perform();
	}
	
	//11.context click
	
	public static void contextClick(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.contextClick(WebElement).perform();
	}
	
	//12.double click
	
	public static void doubleClick(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.doubleClick(WebElement).perform();
	}
	
	//13.click and hold
	
	public static void clickAndHold(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.clickAndHold(WebElement).perform();
	}
	
	//14.release
	
	public static void release(WebElement WebElement) {
		Actions a=new Actions(driver);
		a.release(WebElement).perform();
	}
	
	//15.select by index
	
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	
	//16.select by value
	
	public static void selectByValue(WebElement e, String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	
	//17.select by visible text
	
	public static void selectByVisibleText(WebElement e, String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	
	//18.is multiple
	
	public static boolean isMultiple(WebElement e) {
		Select s=new Select(e);
		boolean mul = s.isMultiple();
		return mul;
	}
	
	//19.deselect by index
	
	public static void deselectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	
	//20.deselect by value
	
	public static void deselectByValue(WebElement e, String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	
	//21.deselect by visible text
	
	public static void deselectByVisibleText(WebElement e, String text) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
	}
	
	//22.deselect all
	
	public static void deselctAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	
	//23.get options
	
	public static void getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
	}
	
	//24.get all selected options
	
	public static String getAllSelectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> all = s.getAllSelectedOptions();
		WebElement we = all.get(0);
		return null;
	}
	
	//25.get first selected option
	
	public static void getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		WebElement gfs = s.getFirstSelectedOption();
	}
	
	//26.simple alert
	
	public static void simpleAlert(WebElement e) {
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	//27.confirm alert
	
	public static void confirmAlert(WebElement e) {
		Alert a=driver.switchTo().alert();
		a.dismiss();
	}
	
	//28.prompt alert
	
	public static void promptAlert(WebElement e,String data) {
		Alert a=driver.switchTo().alert();
		a.sendKeys(data);
		a.accept();
	}
	
	//29.frame by index
	
	public static void framesByIndex(int index) {
		driver.switchTo().frame(index);	
	}
	
	//30.frame by id or name
	
	public static void framesByIdorName(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	
	//31.frame by webelement
	
	public static void frameByWebElement(String frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	//32.frame default content
	
	public static void frameDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	//33.parent frame
	
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}
	
	//34.get screenshot
	
	public static void getScreenShot(String String) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File from=ts.getScreenshotAs(OutputType.FILE);
		File to=new File(String);
		FileUtils.copyFile(from, to);
	}
	
	//35.java script executor(execute script)
	
	public static void sendKeysJs(Object WebElement) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','dineshkumarst10@gmail.com')", WebElement);
	}
	
	//36.click java script
	
	public static void clickJs(Object WebElement) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", WebElement);
	}
	
	//37.get attribute
	
	public static void getAttributeJs(Object WebElement) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("return arguments[0].getAttribute('value')", WebElement );
	}
	
	//38.scroll down
	
	public static void scrollDown(Object WebElement) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", WebElement);
	}
	
	//39.scroll up
	
	public static void scrollUp(Object WebElement) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", WebElement);
	}
	
	//40.window handling first way
	
	public static void windowId1() {
		String id1 = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String eachid:allid) {
			if(!id1.equals(eachid)) {
				driver.switchTo().window(eachid);
			}
		}
	}
	
	//41.window handling second way
	
	public static void windowId2() {
		Set<String> allid = driver.getWindowHandles();
		int count=1;
		for(String eachid:allid) {
			if(count==2) {
				driver.switchTo().window(eachid);
			}
			count++;
		}
	}
	
	//42.window handling thirdway
	
	public static void windowId3(int arg0) {
		Set<String> allid = driver.getWindowHandles();
		List<String> li=new ArrayList<>();
		li.addAll(allid);
		driver.switchTo().window(li.get(arg0));
	}
	
	//43.dynamic wait
	
	public static void dynamicWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//44.maximize
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	
	
	
		

	
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


