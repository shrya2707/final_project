package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.baseClass;
import base.screenshot;
import io.cucumber.java.en.*;
import pageObject.carInsurance;
import pageObject.home;

public class car {
	
	screenshot s=new screenshot(baseClass.getDriver());
	home h=new home(baseClass.getDriver());
	carInsurance c=new carInsurance(baseClass.getDriver());
	
	
	@When("user clicks on car insurance option from all the options available on the main page")
	public void user_clicks_on_car_insurance_option_from_all_the_options_available_on_the_main_page() throws IOException {
		baseClass.getlogger().info("*****user scrolls down the main page**********");
		h.scrollDown();
		s.ScreenShots("mainmenu");
		baseClass.getlogger().info("*****car option is selected out of all the main menu options present**********");
		h.selectCarInsOption();
	}
	
	
	@When("user clicks on buying a new car option")
	public void user_clicks_on_buying_a_new_car_option() throws IOException {
		baseClass.getlogger().info("*****user selects the buying a new car option**********");
		s.ScreenShots("carInsurance");
		c.clickOnNewCar();
	}

	@When("user selects the city and car number")
	public void user_selects_the_city_and_car_number() throws IOException {
		baseClass.getlogger().info("*****user the selects the city**********");
		c.selectCity();
		s.ScreenShots("carCity");
		baseClass.getlogger().info("*****selecting the RTO No for the vehicle**********");
		c.selectCarNo();
	}

	@When("user selects the car brand")
	public void user_selects_the_car_brand() throws IOException {
		baseClass.getlogger().info("*****selecting the car brand **********");
		s.ScreenShots("carModel");
		c.selectCarModel();
	}

	@When("user selects the car model type and other features")
	public void user_selects_the_car_model_type_and_other_features() {
		baseClass.getlogger().info("*****selecting the car model type**********");
	    c.selectCarModelType();
	    baseClass.getlogger().info("*****selecting the engine type**********");
	    c.selectCarModelType1();
	}

	@When("user enters the name as {string} email as {string} and phone number as {string}")
	public void user_enters_the_name_as_email_as_and_phone_number_as(String name, String email, String phnNo) throws IOException {
		baseClass.getlogger().info("*****entering all the personal details**********");
		c.name.sendKeys(name);
		c.email.sendKeys(email);
		c.mobileNo.sendKeys(phnNo);
		
		
	}

	@Then("invalid email error is shown")
	public void invalid_email_error_is_shown() {
		baseClass.getlogger().info("*****displaying the invalid email error**********");
		if(c.submitButton.isEnabled())
		{
			System.out.println("Submit button enabled");
		}
		else
		{
			System.out.println("Error :"+c.emailError.getText());
		}
	   
	}
	
	@Then("user is navigated to main policybazaar page")
	public void user_is_navigated_to_main_policybazaar_page() {
	    c.mainPageIcon1.click();
	}


}
