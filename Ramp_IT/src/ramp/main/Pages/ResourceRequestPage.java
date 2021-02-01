package ramp.main.Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ramp.main.Objects.AlertPopUp;
import ramp.main.Objects.CreateRequestPosition;
import ramp.main.Objects.NominatePageObjects;
import ramp.main.Objects.ResourceRequestObject;
import ramp.main.Objects.SearchResource;
import ramp.main.genericLib.CreateRequestPositionOperation;
import ramp.main.genericLib.CreateResourceRequestPageOperation;
import ramp.main.genericLib.HomePageOperation;
import ramp.main.genericLib.IE_CockPitPageOperation;
import ramp.main.genericLib.PopupAlertOperation;
import ramp.main.genericLib.ResourceRequestNominations;
import ramp.main.genericLib.ResourceRequestPageOperations;
import ramp.main.genericLib.SearchResourceOperation;
import ramp.main.utility.Action2;
import ramp.main.utility.DriverManager;
import ramp.main.utility.ExtentManager;
import ramp.main.utility.PropertyReader;


public class ResourceRequestPage extends HomePage {

	public void verifyCreateNewResourceRequestPageOpening(){
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		wait(2);
		compareTwoStrings(getWebElementText(ResourceRequestObject.createNewResourceRequestTitle, "Add new request page title"), "Create Resource Request");
	}



	public void verifyMandatoryFieldVisibleForConsulting(){
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		selectValueFromDropdownBasedOnLabel("Business Area", "Consulting");
		verifyMandatoryFieldVisible("Order probability ,Ordering Country,Name,Project Name ,Start Date ,End Date,Effort Unit,Total Effort,Project Language ,Requestor");
	}
	public void verifyMandatoryFieldVisible(String commaSeperatedExactFieldNames){

		for(String field : commaSeperatedExactFieldNames.split(",")){
			verifyElementVisibeWithMandatorySign(By.xpath("//label[text()='"+field+"']"),field,By.xpath("//span[@class='text-danger']"));
		}
	}

	public void verifyCreateNewRequestByFillingAlphaNeumericValueForTotalEffort(){
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		selectValueFromDropdownBasedOnLabel("Business Area", "Consulting");
		selectValueFromDropdownBasedOnLabel("Order probability ", "25");
		typeTextInInputField(ResourceRequestObject.customerName, generateRandomStringWithLength(15), "Customer Name");
		typeTextInInputField(ResourceRequestObject.projectName, generateRandomStringWithLength(15), "Project Name");
		typeTextInInputField(ResourceRequestObject.totalEffort,generateRandomAlphaNumericStringWithLength(5) , "Total Effort");
		DriverManager.get().findElement(ResourceRequestObject.endDate).click();
		verifyElementVisibe(ResourceRequestObject.totalEffortError, "Total Effort Error");
		compareTwoStrings(getWebElementText(ResourceRequestObject.totalEffortError, "Total Effort Error"), "Invalid format.");
	}


	public void verifyValuesAfterCreatingNewResourceRequestForConsulting(){
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		Map<String, String> dropDownFields = new HashMap<String,String>();
		dropDownFields.put("Business Area", "Consulting");
		dropDownFields.put("Order probability ", "25");
		dropDownFields.put("Project Language", "English-en");
		Map<String, String> inputTextFields = new HashMap<String, String>();
		inputTextFields.put("Customer Name", "Ramakrishna QA");
		inputTextFields.put("Project Name", "Violet Brain");
		inputTextFields.put("Total Effort", "50");
		Map<String, String> dateFields = new HashMap<String, String>();
		dateFields.put("Start Date", "9-12-2020");
		dateFields.put("End Date", "15-12-2020");

		for(Map.Entry<String, String> atr : dropDownFields.entrySet()){
			selectValueFromDropdownBasedOnLabel(atr.getKey(), atr.getValue());
		}


	}

	public void addNewPositionToARequest(int rowNumber,String skillName,String responsibleManager, int distributionOfEffort){
		String expandIconColor = getWebElementCSS(ResourceRequestObject.expandIcon(rowNumber), "color");
		click(ResourceRequestObject.resourceRequest, "Resouce Request");
		click(ResourceRequestObject.requestPositionInRow(rowNumber),"Add new position to row 1");
		wait(10);
		compareTwoStrings(getWebElementText(CreateRequestPosition.title, "Create request page title"), CreateRequestPosition.titleValue);
		CreateRequestPositionOperation.addNewPosition(skillName, responsibleManager, distributionOfEffort);
		if(expandIconColor.equals("#1976d2")){
			click(AlertPopUp.yesButton, "Yes"); 
		}
	}




