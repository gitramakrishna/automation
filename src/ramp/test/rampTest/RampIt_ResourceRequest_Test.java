package ramp.test.rampTest;

import org.testng.annotations.Test;

import ramp.main.Pages.ResourceRequestPage;
import ramp.main.utility.BaseClass;

public class RampIt_ResourceRequest_Test extends BaseClass{

	
	@Test
	public void RampIt_ResourceRequest_VerifyCreateRequestPageOpening(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyCreateNewResourceRequestPageOpening();
	}
	
	@Test
	public void RampIt_ResourceRequest_VerifyMandatoryFieldsForConsultingBussinessType(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyMandatoryFieldVisibleForConsulting();
	}
	@Test
	public void RampIt_ResourceRequest_VerifyCreateNewRequestByFillingMandatoryFieldsForConsulting(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyCreateNewRequestByFillingMandatoryFieldsForConsulting("25","500");
	}
	@Test
	public void RampIt_ResourceRequest_VerifyValuesAfterCreatingNewResourceRequestForConsulting(){
		// requestPage = new ResourceRequestPage();
		
	}
	@Test
	public void RampIt_ResourceRequest_VerifyCreateNewRequestByFillingTotalEffortWithAlphaNumericFieldsForConsulting(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyCreateNewRequestByFillingAlphaNeumericValueForTotalEffort();
	}
	
	@Test
	public void RampIt_ResourceRequest_AddNewResourcePositionToRequest(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.addNewPositionToARequest(2,"Technology", "Mahesh", 5);
	}
	@Test
	public void RampIt_ResourceRequest_NominateResourcePositionToRequest(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.nominateACandidateFromDashboard(1,"Soumya",true,1);
	}
	@Test
	public void RampIt_ResourceRequest_VerifyOrderPropabilityAndWbsNumberRelation(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyOrderPropabilityAndWbsNumberRelation();
	}
	
	@Test
	public void RampIt_ResourceRequest_VerifyCreateNewRequestByFillingMandatoryFieldsForGMS(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyCreateNewRequestByFillingMandatoryFieldsForGMS("Monday", "Friday","50",
				 "08:00", "19:00", "1000","English-en", "Mahesh");
	}
	@Test
	public void RampIt_ResourceRequest_VerifyCreateNewRequestAssignPositionAndNominate(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyCreateNewRequestAssignPositionAndNominate();
	}
	
	@Test
	public void RampIt_ResourceRequest_VerifyResourceNominatingByOtherResonsibleManager(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyResourceNominatingByOtherResonsibleManager("Soumya");
	}
	@Test
	public void RampIt_ResourceRequest_VerifyResourceNominatingByOtherResonsibleManagerForIECandidate(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.verifyResourceNominatingByOtherResonsibleManagerForIECandidate("Soumya","10009603");
	}
	
	@Test
	public void RampIt_ResourceRequest_CopyARequestFromExisting(){
		ResourceRequestPage requestPage = new ResourceRequestPage();
		requestPage.copyARequestFromExisting(1);
	}
	
	
	
}
