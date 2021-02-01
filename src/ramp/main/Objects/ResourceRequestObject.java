package ramp.main.Objects;

import org.openqa.selenium.By;

public class ResourceRequestObject {

	
	public static By pageBody = By.xpath("//body");
	public static By resourceRequest = By.xpath("//span[text()='Resource Request']");
	public static By addNewResourceRequest = By.xpath("//*[text()='Add Resource Request']");
	public static By createNewResourceRequestTitle = By.xpath("//div[@class='container-fluid']//h4[@class='card-title']");
	
	public static By BussinessAreaDropDown = By.xpath("//select[@id='businessArea']");
	public static By customerName = By.xpath("//input[@id='customerName']");
	public static By projectName = By.xpath("//input[@id='projectTopic']");
	public static By totalEffort = By.xpath("//input[@id='totalEffort']");
	public static By totalEffortError = By.xpath("//label[@id='totalEffort-error']");
	public static By WBSNumber = By.xpath("//input [@id='wbs_id']");
	public static By projectLocation = By.xpath("//input [@id='projectLocation']");
	public static By externalStaffing = By.xpath("//input [@name='external_allowed']");
	public static By zipCode = By.xpath("//input [@id='zipCode']");
	public static By customerLocation = By.xpath("//input [@id='customerLocation']");
	public static By startDate = By.xpath("//input[@name='start_date']");
	public static By endDate = By.xpath("//input[@name='end_date']");
	public static By submitButton = By.xpath("//button[@type='submit']");
	public static By cancelButton = By.xpath("//button[@type='button']");
	
	public static By serviceHourStartTime = By.xpath("//input[@id='service_hours_time_start']");
	public static By serviceHourEndTime = By.xpath("//input[@id='service_hours_time_end']");
	
	//Roles and Contacts
	public static By responsibleManager = By.xpath("//input[@id='rmForDeliveryCountry']");
	public static By responsibleSalesPersopn = By.xpath("//input[@id='responsibleSalesHidden']");
	public static By responsiblePresales = By.xpath("//input[@id='responsiblePreSalesHidden']");
	public static By projectManager = By.xpath("//input[@id='projectManagerHidden']");
	//project Description
	
	public static By projectDescription = By.xpath("//textarea[@name='description']");
	
	// Report resource Dashboard
	public static By fileUpload = By.xpath("//input[@name='uploadedFile']");
	
	public static By tableHeadersColumns = By.xpath("//table[@id='myTable']/thead//th");
	public static String extendedRowLocation = "//table[@id='myTable']/tbody//tr[@class='expand-child collapse show']";
	public static String actionOptionByRow(int rowNumber){return "(//table[@id='myTable']/tbody//th[@class='actions_i'])["+rowNumber+"]";}
	public static By requestPositionInRow(int rowNumber) {return By.xpath(actionOptionByRow(rowNumber)+"/form[@id='requestPositionAdd']");}
	public static By expandIcon(int rowNumber){ return By.xpath(actionOptionByRow(rowNumber)+"//i[contains(@class,'circle-outline')]");}
	public static By requestCopyFromRow(int rowNumber){return By.xpath(actionOptionByRow(rowNumber)+"//a[@title='Copy']");}
	public static By requestProjectNameInRow(int rowNumber){return By.xpath("//table[@id='myTable']/tbody/tr["+rowNumber+"]/td[3]");}
	public static By requestStatusInRow(int rowNumber){return By.xpath("//table[@id='myTable']/tbody/tr["+rowNumber+"]/td/span[contains(@class,'badge')]");}
	public static String rowNumberxpath(int rowNumber){return "(//table[@id='myTable']/tbody/tr[contains(@class,'hasChildRow')])["+rowNumber+"]";}
	public static By requestId(int rowNumber){return By.xpath(rowNumberxpath(rowNumber)+ "/td/a[@class='projectRequestPanel btn-link']");}
	public static String positionTablePath(String idOfPositionTable){ return "//tr[@id='"+idOfPositionTable+"']//table//tbody";}
	public static By positionRowNumberID(String idOfPositionTable, int rowNumber){return By.xpath(positionTablePath(idOfPositionTable)+"//tr["+rowNumber+"]//a[@class='skill-p btn-link']");}
	public static By goToApprovalButton(String processID){return By.xpath("//*[text()='Go to Approval'][contains(@href,'"+processID+"')]");}
	public static By goToNominateButton(String processID){return By.xpath("//*[text()='Nominate'][contains(@href,'"+processID+"')]");}
	public static By positionPageOperation(String processID,String operationName){return By.xpath("//*[text()='"+operationName+"'][contains(@href,'"+processID+"')]");}
	public static By positionHeadersColumnName(String requestID){return By.xpath(extendedRowLocation+"[@id='"+requestID+"']//table//thead//th");};
	public static By positionForwardTo(String requestID, int positionRowNumber){return By.xpath(extendedRowLocation+"[@id='"+requestID+"']//table//tbody/tr["+positionRowNumber+"]/td/a[@data-target='#forwardModal']");}
	
	
	public static By forwardToInputBox = By.xpath("//div[@id='forwardModal']//div[@class='modal-body']//input[@type='search']");
	public static By forwardToSendButton = By.xpath("//div[@id='forwardModal']//div[@class='modal-footer']//button");
	
	
}
