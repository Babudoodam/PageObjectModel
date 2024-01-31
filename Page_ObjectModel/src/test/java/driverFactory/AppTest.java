package driverFactory;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationLayer.CustomerPage;
import cofig.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{

	String InputFilePath = "./FileInput/CustomerCreationData.xlsx";
	String OutputFilePath = "./FileOutput/CustomerCreationResult.xlsx";
	String SheetName = "CustomerData";
	
	ExtentReports report;
	ExtentTest logger;
	@Test
	public void startTest() throws Throwable{
		
		report = new ExtentReports("./target/PageObjectModel/CustomerCreation.html");
		
		ExcelFileUtil xl = new ExcelFileUtil(InputFilePath);
		int rc = xl.rowCount(SheetName);
		for (int i = 1; i <= rc; i++) {
			logger = report.startTest("Validate Customer Creaton"+i);
			
			String CustomerName = xl.getCellData(SheetName, i, 0);
			String Address = xl.getCellData(SheetName, i, 1);
			String City = xl.getCellData(SheetName, i, 2);
			String Country = xl.getCellData(SheetName, i, 3);
			String ContactName = xl.getCellData(SheetName, i, 4);
			String PhoneNum = xl.getCellData(SheetName, i, 5);
			String EMail = xl.getCellData(SheetName, i, 6);
			String MobileNum = xl.getCellData(SheetName, i, 7);
			String Notes = xl.getCellData(SheetName, i, 8);
			
			logger.log(LogStatus.INFO, CustomerName+" --"+Address+" --"+City+" --"+ Country+" --"+ ContactName+" --"+ PhoneNum+" --"+ EMail+" --"+ MobileNum+" --"+ Notes);
			CustomerPage customer = PageFactory.initElements(driver, CustomerPage.class);
			boolean res = customer.add_customer(CustomerName, Address, City, Country, ContactName, PhoneNum, EMail, MobileNum, Notes);
			if(res) {
				xl.setCellData(SheetName, i, 9, "Pass", OutputFilePath);
				logger.log(LogStatus.PASS, "Customer Creation Success");
				
			}
			else {
				xl.setCellData(SheetName, i, 9, "Fail", OutputFilePath);
				logger.log(LogStatus.FAIL, "Customer Creation UnSuccess");
			}
			
			report.endTest(logger);
			report.flush();
			
		}
	}
	
	
}