	public void nominateBySearchingACandidate(String candidateNameIfNoOneavailable){
		executeJavaScript("document.querySelector('div[class*=clearIcon]').click()", "Remove Skills");
		wait(2);
		typeTextInInputField(SearchResource.searchBox, candidateNameIfNoOneavailable, "Employee search Box");
		wait(3);
		click(SearchResource.searchAutoCompleteFirstOption, "Selecting first option for "+ candidateNameIfNoOneavailable);
		wait(3);
		click(SearchResource.searchButton,"Search Button");
		wait(3);
		for(WebElement we : getListOfSimilarWebElements(SearchResource.employSelectCheckBox)){
			we.click();
		}
		wait(3);
	}
	public void verifyOrderPropabilityAndWbsNumberRelation() {
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		selectValueFromDropdownBasedOnLabel("Business Area", "Consulting");
		ArrayList<String> values = getListOfAvailableValuesForADropDownBasedOnLabel("Order probability ");
		if(values.contains("select")){values.remove("select");}
		for(String value : values ){
			selectValueFromDropdownBasedOnLabel("Order probability ", value);
			if(Integer.parseInt(value)<100){
				verifyElementVisibeWithMandatorySign(By.xpath("//label[text()='WBS Number']/parent::div[@class='form-group']"),"WBS Number",By.xpath("./span[@class='text-danger']"),false);
			}else{
				verifyElementVisibeWithMandatorySign(By.xpath("//label[text()='WBS Number']/parent::div[@class='form-group']"),"WBS Number",By.xpath("./span[@class='text-danger']"),true);
			}
		}
	}

	public void verifyCreateNewRequestByFillingMandatoryFieldsForGMS(String weekStartDay, String weekEndDay,String orderProbability,String serviceHourStartTime, String serviceHourEndTime, String totalEffort, String language, String responsibleManager) {
		ResourceRequestPageOperations.openCreateNewRequestResourcePage();
		selectValueFromDropdownBasedOnLabel("Business Area", "GMS");
		selectValueFromDropdownBasedOnLabel("Service weekday start",weekStartDay);
		selectValueFromDropdownBasedOnLabel("Service weekday end", weekEndDay);
		selectValueFromDropdownBasedOnLabel("Service hours time zone", "(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi");
		selectValueFromDropdownBasedOnLabel("Order probability ", orderProbability);
		selectValueFromDropdownBasedOnLabel("Ordering Country", "India-IN");
		//selectValueFromDropdownBasedOnLabel("Staffing Area", "Consulting Nordics");
		typeTextInAutoCompleteInputBoxAndSelectFirstOption(ResourceRequestObject.WBSNumber, "PS", "WBS Number");

		typeTextInInputField(ResourceRequestObject.customerName, generateRandomStringWithLength(10), "Customer Name");

		typeTextInInputField(ResourceRequestObject.serviceHourStartTime, serviceHourStartTime, "Start Time");
		typeTextInInputField(ResourceRequestObject.serviceHourEndTime, serviceHourEndTime, "end Time");

		typeTextInInputField(ResourceRequestObject.projectName, generateRandomStringWithLength(10), "Project Name");

		click(ResourceRequestObject.startDate, "Start Date");
		selectDateInCalendarWidget(getDateAfterTheCurrentDate(1));
		click(ResourceRequestObject.endDate, "End Date");
		selectDateInCalendarWidget(getDateAfterTheCurrentDate(30));

		selectValueFromDropdownBasedOnLabel("Effort Unit", "Days");
		typeTextInInputField(ResourceRequestObject.totalEffort, totalEffort, "Total Effort");
		selectValueFromDropdownBasedOnLabel("Project Language", language);
		typeTextInAutoCompleteInputBoxAndSelectFirstOption(ResourceRequestObject.responsibleManager, responsibleManager, "Responsible Manager");
		wait(2);
		click(ResourceRequestObject.submitButton, "Submit");
	}

	public void verifyCreateNewRequestByFillingMandatoryFieldsForGMS(String weekStartDay, String weekEndDay,String orderProbability,
			String serviceHourStartTime, String serviceHourEndTime, String totalEffort, String language, String responsibleManager,String status) {
		verifyCreateNewRequestByFillingMandatoryFieldsForGMS(weekStartDay, weekEndDay, orderProbability, 
				serviceHourStartTime, serviceHourEndTime, totalEffort, language, responsibleManager);
		selectValueFromDropdownBasedOnLabel("Status", status);
	}

