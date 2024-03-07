package testNG;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.baseClass;
import base.dataDriven;
import pageObject.travelInsurance_result;

public class travel_resultTestNG {
travelInsurance_result tr;
	
	@Test(priority=1)
	public void user_selects_student_plan_from_the_filter_options() {
		tr=new travelInsurance_result(hooks.getDriver());
		
		baseClass.getlogger().info("*******user selects student plan from the filter options********");
		tr.studentPlanFilter();
	}

	@Test(priority=2)
	public void student_travel_information_slider_page_is_opened() {
		baseClass.getlogger().info("*******Student Travel Information slider page is opened********");   
	}

	@Test(priority=3)
	public void user_selects_the_student_visa_for_both_the_student_travellers() {
		baseClass.getlogger().info("*******user selects the Student Visa for both the student travellers********");
		tr.visaOption();
	}

	@Test(priority=4)
	public void user_enters_the_duration_of_the_trip_and_clicks_on_apply_changes() {
		baseClass.getlogger().info("*******user enters the duration of the trip and clicks on apply changes********");
	   tr.durationOptn();
	}
	@Test(priority=5)
	public void user_selects_premium_low_to_high_filter_from_sort_by_dropdown() throws InterruptedException, FileNotFoundException, IOException {
		baseClass.getlogger().info("*****selecting low to high filter from the sort by dropdown to apply filter**********");
	    tr.filter();
	}


	@Test(priority=6)
	public void insurance_plans_are_displayed_and_top3_cheapest_plan_names_along_with_their_is_captured() throws IOException {
		
		baseClass.getlogger().info("*****printing the top3 minimum travel insurance plans for students**********");
		String name[]=new String[tr.planName.size()];
		String price[]=new String[tr.planPrice.size()];
		String company[]=new String[tr.companyName.size()];
		
		for (int i = 0; i < 3; i++) {
			company[i]=tr.companyName.get(i).getText();
			System.out.println( tr.companyName.get(i).getText());
			name[i]=tr.planName.get(i).getText();
			
			price[i]=tr.planPrice.get(i).getText();
	}
		for(int i=0;i<3;i++)
		{
			System.out.println(name[i]+" :"+price[i]);
			
		}
		dataDriven.writeData("policyBazaar.xlsx","Sheet2",company,name,price);
		
	}

	@Test(priority=7)
		public void user_is_navigated_to_main_page() {
		    tr.navigateToMainPage();
		}


}
