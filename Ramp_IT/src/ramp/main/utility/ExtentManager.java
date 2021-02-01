package ramp.main.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.observer.ReportObserver;
import com.aventstack.extentreports.observer.entity.ReportEntity;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extentReport;
	public static ExtentSparkReporter extentReporter;
	public static ReportObserver<ReportEntity> extentObserver;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<ExtentTest> testNode = new ThreadLocal<ExtentTest>();

	public static void  initializeExtentReport(String ReportLocation, String ReportName){
		extentReport = new ExtentReports();
		extentObserver = new ExtentSparkReporter(ReportLocation+System.getProperty("file.separator")+ReportName+".html");
		extentReport.attachReporter(extentObserver);
	}

	public static void intializeExtentTest(String testCaseName){
		extentTest.set(extentReport.createTest(testCaseName));
	}

	public static void addPassStepsOfTestCase(String passStatement, String screenShotPath){
		/*extentTest.get().pass(passStatement);
		extentTest.get().addScreenCaptureFromPath(screenShotPath);
		*/
		extentTest.get().addScreenCaptureFromPath(screenShotPath, passStatement);
	}
	public static void addFailStepsOfTestCase(String failStatement, String screenShotPath){
		extentTest.get().fail(failStatement);
		extentTest.get().addScreenCaptureFromPath(screenShotPath);
	}

	public static void addFailStepsOfTestCase(String failStatement, String screenShotPath, Exception e){
		extentTest.get().fail(failStatement);
		extentTest.get().fail(e.toString());
		extentTest.get().addScreenCaptureFromPath(screenShotPath);
	}
	
	public static void createStepNodeForTestCase(String stepName, String passOrFailDescription , String status, String screenShotPath){
		testNode.set(extentTest.get().createNode(stepName));
		if("pass".equalsIgnoreCase(status)){
			testNode.get().pass(passOrFailDescription);
			testNode.get().addScreenCaptureFromPath(screenShotPath);
		}else if("fail".equalsIgnoreCase(status)){
			testNode.get().fail(passOrFailDescription);
			testNode.get().addScreenCaptureFromPath(screenShotPath);
		}else if("warning".equalsIgnoreCase(status)){
			testNode.get().warning(passOrFailDescription);
			testNode.get().addScreenCaptureFromPath(screenShotPath);
		}else if("info".equalsIgnoreCase(status)){
			testNode.get().warning(passOrFailDescription);
			testNode.get().addScreenCaptureFromPath(screenShotPath);
		}
	}
	
	public static void flush() {
		extentReport.flush();
	}


}
