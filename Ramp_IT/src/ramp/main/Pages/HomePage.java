package ramp.main.Pages;

import ramp.main.Objects.Homepageobject;
import ramp.main.genericLib.Ramp_ItGenericLibrary;
import ramp.main.utility.PropertyReader;

public class HomePage extends Ramp_ItGenericLibrary {

	// Login with data on the property file
	public void loginPage() {
		typeTextInInputField(Homepageobject.loginId, PropertyReader.getGlobalProperty("rampLoginID"), "Login Id");
		typeTextInInputField(Homepageobject.passWord, PropertyReader.getGlobalProperty("rampPassword"), "Password");
		click(Homepageobject.loginButton, "Login Button");
	}
	//Login with the data provided externally
	public void loginPage(String loginId, String password , String userName) {
		typeTextInInputField(Homepageobject.loginId, loginId, "Login Id - "+ userName);
		typeTextInInputField(Homepageobject.passWord, password, "Password");
		click(Homepageobject.loginButton, "Login Button");
	}
	
	public void verifyResources() {
		
		click(Homepageobject.resourceRequest, "Click on resource request tab");
		click(Homepageobject.addNewResourceRequest, "Click on add new resource Request Button");
	}
	
}
