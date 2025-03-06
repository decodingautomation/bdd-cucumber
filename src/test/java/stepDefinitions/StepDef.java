package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef {
	
	@Given("aaa")
	public void aaa() {
	    System.out.println("running aaa...");
	}
	@When("bbb")
	public void bbb() {
		System.out.println("running bbb...");
	}
	@Then("ccc")
	public void ccc() {
		System.out.println("running ccc...");
		
		
	}


}
