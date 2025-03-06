package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NABHomePage {
	
	@Given("user opens nab website {string}")
	public void user_opens_nab_website(String string) {
		Common.browser.get("https://www.nab.com.au/");
	}

	@Then("nab website should load successfuly")
	public void nab_website_should_load_successfuly() {
		Assert.assertTrue(Common.browser.findElement(By.id("quick-login")).isDisplayed());
		System.out.println("homepage displayed successfuly");
	}

	@Then("{string} link should present on home page")
	public void link_should_present_on_home_page(String string) {		
		Assert.assertTrue(Common.browser.findElement(By.linkText(string)).isDisplayed());
		Common.browser.findElement(By.linkText(string)).click();
		Common.Wait(2);
		System.out.println(string + " link is present");
		Common.takeScreenshot();
	
	}
	
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		Common.browser.findElement(By.xpath("//*[@id=\"header-container\"]/header/div[3]/div[2]/div/a")).click();
		Common.Wait(2);
	}

	@When("user enters {string} in searchbox")
	public void user_enters_in_searchbox(String string) {
		Common.browser.findElement(By.id("nab-header-search__input")).sendKeys(string);
		Common.Wait(2);
		Common.takeScreenshot();
	}

	@Then("{string} link should display in search results")
	public void link_should_display_in_search_results(String string) {
		Common.browser.findElement(By.linkText(string)).isDisplayed();
		String text = Common.browser.findElement(By.linkText(string)).getText();
		Common.takeScreenshot();
		Assert.assertTrue(string.trim().equalsIgnoreCase(text));
		Common.Wait(2);
	}
	
	@When("user hits {string} key")
	public void user_hits_key(String string) {
		Common.browser.findElement(By.id("nab-header-search__input")).sendKeys(Keys.ENTER);
		Common.Wait(5);
	}

}
