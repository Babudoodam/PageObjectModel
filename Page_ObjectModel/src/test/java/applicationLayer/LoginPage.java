package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name="btnreset")
	WebElement ObjReset;
	@FindBy(xpath ="//input[@id='username']")
	WebElement ObjUser;
	@FindBy(xpath="//input[@id='password']")
	WebElement ObjPass;
	@FindBy(id="btnsubmit")
	WebElement ObjLogin;
	
	public void adminLogin(String Username, String Password) {
		
		ObjReset.click();
		ObjUser.sendKeys(Username);
		ObjPass.sendKeys(Password);
		ObjLogin.click();
	}
	
}
