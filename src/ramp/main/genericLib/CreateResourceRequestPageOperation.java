package ramp.main.genericLib;

import ramp.main.Objects.ResourceRequestObject;


public class CreateResourceRequestPageOperation  extends Ramp_ItGenericLibrary{

	
	public static void createNewRequestByFillingMandatoryFieldsForConsulting(String orderProbability, String totalEffort){
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		selectValueFromDropdownBasedOnLabel("Business Area", "Consulting");
		selectValueFromDropdownBasedOnLabel("Order probability ", orderProbability);
		if(orderProbability.equals("100")){
			typeTextInAutoCompleteInputBoxAndSelectFirstOption(ResourceRequestObject.WBSNumber, "PS", "WBS Number");
		}
		typeTextInInputField(ResourceRequestObject.customerName, generateRandomStringWithLength(15), "Customer Name");
		typeTextInInputField(ResourceRequestObject.projectName, generateRandomStringWithLength(15), "Project Name");
		typeTextInInputField(ResourceRequestObject.totalEffort,totalEffort , "Total Effort");
		selectValueFromDropdownBasedOnLabel("Project Language", "English-en");
		click(ResourceRequestObject.startDate, "Start Date");
		selectDateInCalendarWidget(getDateAfterTheCurrentDate(1));
		click(ResourceRequestObject.endDate, "End Date");
		selectDateInCalendarWidget(getDateAfterTheCurrentDate(30));
		click(ResourceRequestObject.submitButton, "Submit");
		compareTwoStrings(getWebElementText(ResourceRequestObject.createNewResourceRequestTitle, "Create new request success title"), "Create Request Position");

	}
}
