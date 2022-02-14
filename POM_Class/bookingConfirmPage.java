package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bookingConfirmPage {
	public WebDriver driver;
	
	@FindBy(id = "my_itinerary")
	private WebElement myitibtn;
	
	@FindBy(id = "logout")
	private WebElement logout;
	
	public bookingConfirmPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getmyitiBtn() {
		return myitibtn;
	}
	
	public WebElement getLogout() {
		return logout;
	}
}