	public void verifyCreateNewRequestAssignPositionAndNominate() {
		CreateResourceRequestPageOperation.createNewRequestByFillingMandatoryFieldsForConsulting("100","20");
		CreateRequestPositionOperation.addNewPosition("Technology", "Mahesh", 5);
		wait(3);
		click(AlertPopUp.yesButton, "Yes"); 
		wait(3);
		ResourceRequestPageOperations.goToNominationPage(1, "Nominate");
		ResourceRequestNominations.assignEffortToCandidate(1, "10");
		//assignEffortToCandidate(2);
	}

	public Double getRemainingEffort(){
		String remainingEffortText = getWebElementText(NominatePageObjects.remainingEffort, "Remaining Effort").split(":")[1];
		return Double.parseDouble(remainingEffortText.split("-")[0].trim());
	}

	public void verifyResourceNominatingByOtherResonsibleManager(String responsibleManager) {
		CreateResourceRequestPageOperation.createNewRequestByFillingMandatoryFieldsForConsulting("100", "50");
		CreateRequestPositionOperation.addNewPosition("Technology", responsibleManager, 5);
		wait(3);
		PopupAlertOperation.clickOnYesButton(); 
		wait(3);
		logout();
		PropertyReader.setGlobalProperty("rampLoginID", "10009603");
		HomePageOperation.loginPage(PropertyReader.getGlobalProperty("rampLoginID"), PropertyReader.getGlobalProperty("rampPassword"), 
				responsibleManager);
		//String processId = 
		ResourceRequestPageOperations.goToNominationPage(1,"Nominate");
		ResourceRequestNominations.clickOnNominateButton();
		wait(2);
		SearchResourceOperation.nominateBySelectingAvailableCandidates(true,1);
		ResourceRequestNominations.assignEffortToCandidate(1, "20");
		ResourceRequestNominations.changeStatusOfCandidate(1,"Request For Approval");
		if(PopupAlertOperation.handlePopup().equals("success")){
			wait(2);
			logout();
			PropertyReader.setGlobalProperty("rampLoginID", "10002189");
			HomePageOperation.loginPage(PropertyReader.getGlobalProperty("rampLoginID"), PropertyReader.getGlobalProperty("rampPassword"), 
					responsibleManager);
			ResourceRequestPageOperations.goToNominationPage(1,"Go to Approval");
			if(!getSelectedValueFromDropDown(NominatePageObjects.candidatestatus(1), "Status").equalsIgnoreCase("Approved"))
			{	ResourceRequestNominations.changeStatusOfCandidate(1,"Approve");
			PopupAlertOperation.handlePopup().equals("success");
			}
			wait(2);
			logout();
			PropertyReader.setGlobalProperty("rampLoginID", "10009603");
			HomePageOperation.loginPage(PropertyReader.getGlobalProperty("rampLoginID"), PropertyReader.getGlobalProperty("rampPassword"), 
					responsibleManager);
			ResourceRequestPageOperations.goToNominationPage(1,"Nominate");
			ResourceRequestNominations.changeStatusOfCandidate(1,"Finally Assign");
			Object[][] operationReport = ResourceRequestNominations.chooseFillOnlyAvailibilityTime();

			if(((String)operationReport[0][0]).equals("success")){



			}else{
				ResourceRequestNominations.closeOperationPopUp();
				String message = (String)operationReport[0][1];
				Double availableDays =Double.parseDouble(message.substring(message.indexOf("(")+1, message.indexOf(")")));
				typeTextInInputField(NominatePageObjects.nominatedResourceEffortInputBox(1), availableDays+"", "Effort for candidate "+1 );
				ResourceRequestNominations.changeStatusOfCandidate(1,"Finally Assign");
				click(NominatePageObjects.popUpFillOnlyAvailabilitime, "Fill only availability time");
				wait(1);
				click(NominatePageObjects.popUpSaveButton, "Save");
				PopupAlertOperation.handlePopup();
				wait(2);
			}
			wait(2);


		}

	}





	public void nominateACandidateFromDashboard(int i, String string, boolean b, int j) {
		// TODO Auto-generated method stub

	}

