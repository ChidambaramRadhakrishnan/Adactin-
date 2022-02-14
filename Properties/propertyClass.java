package Properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class propertyClass {

	Properties ppts;

	public propertyClass() throws Exception {
		File fl = new File(
				"C:\\Users\\Chidambaram\\eclipse-workspace\\Adactin.com\\src\\test\\java\\Properties\\property.properties");

		FileInputStream flips = new FileInputStream(fl);

		ppts = new Properties();

		ppts.load(flips);
	}

	public String geturl() {
		return ppts.getProperty("url");
	}

	public String getuserName() {
		return ppts.getProperty("username");
	}

	public String getpassword() {
		return ppts.getProperty("password");
	}
	
	public String getlocation() {
		return ppts.getProperty("location");
	}
	
	public String gethotel() {
		return ppts.getProperty("hotel");
	}
	
	public String getroomtype() {
		return ppts.getProperty("roomtype");
	}
	
	public String getrooms() {
		return ppts.getProperty("rooms");
	}
	
	public String getindate() {
		return ppts.getProperty("indate");
	}
	
	public String getoutdate() {
		return ppts.getProperty("outdate");
	}
	
	public String getadult() {
		return ppts.getProperty("adult");
	}
	
	public String getchild() {
		return ppts.getProperty("child");
	}
	
	public String getfname() {
		return ppts.getProperty("fname");
	}
	
	public String getlname() {
		return ppts.getProperty("lname");
	}
	
	public String getbaddress() {
		return ppts.getProperty("baddress");
	}
	
	public String getcreditcn() {
		return ppts.getProperty("creditcn");
	}
	
	public String getcredittype() {
		return ppts.getProperty("credittype");
	}
	
	public String getcreditexpiry() {
		return ppts.getProperty("creditexpiry");
	}
	
	public String getcreditexpiryyear() {
		return ppts.getProperty("creditexpiryyear");
	}
	
	public String getccv() {
		return ppts.getProperty("ccv");
	}
	
	public String getHotelName() {
		return ppts.getProperty("hotel");
	}
	

	
}
