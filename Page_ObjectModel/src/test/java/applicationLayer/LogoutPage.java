package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {

	@FindBy(xpath="(//a[text()=' Logout'])[2]")
	WebElement ObjLogout;
	
	public void admiLogout() {
		
		ObjLogout.click();
	}
}
