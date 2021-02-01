package ramp.main.genericLib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ramp.main.Objects.Homepageobject;
import ramp.main.utility.Action2;
import ramp.main.utility.DriverManager;

public class Ramp_ItGenericLibrary extends Action2 {

	public static void selectValueFromDropdownBasedOnLabel(String labelName, String valueToSelect){
		By fieldLocation = By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div[@class='form-group']//span[@role='combobox']");
		//scrollToTheWebElemntByLocation(fieldLocation);
		click(fieldLocation, labelName);
		wait(1);
		String idOfDropDownContainer = getElementAttribute(fieldLocation, "aria-owns");
		By locationOfDropDownValues = By.xpath("//ul[@id='"+idOfDropDownContainer+"']/li[text()='"+valueToSelect+"']");
		click(locationOfDropDownValues, valueToSelect);
	}

	public  static void selectFirstValueFromDropdownBasedOnLabel(String labelName){
		By fieldLocation = By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div[@class='form-group']//span[@role='combobox']");
		//scrollToTheWebElemntByLocation(fieldLocation);
		click(fieldLocation, labelName);
		String idOfDropDownContainer = getElementAttribute(fieldLocation, "aria-owns");
		By locationOfDropDownValues = By.xpath("//ul[@id='"+idOfDropDownContainer+"']/li[2]");
		click(locationOfDropDownValues, getWebElementText(locationOfDropDownValues, "First Option"));
	}
	public void selectRandomValueFromDropdownBasedOnLabel(String labelName){
		By fieldLocation = By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div[@class='form-group']//span[@role='combobox']");
		//scrollToTheWebElemntByLocation(fieldLocation);
		click(fieldLocation, labelName);
		String idOfDropDownContainer = getElementAttribute(fieldLocation, "aria-owns");
		By locationOfDropDownValues = By.xpath("//ul[@id='"+idOfDropDownContainer+"']/li");
		int indexOfValueToSelect = generateRandomNumberBetween(2, getNumberOfWebelement(locationOfDropDownValues));
		By locationOfValueToSelect = By.xpath("//ul[@id='"+idOfDropDownContainer+"']/li["+indexOfValueToSelect+"]");
		click(locationOfDropDownValues, getWebElementText(locationOfValueToSelect, indexOfValueToSelect+" Option"));
	}
	public  ArrayList<String> getListOfAvailableValuesForADropDownBasedOnLabel(String labelName){
		By fieldLocation = By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div[@class='form-group']//span[@role='combobox']");
		//scrollToTheWebElemntByLocation(fieldLocation);
		click(fieldLocation, labelName);
		String idOfDropDownContainer = getElementAttribute(fieldLocation, "aria-owns");
		By locationOfDropDownValues = By.xpath("//ul[@id='"+idOfDropDownContainer+"']/li");
		ArrayList<String> listOfValues = getStringListFromWebElements(locationOfDropDownValues);
		clickWithoutReporting(fieldLocation);
		return listOfValues;
	}
	public String getSelectedValueFromDropDown(String labelName){
		By fieldLocation = By.xpath("//label[contains(text(),'"+labelName+"')]/parent::div[@class='form-group']//span[@role='combobox']");
		return getWebElementText(fieldLocation, labelName);
	}

