package ramp.main.genericLib;

import org.openqa.selenium.Keys;

import ramp.main.Objects.CreateRequestPosition;
import ramp.main.utility.DriverManager;

public class CreateRequestPositionOperation extends Ramp_ItGenericLibrary{

	
	public static void addNewPosition(String skillName,String responsibleManager, int distributionOfEffort){
		click(CreateRequestPosition.skill, "Skill ");
		wait(2);
		typeTextInInputField(CreateRequestPosition.popUpSkillSearch, skillName, "Skill search box");
		DriverManager.get().findElement(CreateRequestPosition.popUpSkillSearch).sendKeys(Keys.ENTER);
		wait(2);
		click(CreateRequestPosition.popUpSkillByText(skillName), skillName);
		click(CreateRequestPosition.addSkillButton, "Add skill");
		typeTextInInputField(CreateRequestPosition.distrubutionOfEffort, distributionOfEffort, "Distribution Of Effort");
		//selectValueFromDropdownBasedOnLabel("Unit of Effort", "Days per week");
		selectFirstValueFromDropdownBasedOnLabel("Unit of Effort");
		typeTextInInputField(CreateRequestPosition.responsibleManager, responsibleManager, "Responsible Manager");
		wait(3);
		click(CreateRequestPosition.responsibleManagerFirstChoice, getWebElementText(CreateRequestPosition.responsibleManager, "Responsible Manager"));
		click(CreateRequestPosition.submitButton, "Submit Button");

	}
}
