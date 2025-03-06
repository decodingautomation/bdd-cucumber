package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void tearup(Scenario scenario) {
		Common.scenario = scenario;
		try {
			Common.readPropertiesFile();
		} catch (IOException e) {
		}
		System.out.println("before hook running");

//		switch ("CHROME") {
		switch (Common.prop.getProperty("browser").trim().toUpperCase()) {
		case "CHROME":
			Common.browser = new ChromeDriver();
			Common.browser.manage().window().maximize();
			break;
		case "EDGE":
//			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\msedgedriver.exe");			
			Common.browser = new EdgeDriver();
			Common.browser.manage().window().maximize();
			break;
		case "FIREFOX":
			Common.browser = new FirefoxDriver();
			Common.browser.manage().window().maximize();
			break;
		default:
			System.out.println("Invalid browser name, please check browser name specified in config.properties file.");
			System.exit(0);

		}

	}

	@After
	public static void teardown() {
		System.out.println("after hook running");
		Common.browser.quit();
		Common.browser = null;
	}

}
