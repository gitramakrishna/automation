package ramp.main.Objects;

import org.openqa.selenium.By;

public class AlertPopUp {

	public static String alertPop = "//div[contains(@class,'sweet-alert')][contains(@class,'showSweetAlert')][contains(@class,'visible')]";
	public static By alertPopUpWindow = By.xpath(alertPop);
	public static By yesButton = By.xpath(alertPop+"//button[text()='Yes']");
	public static By noButton = By.xpath(alertPop+"//button[text()='Yes']");
	public static By highLightAlertMessage = By.xpath(alertPop+"/h2");
	public static By OkButton = By.xpath(alertPop+"//button[text()='OK']");
	
	public static By taskStatus = By.xpath(alertPop+"/div[@style='display: block;'][contains(@class,'sa-icon')]");
	
	public static By yesCopyIt = By.xpath("//button[normalize-space()='Yes, copy it !!']");
}
