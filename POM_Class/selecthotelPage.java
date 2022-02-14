package POM_Class;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selecthotelPage {

	public WebDriver driver;
	
	@FindBy(xpath = "(//table[@class='login']/tbody/tr/following::table)[1]/tbody/tr[2]/td")
	private  List<WebElement> data1;
	
	@FindBy(xpath = "(//table[@class='login']/tbody/tr/following::table)[1]/tbody/tr[2]/td/child::input[1]")
	private List<WebElement> input;
	
	@FindBy(id = "continue")
	private WebElement contue;
	
	public selecthotelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getdata1() {
		return data1;
	}
	
	public List<WebElement> getinput() {
		return input;
	}
	
	public WebElement getcontue() {
		return contue;
	}
	
}
