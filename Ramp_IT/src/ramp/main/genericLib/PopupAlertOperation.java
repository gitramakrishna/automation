package ramp.main.genericLib;

import ramp.main.Objects.AlertPopUp;
import ramp.main.utility.Action2;

public class PopupAlertOperation extends Action2 {

	
	public static String handlePopup() {
		Object[][] operationResult = getTaskStatus();
		String status = (String)operationResult[0][0];
		if(status.equalsIgnoreCase("success")){
			return "success";
		}else{
			return "fail";
		}
		
	}

	public static Object[][] getTaskStatus(){
		if(verifyIfElementPresent(AlertPopUp.alertPopUpWindow, 2)){
		String taskStatus = getElementAttribute(AlertPopUp.taskStatus, "class");
		String message = getWebElementText(AlertPopUp.highLightAlertMessage, "Alert Message");
		String status = "";
		if(taskStatus.contains("sa-error")){
			status = "error" ;
			click(AlertPopUp.OkButton, "OK");
		}else if(taskStatus.contains("sa-warning")){
			status ="success";
			click(AlertPopUp.yesButton, "Yes");
		}else if(taskStatus.contains("sa-info")){
			status = "info"; 
			click(AlertPopUp.OkButton, "OK");
		}else if(taskStatus.contains("sa-success")){
			status = "success";
			click(AlertPopUp.OkButton, "OK");
		}
		return new Object[][]{{status,message}};
		}else{
			return  null;
		}
	}

	public static void clickOnYesButton(){
		click(AlertPopUp.yesButton, "Yes");
	}

	public static void clickOnOk() {
		wait(1);
		if(verifyElementVisibe(AlertPopUp.OkButton, "OK")){
		click(AlertPopUp.OkButton, "OK");}
	}
	
}
