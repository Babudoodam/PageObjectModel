package applicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class CustomerPage {
WebDriver driver;
public CustomerPage(WebDriver driver) {
	this.driver = driver;
}

//Repository
	@FindBy(xpath="(//a[contains(.,'Customers')])[2]")
	WebElement ObjCustomer;
	@FindBy(xpath="(//span[@data-caption='Add'])[1]")
	WebElement ObjCustomerAdd;
	@FindBy(xpath="//input[@id='x_Customer_Number']")
	WebElement ObjCustomerNum;
	@FindBy(id="x_Customer_Name")
	WebElement ObjCustomerName;
	@FindBy(name="x_Address")
	WebElement ObjAddress;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement ObjCity;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement ObjCountry;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement ObjContactPerson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement ObjPhoneNum;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement ObjEmail;
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement ObjMobileNum;
	@FindBy(xpath="//input[@id='x_Notes']")
	WebElement ObjNotes;
	@FindBy(xpath="//button[@id='btnAction']")
	WebElement ObjAddBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjConfirmOk;
	@FindBy(xpath="//div[@class='alert alert-success ewSuccess']")
	WebElement ObjAlertMessage;
	@FindBy(xpath="//button[@class='ajs-button btn btn-primary']")
	WebElement ObjAlertOk;
	
	@FindBy(xpath="//span[@data-caption='Search']")
	WebElement ObjSearchIcon;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement ObjSearchTextBox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement ObjSearchBtn;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr/td[5]/div/span/span")
	WebElement ObjActualCustomerNum;
	
	public boolean add_customer(String CustomerName, String Address, String City, String Country, String ContactName, 
			String PhoneNum, String EMail, String MobileNum, String Notes ) {
		this.ObjCustomer.click();
		this.ObjCustomerAdd.click();
		String Exp_Num = this.ObjCustomerNum.getAttribute("value");
		this.ObjCustomerName.sendKeys(CustomerName);
		this.ObjAddress.sendKeys(Address);
		this.ObjCity.sendKeys(City);
		this.ObjCountry.sendKeys(Country);
		this.ObjContactPerson.sendKeys(ContactName);
		this.ObjPhoneNum.sendKeys(PhoneNum);
		this.ObjEmail.sendKeys(EMail);
		this.ObjMobileNum.sendKeys(MobileNum);
		this.ObjNotes.sendKeys(Notes);
		this.ObjAddBtn.click();
		this.ObjConfirmOk.click();
		this.ObjAlertOk.click();
		if(!this.ObjSearchTextBox.isDisplayed())
			this.ObjSearchIcon.click();
		this.ObjSearchTextBox.clear();
		this.ObjSearchTextBox.sendKeys(Exp_Num);
		this.ObjSearchBtn.click();
		String Act_Num = this.ObjActualCustomerNum.getText();
		if(Act_Num.equals(Exp_Num)) {
			Reporter.log("Customer Adding Successful",true);
			return true;
		}else {
			Reporter.log("Customer Adding UnSuccessful",true);
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
