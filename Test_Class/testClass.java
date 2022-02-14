package Test_Class;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.base;
import Data_Driven.DataProviders;
import POM_Manager.pageManager;
import Properties.propertyManager;

public class testClass extends base {
	public static WebDriver driver = driver("chrome");
	public static pageManager pm = new pageManager(driver);
	SoftAssert soft;

	@Test(dataProviderClass = DataProviders.class, dataProvider = "login")
	public void login(String url, String username, String password) {
		URL(url);

		String title = driver.getTitle();
		if (title.equals("Adactin.com - Hotel Reservation System")) {
			assertTrue(true);
		} else {
			assertFalse(false);
		}

		WebElement logo = driver.findElement(By.xpath("//img[@class='logo']"));
		if (logo.isDisplayed()) {
			assertTrue(true);
		} else {
			assertFalse(false);
		}

		sendKeys(pm.getlgPage().getUsername(), username);
		sendKeys(pm.getlgPage().getpassword(), password);
		clickElement(pm.getlgPage().getLoginBtn());

		SoftAssert soft = new SoftAssert();

	}

	@Test(dependsOnMethods = "login")
	public void searchHotel() throws Exception {
		String title = driver.getTitle();
		assertEquals(title, "Adactin.com - Search Hotel", "Wrong Title");

		clickElement(pm.getsrhPage().getsearchbtn());

		String text = driver.findElement(By.id("location_span")).getText();
		assertEquals(text, "Please Select a Location", "Error msg not visible");

		singledropdown(pm.getsrhPage().getlocation(),
				propertyManager.getPropertyManager().getPropertyClass().getlocation());

		singledropdown(pm.getsrhPage().gethotels(), propertyManager.getPropertyManager().getPropertyClass().gethotel());

		singledropdown(pm.getsrhPage().getroomtype(),
				propertyManager.getPropertyManager().getPropertyClass().getroomtype());

		singledropdown(pm.getsrhPage().getnofrooms(),
				propertyManager.getPropertyManager().getPropertyClass().getrooms());

		sendKeys(pm.getsrhPage().getdate1(), propertyManager.getPropertyManager().getPropertyClass().getindate());

		sendKeys(pm.getsrhPage().getdate2(), propertyManager.getPropertyManager().getPropertyClass().getoutdate());

		singledropdown(pm.getsrhPage().getadultroom(),
				propertyManager.getPropertyManager().getPropertyClass().getadult());

		singledropdown(pm.getsrhPage().getchidlroom(),
				propertyManager.getPropertyManager().getPropertyClass().getchild());

		clickElement(pm.getsrhPage().getsearchbtn());
	}

	@Test(dependsOnMethods = "searchHotel")
	public void selecthotel() throws Exception {
		String title = driver.getTitle();
		assertEquals(title, "Adactin.com - Select Hotel", "Wrong Title");

		clickElement(pm.getslhPage().getcontue());

		String text = driver.findElement(By.id("radiobutton_span")).getText();
		assertEquals(text, "Please Select a Hotel", "Error Not Visible");

		tablegetRowandCheckBox2(pm.getslhPage().getdata1(), pm.getslhPage().getinput(),
				propertyManager.getPropertyManager().getPropertyClass().getHotelName());

		clickElement(pm.getslhPage().getcontue());

	}

	@Test(dependsOnMethods = "selecthotel")
	public void BookHotel() throws Exception {
		String title = driver.getTitle();
		assertEquals(title, "Adactin.com - Book A Hotel", "Wrong Title");

		sendKeys(pm.getbhPage().getFirstname(), propertyManager.getPropertyManager().getPropertyClass().getfname());

		sendKeys(pm.getbhPage().getLastname(), propertyManager.getPropertyManager().getPropertyClass().getlname());

		sendKeys(pm.getbhPage().getAddress(), propertyManager.getPropertyManager().getPropertyClass().getbaddress());

		sendKeys(pm.getbhPage().getCreditcn(), propertyManager.getPropertyManager().getPropertyClass().getcreditcn());

		singledropdown(pm.getbhPage().getCreditct(),
				propertyManager.getPropertyManager().getPropertyClass().getcredittype());

		singledropdown(pm.getbhPage().getCreditcem(),
				propertyManager.getPropertyManager().getPropertyClass().getcreditexpiry());

		singledropdown(pm.getbhPage().getCreditcey(),
				propertyManager.getPropertyManager().getPropertyClass().getcreditexpiryyear());

		sendKeys(pm.getbhPage().getCcv(), propertyManager.getPropertyManager().getPropertyClass().getccv());

		clickElement(pm.getbhPage().getBooknowBtn());

	}

	@Test(dependsOnMethods ="BookHotel")
	public void confirm() {
		clickElement(pm.getbkcPage().getmyitiBtn());

		clickElement(pm.getbkcPage().getLogout());
	}

}
