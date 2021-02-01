package ramp.main.genericLib;


import org.openqa.selenium.By;

import ramp.main.Objects.IE_CockpitObjects;
import ramp.main.utility.Action2;

public class IE_CockPitPageOperation extends  Action2 {

	
	
	public static void changeStatus(String employeeID, String statusToChanges){
		selectValueFromDropDown(IE_CockpitObjects.candidateStatus(employeeID), "Candidate Status", statusToChanges);
	}
	
	public static void  clickOnUpdateButton(){
		click(IE_CockpitObjects.updateButton, "Update");
	}
	
	public static boolean verifyIfTheUpdationPassed(){
		return verifyIfElementPresent(IE_CockpitObjects.operationFailedMessage, 3);	
	}
	
	
	public static void selectWPSNUmber( String employeeID,String hintForWPS){
		Ramp_ItGenericLibrary.typeTextInAutoCompleteInputBoxAndSelectFirstOption(IE_CockpitObjects.wbsInputBox(employeeID), hintForWPS, "Selling WBS");
	} 
	
}
