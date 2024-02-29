package testNG;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseClass;
import base.dataDriven;
import base.screenshot;
import pageObject.home;

public class healthtestNG {
	home h;
	screenshot s;
	
	@Test(priority=1)
	public void intial()
	{
		
	 h=new home(hooks.getDriver());
	 s=new screenshot(hooks.getDriver());
	}
	
	
	@Test(priority=2)
	public void user_hovers_over_the_insurance_plans_on_main_page() throws InterruptedException, IOException {
		baseClass.getlogger().info("*****hovering over the insurance plans option on the main page**********");
		h.hoverOverInsurance();
		s.ScreenShots("healthInsOptions");
	}

	@Test(priority=3)
	public void finds_health_insurance_option_from_the_list() {
		baseClass.getlogger().info("*****capturing the insurance options available**********");
	    h.healthMenuOptions();
	}

	@Test(priority=4)
	public void all_the_options_under_health_insurance_are_displayed() throws IOException {
		baseClass.getlogger().info("*****displaying the health insurance options available**********");
		String health[]=new String[h.healthinsoptn.size()];
		System.out.println("Health Insurance Options:");
		for(int j=0;j<h.healthinsoptn.size();j++)
		{
			System.out.println(h.healthinsoptn.get(j).getText());
			health[j]=h.healthinsoptn.get(j).getText();
		}
		dataDriven.writeDatahealth("policyBazaar.xlsx","Sheet2",health);
	}

}
