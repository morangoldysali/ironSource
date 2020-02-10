package browserTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class jobsPage {

	WebDriver driver;
	
	public jobsPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnIsraelPositions() {
		try {
			driver.findElement(By.className("sc_btn")).click();;
		}
		catch (Exception e) {
			System.out.print(e);
			System.out.print("couldn't find the link Yalla, lets go on Jobs page");
		}
	}
}
