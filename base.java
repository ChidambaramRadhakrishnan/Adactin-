package BaseClass;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class base {

	public static WebDriver driver;

	static WebElement element;

	/*
	 * Description Browser Initialization
	 */
	public static WebDriver driver(String drivername) {

		///
		String edgepath = "\\src\\msedgedriver.exe";
		String chromepath = "\\src\\chromedriver.exe";
		String foxpath = "";

		///
		String epath = "webdriver.edge.driver";
		String cpath = "webdriver.chrome.driver";
		String fpath = "";

		switch (drivername) {
		case "chrome":
			System.setProperty(cpath, System.getProperty("user.dir") + chromepath);
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty(epath, System.getProperty("user.dir") + edgepath);
			driver = new EdgeDriver();
			break;

		case "firefox":
			System.setProperty(fpath, System.getProperty("user.dir") + foxpath);
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		System.out.println("Successfully " + drivername.toLowerCase() + " driver is Launched.");
		return driver;
	}

	/*
	 * Description Navigate to URL
	 */
	public static void URL(String url) {
		driver.get(url);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Successfully " + url + " is Launched.");
	}

	/*
	 * Description select Random dropdown without contain any select/option Tags
	 * select followed by list and div tags and buying foreach
	 */
	public static void selectoptionList(List<WebElement> element, String value) {
		for (WebElement options : element) {
			String txt = options.getText();
			if (txt.equalsIgnoreCase(value)) {
				options.click();
				break;
			}
		}
	}

	/*
	 * Description SwitchTo tabs
	 */
	public static void tabs() {
		String parenttab = driver.getWindowHandle();

		Set<String> alltabs = driver.getWindowHandles();

		for (String tab : alltabs) {
			if (!tab.equals(parenttab)) {
				driver.switchTo().window(tab);
			}
		}
	}

	/*
	 * Description SendKeys
	 * 
	 */
	public static void sendKeys(WebElement element, String Value) {
		if (element.isEnabled()) {
			element.sendKeys(Value);
			String keyvalue = element.getAttribute("value");
			System.out.println("Your Entered Value is - " + keyvalue);
		} else {
			String txt = "Not accessible";
			System.out.println(txt);
		}

	}

	public static void thread() throws InterruptedException {
		Thread.sleep(1000);
	}

	/*
	 * Description Get Title
	 */
	public static String title() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	/*
	 * Description DropDown
	 */
	public static String singledropdown(WebElement element, String Value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(Value.trim());
		String seltext = sel.getFirstSelectedOption().getText();
		System.out.println(seltext + " - " + "is Selected.");
		return seltext;
	}

	/*
	 * Description Select Multiple Options and Print in Console log
	 */
	public static void multipledropdown(WebElement element, String Value, int index, String Value2) {
		Select multipleselect = new Select(element);
		multipleselect.deselectAll();
		multipleselect.selectByIndex(index);
		multipleselect.selectByVisibleText(Value);
		multipleselect.selectByVisibleText(Value2);
		List<WebElement> allSelectedOptions = multipleselect.getAllSelectedOptions();
		String value = "";
		for (WebElement list : allSelectedOptions) {
			String txt = list.getText();
			System.out.println(txt);
		}
	}

	/*
	 * Description Terminate the Process of Webpage
	 * 
	 */
	public static void close() {
		System.out.println("Webpage Terminate/Kill Force");
		driver.close();
	}

	/*
	 * Description is Selected
	 */
	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

	/*
	 * Description Check is it Visible
	 */
	public static boolean isvisible(WebElement element) {
		return element.isDisplayed();
	}

	/*
	 * Description ScreenShot
	 */
	public static String shot(String Filename) throws IOException {
		String fpath = "C:\\Users\\Chidambaram\\OneDrive\\Pictures\\Screenshots";

		File ts = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(ts, new File(fpath + Filename + ".jpg"));

		System.out.println("Successfully captured a screenshot" + " - filename is " + Filename);

		return Filename;

	}

	/*
	 * Description Check Button Visible / Not and Then Click
	 */
	public static void clickElement(WebElement element) {
		if (element.isDisplayed()) {
			if (element.getText().isEmpty()) {
				element.click();
			} else {
				System.out.println(element.getText() + "- is clicked");
				element.click();
			}

		} else {
			System.out.println("element is not visible");
		}
	}

	/*
	 * Description get the text from on the element
	 */
	public static void gettext(WebElement element) {
		String txt = element.getText();
		System.out.println(txt);
	}

	/*
	 * Description MoveElement to the Element for Hover and Get Visibility of
	 * Element
	 */
	public static void movetoElement(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	/*
	 * Description Scroll Until Visible the Element
	 */
	public static void scrollTo(WebElement element) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	////
	public static void scrollBy(String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(value);
	}

	/*
	 * Description By using Action class to movetoelement and click at the same time
	 */
	public static void movetoClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	/*
	 * 
	 */

	/*
	 * Description Explicit wait(Until visible element) for particular mentioned
	 * time
	 */
	public static void explicitWait(WebElement element, String methods) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		switch (methods) {
		case "elementclickable":
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;

		case "titlecontains":
			wait.until(ExpectedConditions.titleContains("titlecontains"));
			break;
		case "elementvisibility":
			wait.until(ExpectedConditions.visibilityOf(element));
			break;
		case "alert":
			wait.until(ExpectedConditions.alertIsPresent());
		default:
			System.out.println("enter valid condition");
			break;
		}

	}

	/*
	 * Description quit()
	 */
	@AfterTest
	public static void quit() {
		System.out.println("Successfully Tested and Closed");
		driver.quit();
	}

	/*
	 * Description CheckBox check
	 */
	public static boolean checkBox(WebElement element) {
		if (!element.isSelected()) {
			System.out.println("CheckBox is Checked.");
			element.click();
		} else {
			System.out.println(element + "- Checked ByDefault.");
			return false;
		}
		return true;
	}

	/*
	 * Description WebTable to find element and click it
	 * 
	 */
	public static void tablegetRowandCheckBox(List<WebElement> tabledata, List<WebElement> tableinput, String value) {
		for (int i = 0; i < tabledata.size();) {
			String text = tabledata.get(i).getText();
			if (text.equalsIgnoreCase(value)) {
				for (int j = 0; j < tableinput.size(); j++) {
					tableinput.get(i).click();
				}
			}
			break;
		}
	}
	
	/*
	 * Description WebTable to find element and click it
	 * 
	 */
	public static void tablegetRowandCheckBox2(List<WebElement> tabledata, List<WebElement> tableinput, String value) {
		for (int i = 0; i < tabledata.size();) {
			String s = driver.findElement(By.id("hotel_name_0")).getAttribute("value");
			if (s.equalsIgnoreCase(value)) {
				for (int j = 0; j < tableinput.size(); j++) {
					tableinput.get(i).click();
				}
			}
			break;
		}
	}

	/*
	 * Description frames methods
	 */
	public static WebDriver framebyElement(WebElement element) {
		return driver.switchTo().frame(element);
	}

	/*
	 * Description switch to index
	 */
	public static WebDriver framebyIndex(int indx) {
		return driver.switchTo().frame(indx);

	}

	/*
	 * Description Navigate to back
	 */
	public static void back() {
		driver.navigate().back();
	}

	/*
	 * Description Navigate to refresh
	 */
	public static void refresh() {
		driver.navigate().refresh();
	}

	/*
	 * Description switchTo name
	 */
	public WebDriver framebyName(String name) {

		return driver.switchTo().frame(name);

	}

	/*
	 * Description SwitchTo Parentframe
	 */
	public static WebDriver framebyParent() {

		return driver.switchTo().parentFrame();

	}

	/*
	 * Description Switchto - Defaultcontent
	 */
	public static void frameExit() {

		driver.switchTo().defaultContent();

	}

	// unchecked
	/*
	 * Description Using Alert
	 */
	public static void Alert(String alert) {
		org.openqa.selenium.Alert alrt = driver.switchTo().alert();
		switch (alert) {
		case "accept":
			alrt.accept();
			break;
		case "dismiss":
			alrt.dismiss();
			break;
		case "prompt":
			alrt.sendKeys("No Alert - More Peace");
			alrt.accept();
			break;
		default:
			alrt.dismiss();
			break;
		}
	}

}
