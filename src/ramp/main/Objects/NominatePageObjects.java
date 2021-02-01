package ramp.main.Objects;

import org.openqa.selenium.By;

public class NominatePageObjects {
	
	public static By remainingEffort = By.xpath("//div[contains(@class,'table-responsive')]/div[@class='row']/div[2]");
	public static By nominatedResourceEffortInputBox(int candidaterowNum){
		return By.xpath("//tbody[@id='nomineeTableBody']/tr["+candidaterowNum+"]//*[contains(@id,'effort')]");
	}
	public static By candidatestatus(int candidateRowNumber){
		return By.xpath("//tbody[@id='nomineeTableBody']/tr["+candidateRowNumber+"]//select[contains(@id,'status')]");
	} 
	public static By candidateSuccessButton(int candidateRowNumber){
		return By.xpath("//tbody[@id='nomineeTableBody']/tr["+candidateRowNumber+"]/td[contains(@id,'split')]/a[contains(@class,'btn-success')]");
	}
	public static By nominateButton = By.xpath("//div/a[text()='Nominate']");
	public static By popUpFillOnlyAvailabilitime  = By.xpath("//div[@id='splitRuleModal']//div[@class='modal-body']//div[3]/input");
	public static By popUpSaveButton = By.xpath("//div[@id='splitRuleModal']//div[@class='modal-footer']/button");
	public static By popUpCloseButton = By.xpath("//div[@id='splitRuleModal']//button[@aria-label='Close']");

	//////////////////////----Cockpit Table-----//////////////////////////////
	
	public static String cockPitTableID = "//table[@id='cockpit-table']";
	public static String employeeRow(String employeeID){return "//*[@href='downloadEmployeeCV?employeeId="+employeeID+"']//ancestor::tr";}
	public static By employeeEditIcon(String employeeID){return By.xpath(cockPitTableID+employeeRow(employeeID)+"//td/a[@data-original-title='Edit']");}
	
	
	
}
