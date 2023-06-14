package Data_Driven;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "login")
	public Object[][] login() {
		Object[][] data= {
			
				{"https://adactinhotelapp.com/","",""},
				{"https://adactinhotelapp.com/","chidambaram","sjkafkj"},
				{"https://adactinhotelapp.com/","chidambaramradhakrishnan","mmchidambaram"},
				{"https://adactinhotelapp.com/","cyberchid","Chid"},
				{"https://adactinhotelapp.com/","cyberchid","ma9159214653"}
		};
		return data;
	}
}
