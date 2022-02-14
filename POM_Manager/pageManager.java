package POM_Manager;

import org.openqa.selenium.WebDriver;

import POM_Class.bookhotelPage;
import POM_Class.bookingConfirmPage;
import POM_Class.loginPage;
import POM_Class.searchHotelPage;
import POM_Class.selecthotelPage;

public class pageManager {
	
	public WebDriver driver;
	
	private loginPage lgPage;
	
	private searchHotelPage srhPage;
	
	private selecthotelPage slhPage;
	
	private bookhotelPage bhPage;
	
	private bookingConfirmPage bkcPage;
	
	public pageManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public loginPage getlgPage() {
		if(lgPage==null) {
			lgPage=new loginPage(driver);
		}
		return lgPage;
	}
	
	public searchHotelPage getsrhPage() {
		if(srhPage==null) {
			srhPage=new searchHotelPage(driver);
		}
		return srhPage;
	}
	
	public selecthotelPage getslhPage() {
		if(slhPage==null) {
			slhPage=new selecthotelPage(driver);
		}
		return slhPage;
	}
	
	public bookhotelPage getbhPage() {
		if(bhPage==null) {
			bhPage=new bookhotelPage(driver);
		}
		return bhPage;
	}
	
	
	public bookingConfirmPage getbkcPage() {
		if(bkcPage==null) {
			bkcPage=new bookingConfirmPage(driver);
		}
		return bkcPage;
	}
	
	
	
}
