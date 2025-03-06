package stepDefinitions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class Common {

	static WebDriver browser;
	public static Scenario scenario;
	public static Properties prop;
	

	public static void readPropertiesFile() throws IOException {

		
		String propFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "config.properties";
		prop = new Properties();
		FileReader fr = new FileReader(propFilePath);
		prop.load(fr);
		
		
		
	}

	public static void Wait(int Seconds) {
		try {
			TimeUnit.SECONDS.sleep(Seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot() {
		final byte[] screenshot = ((TakesScreenshot) Common.browser).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");

	}

}
