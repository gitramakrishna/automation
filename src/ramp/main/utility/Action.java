package ramp.main.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Action {


	public  void click(By location , String webElementLabel) {
		try {
			//scrollToTheWebElemntByLocation(location);
			DriverManager.get().findElement(location).click();
			ExtentManager.createStepNodeForTestCase("Click on "+ webElementLabel, "Clicked on "+ webElementLabel, "pass", takeScreenShot());
		}catch(Exception e) {
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase("Click on "+ webElementLabel, "Unable to click on "+ webElementLabel+"</br>"+e, "fail", takeScreenShot());
		}
	}
	
	public void clickWithoutReporting(By location){
		try {
			getWebElement(location).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void typeTextInInputField(By location ,String dataToType, String fieldName) {
		try {
			//scrollToTheWebElemntByLocation(location);
			DriverManager.get().findElement(location).clear();
			DriverManager.get().findElement(location).sendKeys(dataToType);
			ExtentManager.createStepNodeForTestCase("Enter " + dataToType +" in "+ fieldName,"Entered " + dataToType +" in "+ fieldName, "pass", takeScreenShot());
		} catch (Exception e) {
			ExtentManager.createStepNodeForTestCase("Enter " + dataToType +" in "+ fieldName,"Unable to enter " + dataToType +" in "+ fieldName+"</br>+ e", "fail", takeScreenShot());
		}
	}
	public void typeTextInInputField(By location ,int dataToType, String fieldName) {
		try {
			//scrollToTheWebElemntByLocation(location);
			DriverManager.get().findElement(location).clear();
			DriverManager.get().findElement(location).sendKeys(dataToType+"");
			ExtentManager.createStepNodeForTestCase("Enter " + dataToType +" in "+ fieldName,"Entered " + dataToType +" in "+ fieldName, "pass", takeScreenShot());
		} catch (Exception e) {
			ExtentManager.createStepNodeForTestCase("Enter " + dataToType +" in "+ fieldName,"Unable to enter " + dataToType +" in "+ fieldName+"</br>+ e", "fail", takeScreenShot());
		}
	}

	public String takeScreenShot(){
		try {
			File scrnShotPath = ((TakesScreenshot) DriverManager.get()).getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(GlobalValues.outputFolderPath+System.getProperty("file.separator")+"Screenshots"+
					System.getProperty("file.separator")+GlobalValues.currentTestCaseName.get());
			if(!destinationPath.exists()){
				destinationPath.mkdirs();
			}
			FileUtils.copyFileToDirectory(scrnShotPath, destinationPath);
			return destinationPath.getAbsolutePath()+System.getProperty("file.separator")+scrnShotPath.getName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}	
	}
	public String getWebElementText(By location, String fieldName){
		try{
			String webElementText = DriverManager.get().findElement(location).getText();
			//ExtentManager.addPassStepsOfTestCase("Text of "+ fieldName + "is "+ webElementText, takeScreenShot());
			return webElementText;
		}catch(Exception e){
			e.printStackTrace();
			//ExtentManager.addFailStepsOfTestCase("Unable to get text of "+fieldName, takeScreenShot(), e);
			return null;
		}
	}

	public void compareTwoStrings(String actualString , String expectedString){
		try{if(actualString.equals(expectedString)){
			ExtentManager.createStepNodeForTestCase("Comparing "+expectedString +", "+actualString, "Both "+expectedString +", "+actualString + " are same", "pass", takeScreenShot());
		}else{
			ExtentManager.createStepNodeForTestCase("Comparing "+expectedString +", "+actualString, "Both "+expectedString +", "+actualString + " are not same", "fail", takeScreenShot());
		}}catch(Exception e){
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase("Comparing "+expectedString +", "+actualString, "Unable to comapre "+expectedString +", "+actualString +"</br>"+e, "fail", takeScreenShot());
		}
	}

	public void selectValueFromDropDown(By Location, String label, String valueToSelect){
		try {
			WebElement element = DriverManager.get().findElement(Location);
			Select select = new Select(element);
			select.selectByVisibleText(valueToSelect);
			ExtentManager.createStepNodeForTestCase("Select "+ valueToSelect +"in " +label +"dropdown", "Selected "+ valueToSelect + "in "+label +"dropdown", "Pass", takeScreenShot());
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase("Select "+ valueToSelect +"in "+ label +"dropdown", "Unable to select "+ valueToSelect +"in "+ label +"dropdown", "fail", takeScreenShot());
		}
	}
	
	public String getSelectedValueFromDropDown(By Location, String label){
		try {
			WebElement element = DriverManager.get().findElement(Location);
			Select select = new Select(element);
			return select.getFirstSelectedOption().getText();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void verifyElementVisibe(By location, String filedName) {
		try {
			WebElement element = DriverManager.get().findElement(location);
			if(element.isDisplayed()){
				ExtentManager.createStepNodeForTestCase("Verify if the "+ filedName + "is Displayed", filedName + "is Displayed", "pass", takeScreenShot());
			}else{
				ExtentManager.createStepNodeForTestCase("Verify if the "+ filedName + "is Displayed", filedName + "is not Displayed", "fail", takeScreenShot());
			}
		} catch (Exception e) {
			ExtentManager.createStepNodeForTestCase("Verify if the "+ filedName + "is Displayed", filedName + "is Displayed"+"</br>"+e, "fail", takeScreenShot());
		}

	}

	public void verifyElementVisibeWithMandatorySign(By fieldLocation, String filedName, By mandatorySignLocator) {
		try {
			WebElement element = DriverManager.get().findElement(fieldLocation);
			if(element.isDisplayed()){
				try{
					scrollToTheWebElemntByWebElement(element);
					WebElement mandatorySign = element.findElement(mandatorySignLocator);
					if(mandatorySign.isDisplayed()){
						ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is displayed", "pass", takeScreenShot());
					}else {
						ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed", "fail", takeScreenShot());
					}
				}catch(Exception e){
					e.printStackTrace();
					ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed" +"</br>"+ e, "fail", takeScreenShot());
				}
			}else{
				ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed", "fail", takeScreenShot());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed" +"</br>"+ e, "fail", takeScreenShot());
		}

	}
	public void verifyElementVisibeWithMandatorySign(By fieldLocation, String filedName, By mandatorySignLocator,Boolean mandatorySignVisibilityStatus) {
		try {
			WebElement element = DriverManager.get().findElement(fieldLocation);
			if(element.isDisplayed()){
				try{
					//scrollToTheWebElemntByWebElement(element);
					WebElement mandatorySign = element.findElement(mandatorySignLocator);
					if(mandatorySignVisibilityStatus.equals(true)){
					if(mandatorySign.isDisplayed()){
						ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" mandatory icon * is displayed", "pass", takeScreenShot());
					}else {
						ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed", "fail", takeScreenShot());
					}
					}else{
						if(!mandatorySign.isDisplayed()){
							ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" mandatory icon is not displayed", "pass", takeScreenShot());
						}else {
							ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" mandatory icon is displayed", "fail", takeScreenShot());
						}	
					}
				}catch(Exception e){
					e.printStackTrace();
					ExtentManager.createStepNodeForTestCase("Verify "+filedName +" mandatory icon is displayed","Unable to find"+ filedName+" mandatory icon" +"</br>"+ e, "fail", takeScreenShot());
				}
			}else{
				ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed", "fail", takeScreenShot());
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase("Verify "+filedName +" is displayed", filedName+" is not displayed" +"</br>"+ e, "fail", takeScreenShot());
		}

	}

	public static void wait(int numberOfSecond){
		try {
			Thread.sleep(numberOfSecond*1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public WebElement getWebElement(By location){
		return DriverManager.get().findElement(location);
	}

	public void scrollToTheWebElemntByLocation(By location){
		try{
			((JavascriptExecutor) DriverManager.get()).executeScript("arguments[0].scrollIntoView(true);", getWebElement(location));
		}catch(Exception e){

		}
	}
	public void scrollToTheWebElemntByWebElement(WebElement webElement){
		try{
			((JavascriptExecutor) DriverManager.get()).executeScript("arguments[0].scrollIntoView(true);",webElement);
		}catch(Exception e){

		}
	}

	public String getElementAttribute(By location,String attributeName){
		String attributeValue = "";
		try {
			WebElement element = getWebElement(location);
			attributeValue = element.getAttribute(attributeName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeValue;
	}

	public String getWebElementCSS(By location ,String cssName){
		String cssValue= "";
		try {
			WebElement we = DriverManager.get().findElement(location);
			cssValue = we.getCssValue(cssName);
		} catch (Exception e) {
			e.printStackTrace();
			cssValue= null;
		}
		return cssValue;
	}
	public ArrayList<WebElement> getListOfSimilarWebElements(By location){
		try{
			return (ArrayList<WebElement>)DriverManager.get().findElements(location);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> getStringListFromWebElements(By location){
		try{
			ArrayList<String> arrayList = new ArrayList<String>();
			for(WebElement we : getListOfSimilarWebElements(location)){
				arrayList.add(we.getText());
			}
			return arrayList;
		}catch(Exception e){
			return null;
		}
	}

	public int getNumberOfWebelement(By location){
		return getListOfSimilarWebElements(location).size();
	}

	public int generateRandomNumberBetween(int startNumber, int endNumber){
		return (int) (Math.random()*(endNumber-startNumber+1) +startNumber);
	}

	public void hoverOverAWebElement(By location, String filedName){
		try{
			Actions action = new Actions(DriverManager.get());
			action.moveToElement(getWebElement(location)).build().perform();
			ExtentManager.createStepNodeForTestCase("Hover over "+filedName,"Hover overed "+ filedName, "pass", takeScreenShot());
		}catch(Exception e){
			System.out.println("Trying hoverover using javascript "+ e.getClass().getName());
			try{
				JavascriptExecutor js = (JavascriptExecutor) DriverManager.get();
				js.executeScript("arguments[0].onmouseover()", getWebElement(location));
				ExtentManager.createStepNodeForTestCase("Hover over "+filedName,"Hover overed "+ filedName, "pass", takeScreenShot());
			}catch(Exception javaScriptException){
				ExtentManager.createStepNodeForTestCase("Hover over "+filedName,"Failed to hover over "+ filedName, "fail", takeScreenShot());
				javaScriptException.printStackTrace();
			}
		}
	}

	public String extractIntFromString(String requiredString){
		requiredString = requiredString.replaceAll("[^\\d]", "");
		return requiredString;
	}

	public void executeJavaScript(String script, String scriptExecutionDescription){
		try{
			JavascriptExecutor js = (JavascriptExecutor)DriverManager.get();
			js.executeScript(script);
			ExtentManager.createStepNodeForTestCase(scriptExecutionDescription,scriptExecutionDescription, "pass", takeScreenShot());
		}catch(Exception e){
			e.printStackTrace();
			ExtentManager.createStepNodeForTestCase(scriptExecutionDescription,"Failed to do: "+scriptExecutionDescription, "pass", takeScreenShot());
		}
	}

}
