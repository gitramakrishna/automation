package ramp.test.rampTest;

import org.testng.annotations.Test;

import ramp.main.Pages.HomePage;
import ramp.main.utility.BaseClass;

public class HomepageTest extends BaseClass {
	
	@Test
	public void verifyResources() {
		HomePage homePage = new HomePage();
		homePage.verifyResources();
	}

}
