package ramp.main.genericLib;

import java.util.ArrayList;

import ramp.main.Objects.AlertPopUp;
import ramp.main.Objects.ResourceRequestObject;

public class ResourceRequestPageOperations extends Ramp_ItGenericLibrary {
	
	public static void openCreateNewRequestResourcePage(){
		click(ResourceRequestObject.resourceRequest, "Resouce Request");
		click(ResourceRequestObject.addNewResourceRequest, "Add Resource Request");
	}
	
	public static String  goToNominationPage(int rowNumber,String operationName){
		click(ResourceRequestObject.resourceRequest, "Resouce Request");
		click(ResourceRequestObject.expandIcon(rowNumber), "Opening position for row "+ rowNumber);
		String requestId = extractIntFromString(getWebElementText(ResourceRequestObject.requestId(rowNumber), "Request ID for row"+rowNumber));
		wait(2);
		hoverOverAWebElement(ResourceRequestObject.positionRowNumberID(requestId, 1), "Position row "+rowNumber);
		wait(2);
		String processId = extractIntFromString(getWebElementText(ResourceRequestObject.positionRowNumberID(requestId, 1), "Process ID"));
		click(ResourceRequestObject.positionPageOperation(processId,operationName), operationName);
		return processId;
	}
	
	public static ArrayList<String> getColumnListForPosition( int rowNumber){
		click(ResourceRequestObject.expandIcon(rowNumber), "Opening position for row "+ rowNumber);
		String requestId = extractIntFromString(getWebElementText(ResourceRequestObject.requestId(rowNumber), "Request ID for row"+rowNumber));
		return getStringListFromWebElements(ResourceRequestObject.positionHeadersColumnName(requestId));
	}
	
	public static void clickONExpandIcon(int rowNumber){
		click(ResourceRequestObject.expandIcon(rowNumber), "Opening position for row "+ rowNumber);
	}
	
	public static void clickOnForwardInPosition(String requestID, int positionRowNumber){
		click(ResourceRequestObject.positionForwardTo(requestID, positionRowNumber), "Forward to");
	}
	
	public static void forwardThePosition(int rowNumber,int positionRowNumber,String managerName){
		click(ResourceRequestObject.resourceRequest, "Resouce Request");
		clickONExpandIcon(rowNumber);
		String requestId = extractIntFromString(getWebElementText(ResourceRequestObject.requestId(rowNumber), "Request ID for row"+rowNumber));
		wait(3);
		clickOnForwardInPosition(requestId, positionRowNumber);
		Ramp_ItGenericLibrary.typeTextInAutoCompleteInputBoxAndSelectMultipleOption(ResourceRequestObject.forwardToInputBox, managerName, "Forward to");
		click(ResourceRequestObject.forwardToSendButton, "Send");
	}
	
	public static void clickOnCopyIcon(int rowNumber){
		click(ResourceRequestObject.requestCopyFromRow(rowNumber),"Copy Icon in row "+ rowNumber);
	}
	public static void copyOperation(int rowNumber){
		click(ResourceRequestObject.resourceRequest, "Resouce Request");
		String rowOneRequestID = getWebElementText(ResourceRequestObject.requestId(rowNumber), "Request ID for row"+rowNumber);
		String rowOneProjectName = getWebElementText(ResourceRequestObject.requestProjectNameInRow(rowNumber), "Project Name");
		clickOnCopyIcon(rowNumber);
		click(AlertPopUp.yesCopyIt, "Yes Copy It");
		wait(1);
		click(AlertPopUp.OkButton, "OK");
		wait(10);
		rowNumber = 1;
		String projectNameAfterCopying = getWebElementText(ResourceRequestObject.requestProjectNameInRow(rowNumber), "Project Name");
		
		verifyStringContainsAnotherString(projectNameAfterCopying, rowOneProjectName);
		verifyStringContainsAnotherString(projectNameAfterCopying, "Copied from - "+rowOneRequestID);
		scrollToTheWebElemntByLocation(ResourceRequestObject.requestStatusInRow(rowNumber));
		String copiedRequestStatus = getWebElementText(ResourceRequestObject.requestStatusInRow(rowNumber), "status");
		verifyStringContainsAnotherString(copiedRequestStatus, "Draft");
	}
	
	}