package testNG;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseClass;
import base.screenshot;
import pageObject.home;
import pageObject.travelInsurance;
import pageObject.travelInsurance_result;

public class traveltestNG {
	home h;
	travelInsurance t;
	screenshot s;
	travelInsurance_result tr;
	
	
	@Test(priority=1)
	public void user_is_present_on_policybazaar_com() throws IOException {
		baseClass.getlogger().info("*****Navigating to policyBazaar Website**********");
		h=new home(hooks.getDriver());
		t=new travelInsurance(hooks.getDriver());
		s=new screenshot(hooks.getDriver());
		tr=new travelInsurance_result(hooks.getDriver());
		s.ScreenShots("homePage");
	}

	@Test(priority=2)
	public void user_clicks_on_travel_insurance_option_from_all_the_options_available_on_the_main_page() throws IOException {
		baseClass.getlogger().info("*****Scrolling down until all options are available**********");
		h.scrollDown();
		baseClass.getlogger().info("*****Selecting travel insurance out of the options available**********");
		h.selectTravelInsOption();
	}

	@Test(priority=3)
	public void user_enters_the_country() throws IOException {
		
		baseClass.getlogger().info("*****selecting the country to travel to**********");
		t.chooseCountry();
		s.ScreenShots("country");
		baseClass.getlogger().info("*****Clicking on next button**********");
		t.clickNext();
	}

	@Test(priority=4)
	public void user_selects_the_start_date_and_end_date_of_the_trip() throws IOException {
		baseClass.getlogger().info("*****selecting the start end and end date for the trip**********");
		t.selectDate();
		s.ScreenShots("date");
		t.clickNext();
	}

	@Test(priority=5)
	public void user_enters_the_number_of_students_traveling_along_with_their_age() throws IOException {
		baseClass.getlogger().info("*****selecting the number of people traveling**********");
		t.selectNoOfStudents();
		baseClass.getlogger().info("*****selecting age of the person **********");
		t.selectAge1();
		baseClass.getlogger().info("*****selecting age of second person**********");
		t.selectAge2();
		s.ScreenShots("age");
		t.clickNext();
	}

	@Test(priority=6)
	public void user_enters_pre_existing_medical_condition_if_any() throws IOException, InterruptedException {
		baseClass.getlogger().info("*****entering the details of any pre-existing medical condition if any**********");
	   t.selectMedicalCondition();
	   s.ScreenShots("medicalcondn");
	}

	@Test(priority=7)
	public void user_enters_mobile_number_and_clicks_on_submit_button() throws IOException {
		baseClass.getlogger().info("*****entering the mobile number **********");
		s.ScreenShots("phnNo");
		t.enterMobileNumber();
		t.viewplan.click();
	}

	@Test(priority=8)
	public void user_is_navigated_to_results_page() throws IOException {
		baseClass.getlogger().info("*****displaying the title of the page opened**********");
		s.ScreenShots("resultsIns");
		System.out.println(tr.resultPageTitle);
	}

}
	   




