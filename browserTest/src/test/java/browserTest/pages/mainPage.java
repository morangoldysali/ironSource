package browserTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {

	WebDriver driver;
	
	public mainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void clickOnJobs() {
		try {
			driver.findElement(By.xpath("//a[text()='Jobs']")).click();
		}
		catch (Exception e) {
			System.out.print("Cant Find Object - jobs on mainPage");
		}
		
	}
}