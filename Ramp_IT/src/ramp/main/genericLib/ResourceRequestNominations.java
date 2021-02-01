package ramp.main.genericLib;

import ramp.main.Objects.NominatePageObjects;
import ramp.main.utility.Action2;

public class ResourceRequestNominations extends Action2 {

	public static void clickOnIENominatedEmployeeEditIconByEmployeeID(String employeeID){
		click(NominatePageObjects.employeeEditIcon(employeeID), "Edit Icon");
	}
	
	public static void clickOnNominateButton(){
		click(NominatePageObjects.nominateButton, "Nominate");
	}
	public static void assignEffortToCandidate(int candidateRowNum, String effortforAssigning){
		typeTextInInputField(NominatePageObjects.nominatedResourceEffortInputBox(candidateRowNum), effortforAssigning , "Effort for candidate "+candidateRowNum );
	}
	
	public static void changeStatusOfCandidate(int candidateRowNum, String statusToChange) {
		selectValueFromDropDown(NominatePageObjects.candidatestatus(candidateRowNum), "Status",statusToChange );
		click(NominatePageObjects.candidateSuccessButton(candidateRowNum), "Success");
		wait(2);
	}
	public static void closeOperationPopUp(){
		click(NominatePageObjects.popUpCloseButton, "Close ");
	}
	
	public static Object[][] chooseFillOnlyAvailibilityTime(){
		click(NominatePageObjects.popUpFillOnlyAvailabilitime, "Fill only availability time");
		wait(1);
		click(NominatePageObjects.popUpSaveButton, "Save");
		wait(1);
		Object[][] operationReport = PopupAlertOperation.getTaskStatus();
		return operationReport;
	}
}
