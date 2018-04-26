package mavenTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements WdMethods{

	RemoteWebDriver driver = null;
	public void startApp(String browser, String url) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.IEDriverServer.driver", "./drivers/ie.exe");
				//	driver = new IEDriverServer();
			}

			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			System.out.println("The "+browser+" browser launched successfully");
		}catch(NullPointerException e) {
			System.err.println("Browsers not found exception");
			e.printStackTrace();
		}catch(WebDriverException e) {
			System.err.println("Drivers related exception");
			e.printStackTrace();
		}catch(Exception e) {
			System.err.println("Other than drivers exception");
			e.printStackTrace();
		}
	/*	finally {
			takeSnap();
		}*/
	}

	public WebElement locateElement(String locator, String locValue) {
		WebElement ele = null;
		try {
			switch (locator) {
			case "id":
				ele = driver.findElementById(locValue);
				break;
			case "class":
				ele = driver.findElementByClassName(locValue);
				break;
			case "linkText":
				ele=driver.findElementByLinkText(locValue);
				break;
			case "name":
				ele=driver.findElementByName(locValue);
				break;
			case "partialLinkText":
				ele=driver.findElementByPartialLinkText(locValue);
				break;
			case "xpath":
				ele= driver.findElementByXPath(locValue);
				break;
			default:
				break;

			}

		}catch(NoSuchElementException e) {
			System.err.println("Element not found exception");
			e.printStackTrace();
		}finally {
			takeSnap();
		}
		return ele;

	}

	public WebElement locateElement(String locValue) {
		try {
			driver.findElementById(locValue);
		}
		catch(NoSuchElementException e) {
			System.err.println("Element not found exception");
			e.printStackTrace();
		}
		return driver.findElementById(locValue);
		/*finally {
		takeSnap();
	}*/
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			System.out.println("The given value is entered "+data);
		}catch(WebDriverException e) {
			System.err.println("WebDriver exception occurred");
			e.printStackTrace();
		}finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) {
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		try {
			ele.click();
			System.out.println("The element is clicked successfully");
		}catch(NoSuchElementException e) {
			System.err.println("Element not found exception");
			e.printStackTrace();
		}finally {
			takeSnap();
		}

	}

	public void clickWithoutSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println("The element is clicked successfully without snap");
		}finally {
			//takeSnap();
		}
		//return ele;
	}

	public String getText(WebElement ele) {
		String txt=ele.getText();
		System.out.println("Given element is printed in console window: "+txt);
		takeSnap();
		return txt;
	}

	public void clear(WebElement ele) {
		ele.clear();
		System.out.println("Element is cleared ");
		//takeSnap();
		//return txt;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByVisibleText(value);
		System.out.println("The given text is "+value);
		takeSnap();

	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		Select select=new Select(ele);
		select.selectByIndex(index);
		System.out.println("The given index value is "+index);
		takeSnap();

	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByValue(value);
		System.out.println("The given value is "+value);
		takeSnap();

	}

	public boolean verifyTitle(String expectedTitle) {
		String title=driver.getTitle();
		if(title.equals(expectedTitle)) {
			System.out.println("The given title is "+title);
			takeSnap();
		}else {
			System.out.println(" The given title is not matched");
			takeSnap();
		}

		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		if(ele.getText().equals(expectedText)) {
			System.out.println("The given text is "+ele+" is matched successfully");
			takeSnap();
		}else {
			System.out.println(" The given text is not matched");
			takeSnap();
		}
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		if(ele.getText().contains(expectedText)) {
			//System.out.println("The given text is "+ ele +" is matched successfully");
			System.out.println(ele);
			takeSnap();
		}else {
			System.out.println(" The given text is not matched");
			takeSnap();
		}


	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).equals(value)) {
			System.out.println("The given text is "+ele+" is matched successfully");
			takeSnap();
		}else {
			System.out.println(" The given text is not matched");
			takeSnap();
		}

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		if(ele.getAttribute(attribute).contains(value)) {
			System.out.println("The given text is "+ele+" is matched successfully");
			takeSnap();
		}else {
			System.out.println(" The given text is not matched");
			takeSnap();
		}

	}

	public void verifySelected(WebElement ele) {
		if(ele.isSelected()) {
			System.out.println("The given element is "+ele+" is selected");
			takeSnap();
		}else {
			System.out.println("TChe given element is not selected");
			takeSnap();
		}

	}

	public void verifyDisplayed(WebElement ele) {
		if(ele.isDisplayed()) {
			System.out.println("The given element is "+ele+" is displaying successfully");
			takeSnap();
		}else {
			System.out.println("The given element is not displayed correctly");
			takeSnap();
		}

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			List<String> winList=new ArrayList<String>();
			winList.addAll(allWindows);
			driver.switchTo().window(winList.get(index));
			System.out.println("currently element is present in "+index);
		}catch(NoSuchWindowException e) {
			System.err.println("Window not found exception");
			e.printStackTrace();
		}
		finally {
			takeSnap();
		}
	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
			System.out.println("currently element is present in "+ele);
		}catch(NoSuchFrameException e) {
			System.err.println("Frame not found exception");
			e.printStackTrace();
		}finally {
			takeSnap();	
		}


	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("The given alert is accepted");
		}
		catch(NoAlertPresentException e) {
			System.err.println("Alert not present");
			e.printStackTrace();
		}/*finally {
			//takeSnap();
		}*/
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("The given alert is not accepted");
		}
		catch(NoAlertPresentException e) {
			System.err.println("Alert not present");
			e.printStackTrace();
		}finally {
			//takeSnap();
		}

	}

	public String getAlertText() {
		String txt=null;
		try {

			txt= driver.switchTo().alert().getText();
			System.out.println("The given alert text is "+txt+" is displayed successfully");
		}

		catch(NoAlertPresentException e) {
			System.err.println("Alert not present");
			e.printStackTrace();
		}finally {
			//takeSnap();
		}
		return txt;
	}

	public String getCurrentUrl() {
		driver.getCurrentUrl();
		System.out.println("The current url is "+driver.getCurrentUrl());
		return null;

	}

	
	int i =10000;
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("C:/Selenium_TestLeaf/RunMaven/snaps/cucumber/img"+i+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			System.err.println("IO exception");
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		driver.close();
        System.out.println("Current active browser is closed");
	}

	public void closeAllBrowsers() {
		driver.quit();
		System.out.println("All active browsers are closed");

	}

}
