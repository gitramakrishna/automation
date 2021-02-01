package ramp.main.genericLib;

import ramp.main.Objects.Homepageobject;
import ramp.main.utility.Action2;
import ramp.main.utility.PropertyReader;

public class HomePageOperation extends Action2 {

	// Login with data on the property file
	public static void loginPage() {
		typeTextInInputField(Homepageobject.loginId, PropertyReader.getGlobalProperty("rampLoginID"), "Login Id");
		typeTextInInputField(Homepageobject.passWord, PropertyReader.getGlobalProperty("rampPassword"), "Password");
		click(Homepageobject.loginButton, "Login Button");
	}
	//Login with the data provided externally
	public static void loginPage(String loginId, String password , String userName) {
		typeTextInInputField(Homepageobject.loginId, loginId, "Login Id - "+ userName);
		typeTextInInputField(Homepageobject.passWord, password, "Password");
		click(Homepageobject.loginButton, "Login Button");
	}
	
	public static void verifyResources() {
		
		click(Homepageobject.resourceRequest, "Click on resource request tab");
		click(Homepageobject.addNewResourceRequest, "Click on add new resource Request Button");
	}
	
}
