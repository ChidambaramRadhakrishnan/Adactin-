package POM_Class;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bookhotelPage {
		
	public WebDriver driver;
	
	@FindBy(id = "first_name")
	private WebElement firstname;

	@FindBy(id = "last_name")
	private WebElement lastname;
	
	@FindBy(id = "address")
	private WebElement address;
	
	@FindBy(id = "cc_num")
	private WebElement creditcn;
	
	@FindBy(id = "cc_type")
	private WebElement creditct;
	
	@FindBy(id = "cc_exp_month")
	private WebElement creditcem;
	
	@FindBy(id = "cc_exp_year")
	private WebElement creditcey;
	
	@FindBy(id = "cc_cvv")
	private WebElement ccv;
	
	@FindBy(id = "book_now")
	private WebElement booknowBtn;
	
	public bookhotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditcn() {
		return creditcn;
	}

	public WebElement getCreditct() {
		return creditct;
	}

	public WebElement getCreditcem() {
		return creditcem;
	}

	public WebElement getCreditcey() {
		return creditcey;
	}

	public WebElement getCcv() {
		return ccv;
	}

	public WebElement getBooknowBtn() {
		return booknowBtn;
	}
	
	
	
	
}
