package ramp.main.Objects;

import org.openqa.selenium.By;

public class CreateRequestPosition {

	public static By title = By.xpath("//div[@class='container-fluid']//h4");
	public static String titleValue = "Create Request Position";
	public static By skill = By.xpath("//input[@id='skill']");
	public static By popUpSkillSearch = By.xpath("//input[@placeholder='Search Skill']");
	public static By popUpSkillByText(String skillName){return By.xpath("//a[text()='"+skillName+"']");}
	public static By addSkillButton = By.xpath("//button[@id='add']");
	public static By distrubutionOfEffort = By.xpath("//input[@id='totalEffort']");
	
	
	public static By responsibleManager = By.xpath("//input[@id='responsibleRM']");
	public static By responsibleManagerFirstChoice = By.xpath("//ul[@id='ui-id-2']/li[1]");
	public static By submitButton = By.xpath("//button[@id='normalSubmit']");
	
	public static By formDescription = By.xpath("//textarea[@id='short_description']");
	public static By nextStep = By.xpath("//textarea[@id='next_step']");
	public static By location = By.xpath("//input[@id='projectLocation']");
	public static By wBSNumber = By.xpath("//input[@id='position_wbs_id']");
	public static By totalPositionEffort = By.xpath("//input[@id='totalPositionEffort']");
	public static By maximumPurchasingInvoicing = By.xpath("//input[@id='totalPositionEffort']");
	public static By invoicingSellingRate = By.xpath("//input[@id='Invoicingsellingrate']");
	public static By longDescription = By.xpath("//textarea[@id='exampleFormControlTextarea1']");
	public static By cancelButton = By.xpath("//a[text()='Cancel']");
	public static By submitAndCreateNewPosition = By.xpath("//button[@id='submitAndCreate']");
	
	
}
