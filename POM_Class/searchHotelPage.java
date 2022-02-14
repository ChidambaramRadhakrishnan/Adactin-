package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchHotelPage {
	public WebDriver driver;
	
	@FindBy(id = "location")
	private WebElement location;
	
	@FindBy(id = "hotels")
	private WebElement hotels;
	
	@FindBy(id = "room_type")
	private WebElement roomtype;
	
	@FindBy(id = "room_nos")
	private WebElement nofrooms;
	
	@FindBy(id = "datepick_in")
	private WebElement date1;
	
	@FindBy(id = "datepick_out")
	private WebElement date2;
	
	@FindBy(id = "adult_room")
	private WebElement adultroom;
	
	@FindBy(id = "child_room")
	private WebElement chidlroom;
	
	@FindBy(id = "Submit")
	private WebElement searchbtn;
	
	public searchHotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getlocation() {
		return location;
	}
	
	public WebElement gethotels() {
		return hotels;
	}
	
	public WebElement getroomtype() {
		return roomtype;
	}
	
	public WebElement getnofrooms() {
		return nofrooms;
	}
	
	public WebElement getdate1() {
		return date1;
	}
	
	public WebElement getdate2() {
		return date2;
	}
	
	public WebElement getadultroom() {
		return adultroom;
	}
	
	public WebElement getchidlroom() {
		return chidlroom;
	}
	
	public WebElement getsearchbtn() {
		return searchbtn;
	}
	
}
