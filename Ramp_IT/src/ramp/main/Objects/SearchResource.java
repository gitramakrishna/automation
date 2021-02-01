package ramp.main.Objects;

import org.openqa.selenium.By;

public class SearchResource {
	
	public static By removeSkillCrossButton = By.cssSelector("div[class*=clearIcon]");
	public static By searchBox = By.xpath("//input[@id='employeeName']");
	public static By searchAutoCompleteFirstOption = By.xpath("//ul[@id='ui-id-1']/li[1]");
	public static By employSelectCheckBox = By.xpath("//table[@id='empTable']/tbody/tr/td[1]/input[@type='checkbox']");
	public static By employSelectCheckBoxByIndex(int empNum){return By.xpath("//table[@id='empTable']/tbody/tr["+empNum+"]/td[1]/input[@type='checkbox']");}
	public static By searchButton = By.xpath("//button[@type='submit'][text()='Search']");
	public static By nominateButton = By.xpath("//button[@type='submit'][text()='Nominate ']");
	
	public static By tableLengthDropdown = By.xpath("//div[@id='empTable_length']//select");
	public static By tableInformation = By.xpath("//div[@id='empTable_info']");
	public static By paginationPrevious = By.xpath("//a[@id='empTable_previous']");
	public static By paginationNext = By.xpath("//a[@id='empTable_next']");
}
