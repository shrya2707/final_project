package testNG;

import java.io.IOException;

import org.testng.annotations.Test;

import base.baseClass;
import base.screenshot;
import pageObject.carInsurance;
import pageObject.home;

public class cartestNG {
	screenshot s;
	home h;
	carInsurance c;
	
	@Test(priority=1)
	public void intial()
	{
	s=new screenshot(hooks.getDriver());
	h=new home(hooks.getDriver());
	c=new carInsurance(hooks.getDriver());
	}
	
	
	@Test(priority=2)
	public void user_clicks_on_car_insurance_option_from_all_the_options_available_on_the_main_page() throws IOException {
		baseClass.getlogger().info("*****user scrolls down the main page**********");
		h.scrollDown();
		s.ScreenShots("mainmenu");
		baseClass.getlogger().info("*****car option is selected out of all the main menu options present**********");
		h.selectCarInsOption();
	}
	
	
	@Test(priority=3)
	public void user_clicks_on_buying_a_new_car_option() throws IOException {
		baseClass.getlogger().info("*****user selects the buying a new car option**********");
		s.ScreenShots("carInsurance");
		c.clickOnNewCar();
	}

	@Test(priority=4)
	public void user_selects_the_city_and_car_number() throws IOException {
		baseClass.getlogger().info("*****user the selects the city**********");
		c.selectCity();
		s.ScreenShots("carCity");
		baseClass.getlogger().info("*****selecting the RTO No for the vehicle**********");
		c.selectCarNo();
	}

	@Test(priority=5)
	public void user_selects_the_car_brand() throws IOException {
		baseClass.getlogger().info("*****selecting the car brand **********");
		s.ScreenShots("carModel");
		c.selectCarModel();
	}

	@Test(priority=6)
	public void user_selects_the_car_model_type_and_other_features() {
		baseClass.getlogger().info("*****selecting the car model type**********");
	    c.selectCarModelType();
	    baseClass.getlogger().info("*****selecting the engine type**********");
	    c.selectCarModelType1();
	}

	@Test(priority=7)
	public void user_fills_the_personal_details_with_invalid_email() throws IOException {
		baseClass.getlogger().info("*****entering all the personal details**********");
		c.personalDetails();
		s.ScreenShots("emailError");
	}

	@Test(priority=8)
	public void invalid_email_error_is_shown() {
		baseClass.getlogger().info("*****displaying the invalid email error**********");
	    System.out.println("Error :"+c.emailError.getText());
	   
	}
	
	@Test(priority=9)
	public void user_is_navigated_to_main_policybazaar_page() {
	    c.homepage.click();
	}


}
	


