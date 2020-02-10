package browserTest.POMWithPageFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager extends DriverManager{

	@Override
	public void createWebDriver(){
		//FirefoxOptions options = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();
		this.driver = new FirefoxDriver();
	}
}

