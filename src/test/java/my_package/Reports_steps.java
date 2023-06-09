package my_package;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reports_steps {
	Reports r;
	boolean state=false;
	Logging ad;
	public String password;
	
	public Reports_steps() {
		ad=new Logging();
		ad.password="123456";
		r=new Reports();
	}
	
	@Given("that the admin is logged in system")
	public void that_the_admin_is_logged_in_system() {

		  ad.logState(true);

	}

	@When("the admin selects the {string} option")
	public void the_admin_selects_the_option(String string) {
	    if(string.equals("Generate Report"))
	    	state=true;
	}

	@Then("the system generates and displays the customized report")
	public void the_system_generates_and_displays_the_customized_report() {
	   if(state) {
		   r.generateReport();
		   assertTrue(state);
	   }
	   else assertFalse(state);
	}


}