	// DAte format should be dd-MM-YYYY
	public static void selectDateInCalendarWidget(String date){
		try {
			String reqDate = (new SimpleDateFormat("dd-MMMM-yyyy")).format((new SimpleDateFormat("dd-MM-yyyy")).parse(date));
			String[] dates = reqDate.split("-");
			By dateLocation = By.xpath("//div[@class='datepicker-days']//tbody/tr/td[text()="+dates[0]+"][not(contains(@class,'old'))]");
			By calCurrentMonthYearLoc = By.xpath("//div[@class='datepicker-days']//thead//th[@class='datepicker-switch']");
			By reqMonthLocation = By.xpath("//div[@class='datepicker-months']//span[contains(@class,'month')][text()='"+dates[1].substring(0, 3)+"']");
			By yearSwitch = By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch']");
			String calCurrentMonthYear = DriverManager.get().findElement(calCurrentMonthYearLoc).getText();
			String reqMonthYear = dates[1]+" "+dates[2];
			if(reqMonthYear.equals(calCurrentMonthYear)){
				click(dateLocation, reqDate);
			}else{
				if(Integer.parseInt(dates[2])== Integer.parseInt(calCurrentMonthYear.split(" ")[1])){
					DriverManager.get().findElement(calCurrentMonthYearLoc).click();
					selectMonthandDateInCalendar(reqMonthLocation, dateLocation,reqDate);
				}else {
					DriverManager.get().findElement(calCurrentMonthYearLoc).click();
					DriverManager.get().findElement(yearSwitch).click();;
					String yearDuration = DriverManager.get().findElement(By.xpath("//div[@class='datepicker-years']//th[@class='datepicker-switch']")).getText();
					if (Integer.parseInt(dates[2]) <= Integer.parseInt(yearDuration.split("-")[1]) && Integer.parseInt(dates[2]) >= Integer.parseInt(yearDuration.split("-")[0])) {
						DriverManager.get().findElement(By.xpath("//div[@class='datepicker-years']//span[contains(@class,'year')][text()="+dates[2]+"]")).click();
						selectMonthandDateInCalendar(reqMonthLocation, dateLocation,reqDate);
					}else {
						if(Integer.parseInt(dates[2]) > Integer.parseInt(yearDuration.split("-")[0])){
							while(Integer.parseInt(dates[2]) <= Integer.parseInt(yearDuration.split("-")[1]) && Integer.parseInt(dates[2]) >= Integer.parseInt(yearDuration.split("-")[0])){
								DriverManager.get().findElement(By.xpath("//div[@class='datepicker-years']//th[@class='prev']")).click();
							}
						}else {
							while(Integer.parseInt(dates[2]) <= Integer.parseInt(yearDuration.split("-")[1]) && Integer.parseInt(dates[2]) >= Integer.parseInt(yearDuration.split("-")[0])){
								DriverManager.get().findElement(By.xpath("//div[@class='datepicker-years']//th[@class='next']")).click();
							}
						}
						DriverManager.get().findElement(By.xpath("//div[@class='datepicker-years']//span[contains(@class,'year')][text()="+dates[2]+"]")).click();
						selectMonthandDateInCalendar(reqMonthLocation, dateLocation,reqDate);
					}}}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	private static void selectMonthandDateInCalendar(By reqMonthLocation, By dateLocation, String reqDate){
		DriverManager.get().findElement(reqMonthLocation).click();
		click(dateLocation, reqDate);
	}


	public static String generateRandomStringWithLength(int targetStringLength){
		Random random = new Random();
		String generatedString = random.ints(97, 122 + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

	public String generateRandomAlphaNumericStringWithLength(int targetStringLength){
		Random random = new Random();
		String generatedString = random.ints(48, 122 + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}
	// Return a Date String in dd-MM-YYYY format, if exception occurs returns Null
	public static String getDateAfterTheCurrentDate(long days){
		try {
			return (new SimpleDateFormat("dd-MM-yyyy")).format((new SimpleDateFormat("yyyy-MM-dd")).parse(LocalDateTime.now().plusDays(days).toLocalDate().toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public String getDateBeforeTheCurrentDate(long days){
		try {
			return (new SimpleDateFormat("dd-MM-YYYY")).format((new SimpleDateFormat("yyyy-MM-dd")).parse(LocalDateTime.now().minusDays(days).toLocalDate().toString()));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void waitForDissappearenceOfLoader(int timeOutInSeconds){
		try{
			By loader = By.xpath("//div [@id='preloader']");
			WebDriverWait wait = new WebDriverWait(DriverManager.get(), timeOutInSeconds);
			wait.until(ExpectedConditions.invisibilityOf(getWebElement(loader)));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void typeTextInAutoCompleteInputBoxAndSelectFirstOption(By location,String dataToType,String fieldName){
		try {
			typeTextInInputField(location, dataToType, fieldName);
			wait(3);
			WebElement autoElement = getWebElement(By.xpath("//ul[contains(@id,'ui-id')][contains(@style,'display: block')]/li[1]"));
			autoElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void typeTextInAutoCompleteInputBoxAndSelectMultipleOption(By location,String dataToType,String fieldName){
		try {
			typeTextInInputField(location, dataToType, fieldName);
			wait(3);
			WebElement autoElement = getWebElement(By.xpath("//ul[contains(@id,'select2-showMultipleId-results')]/li[1]"));
			autoElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void logout(){
		click(Homepageobject.profileIcon, "Profile Icon");
		click(Homepageobject.logoutButton, "Logout Button");
		click(Homepageobject.loginButton, "Login Button");
	}
}
