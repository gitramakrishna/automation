package ramp.main.Objects;

import org.openqa.selenium.By;

public class IE_CockpitObjects {

	public static String cockpitFormBasedOnID(String employeeID){return "//input[@value='"+employeeID+"']//ancestor::div[@class='mt-3']";}
	public static By candidateStatus(String employeeID){return By.xpath(cockpitFormBasedOnID(employeeID)+"//h5[text()='Candidate Status']/parent::label/following-sibling::select");}
	public static By updateButton = By.xpath("//button[@value='update']");
	public static By saveAndCreate = By.xpath("//button[@value='create']");
	public static By operationFailedMessage = By.xpath("//div[contains(@class,'alert-danger')]");
	public static By wbsInputBox(String employeeID){return By.xpath(cockpitFormBasedOnID(employeeID)+"//input[contains(@id,'sellingWbsId')]");}
}
