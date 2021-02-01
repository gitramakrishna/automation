package ramp.main.genericLib;

import java.util.ArrayList;

import ramp.main.Objects.SearchResource;
import ramp.main.utility.Action2;

public class SearchResourceOperation extends Action2 {
	
	
	public static void nominateBySelectingAvailableCandidates(boolean nonIECandidate,int numberOfcandidatesToBeSelected){
		selectNonIECandiates(nonIECandidate,numberOfcandidatesToBeSelected);	
		click(SearchResource.nominateButton, "Nominate");
		wait(2);
	}
	public static void clickOnNominateButton(){
		click(SearchResource.nominateButton, "Nominate");
	}
	public static  Object[][] selectNonIECandiates(boolean nonIECandidate,int numberOfcandidatesToBeSelected){
		int numberOfavailableCandidates = Integer.parseInt(getWebElementText(SearchResource.tableInformation, "Table Information").
				split("of")[1].trim().split(" ")[0].trim());
		ArrayList<String> selectedEmployeeIDs = new ArrayList<String>();
		String candidateIdentity = "L";
		if(nonIECandidate){
			candidateIdentity = "L";
		}else{candidateIdentity = "I";}
		int pagelength = Integer.parseInt(getSelectedValueFromDropDown(SearchResource.tableLengthDropdown, "Table length"));
		int selected = 0;
		if(numberOfavailableCandidates > 0 ){
					boolean next = true;
					while(next && (numberOfcandidatesToBeSelected != selected)){
						next = !getElementAttribute(SearchResource.paginationNext, "class").contains("disabled");
						pagelength = Integer.parseInt(getSelectedValueFromDropDown(SearchResource.tableLengthDropdown, "Table length"));
						for(int i =1; i<= pagelength; i++){
							String value = getElementAttribute(SearchResource.employSelectCheckBoxByIndex(i), "value");
							if(value.split("-")[1].equalsIgnoreCase(candidateIdentity)){
								click(SearchResource.employSelectCheckBoxByIndex(i), "Candidate "+ i);
								++selected;
								selectedEmployeeIDs.add(value.split("-")[0]);
								if(numberOfcandidatesToBeSelected == selected){
									break;
								}
								
							}
						}
						if(next){
							click(SearchResource.paginationNext, "Next Page");
							}
					}
			
			if(numberOfcandidatesToBeSelected == selected){
				return  new Object[][]{{true,"Required :"+ numberOfcandidatesToBeSelected + "</br> Selected : "+ selected,selected,selectedEmployeeIDs }};
			}else{
				return  new Object[][]{{false,"Required :"+ numberOfcandidatesToBeSelected + "</br> Selected : "+ selected,selected ,selectedEmployeeIDs}};
			}}else{
				return  new Object[][]{{true,"Required :"+ numberOfcandidatesToBeSelected + "</br> Available candidates : "+ numberOfavailableCandidates,selected,selectedEmployeeIDs }};
			}

	}

}