	public void verifyResourceNominatingByOtherResonsibleManagerForIECandidate(String responsibleManager, String RMUserID) {
		CreateResourceRequestPageOperation.createNewRequestByFillingMandatoryFieldsForConsulting("100", "50");
		CreateRequestPositionOperation.addNewPosition("Java", responsibleManager, 5);
		wait(2);
		PopupAlertOperation.clickOnYesButton(); 
		wait(2);
		logout();
		PropertyReader.setGlobalProperty("rampLoginID", RMUserID);
		HomePageOperation.loginPage(PropertyReader.getGlobalProperty("rampLoginID"), PropertyReader.getGlobalProperty("rampPassword"), 
				responsibleManager);
		ResourceRequestPageOperations.goToNominationPage(1,"Nominate");
		wait(2);
		ResourceRequestNominations.clickOnNominateButton();
		Object[][] selectOperationResult = SearchResourceOperation.selectNonIECandiates(false,1);
		ArrayList<String> selectedCandidates = new ArrayList<String>();
		selectedCandidates = (ArrayList<String>)(selectOperationResult[0][3]);
		SearchResourceOperation.clickOnNominateButton();
		wait(3);
		for(String candidate : selectedCandidates){
			ResourceRequestNominations.clickOnIENominatedEmployeeEditIconByEmployeeID(candidate);
			IE_CockPitPageOperation.changeStatus(candidate, "Approve");
			IE_CockPitPageOperation.clickOnUpdateButton();
			if(IE_CockPitPageOperation.verifyIfTheUpdationPassed()){
				ExtentManager.createStepNodeForTestCase("Verifying if the updation passed.", "Updating the resource failed.", "fail", Action2.takeScreenShot());

			}
			ResourceRequestPageOperations.goToNominationPage(1, "Nominate");
		}
		typeTextInInputField(NominatePageObjects.nominatedResourceEffortInputBox(1), "5", "Effort for candidate "+1 );
		ResourceRequestNominations.changeStatusOfCandidate(1,"Interco Agree");
		PopupAlertOperation.clickOnOk();
		ResourceRequestPageOperations.forwardThePosition(1, 1, "Charlotte Scheel");
		PopupAlertOperation.clickOnOk();
		logout();
		PropertyReader.setGlobalProperty("rampLoginID", "10001045");
		HomePageOperation.loginPage(PropertyReader.getGlobalProperty("rampLoginID"), PropertyReader.getGlobalProperty("rampPassword"), 
				responsibleManager);	
		ResourceRequestPageOperations.goToNominationPage(1,"Nominate");
		ResourceRequestNominations.changeStatusOfCandidate(1,"Assign");
		Object[][] operationReport = ResourceRequestNominations.chooseFillOnlyAvailibilityTime();
		System.out.println(operationReport);
		if(operationReport!=null){
		if(((String)operationReport[0][0]).equals("success")){



		}else{
			ResourceRequestNominations.closeOperationPopUp();
			String message = (String)operationReport[0][1];
			Double availableDays =Double.parseDouble(message.substring(message.indexOf("(")+1, message.indexOf(")")));
			typeTextInInputField(NominatePageObjects.nominatedResourceEffortInputBox(1), availableDays+"", "Effort for candidate "+1 );
			ResourceRequestNominations.changeStatusOfCandidate(1,"Finally Assign");
			click(NominatePageObjects.popUpFillOnlyAvailabilitime, "Fill only availability time");
			wait(1);
			click(NominatePageObjects.popUpSaveButton, "Save");
			PopupAlertOperation.handlePopup();
			wait(2);
		} 
		}
		ResourceRequestNominations.clickOnIENominatedEmployeeEditIconByEmployeeID(selectedCandidates.get(0));
		IE_CockPitPageOperation.selectWPSNUmber(selectedCandidates.get(0), "00");
		IE_CockPitPageOperation.clickOnUpdateButton();
		ResourceRequestPageOperations.goToNominationPage(1,"Nominate");
		ResourceRequestNominations.changeStatusOfCandidate(1,"Finally Assign");
		Object[][] operationReport2 = ResourceRequestNominations.chooseFillOnlyAvailibilityTime();
		System.out.println(operationReport2);
		

	}

		public void verifyCreateNewRequestByFillingMandatoryFieldsForConsulting(String orderProbability, String totalEffort) {
			CreateResourceRequestPageOperation.createNewRequestByFillingMandatoryFieldsForConsulting(orderProbability, totalEffort);
		}



		public void copyARequestFromExisting(int rowNumber) {
			// TODO Auto-generated method stub
			ResourceRequestPageOperations.copyOperation(rowNumber);
		}





	}
