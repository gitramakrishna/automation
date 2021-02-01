package ramp.main.utility;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ramp.main.Pages.HomePage;

public class BaseClass {
	
	
	
	
	@BeforeSuite
	public void beforeSuite() {
		PropertyReader.loadGlobalProperties();
		ceateOutputFolderAndSetPath(PropertyReader.getGlobalProperty("rampOutputReportPath"));
		ExtentManager.initializeExtentReport(GlobalValues.outputFolderPath, PropertyReader.getGlobalProperty("rampReportName"));
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("In before Class");
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		GlobalValues.currentTestCaseName.set(method.getName());
		DriverManager.set(DriverManager.startBrowser(PropertyReader.getGlobalProperty("browser")));
		DriverManager.get().manage().window().maximize();
		DriverManager.get().get(PropertyReader.getGlobalProperty("rampUrl"));
		ExtentManager.intializeExtentTest(GlobalValues.currentTestCaseName.get());
		HomePage homePage = new HomePage();
		homePage.loginPage();
		Action.wait(2);
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@AfterMethod
	public void afterMethod() {
		DriverManager.close();
	}

	
	@AfterSuite
	public void afterSuite() {
		System.out.println("In After Suite");
		ExtentManager.flush();
	}
	
	public void ceateOutputFolderAndSetPath(String outPutLocation){
		String currentDateFolder = (new SimpleDateFormat("dd-MM-YYYY")).format(Calendar.getInstance().getTime());
		File outputFolder = new File(outPutLocation+System.getProperty("file.separator")+currentDateFolder);
		if(!outputFolder.exists()){
			try {
				outputFolder.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		GlobalValues.outputFolderPath = outputFolder.getAbsolutePath();
		
	}
	 
}
