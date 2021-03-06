package browserTest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import browserTest.POMWithPageFactory.DriverManager;
import browserTest.POMWithPageFactory.DriverManagerFactory;
import browserTest.POMWithPageFactory.DriverType;
import browserTest.pages.jobsPage;
import browserTest.pages.mainPage;
import browserTest.pages.telAvivJobs;

public class browserTest {
	DriverManager driverManager;
	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get("https://company.ironsrc.com/");
		Assert.assertEquals("https://company.ironsrc.com/", driver.getCurrentUrl());
		
		
	
	}
	
	@Test
	public void checkNumOfJobs() {
		
		mainPage main = new mainPage(driver);
		jobsPage jobs = new jobsPage(driver);
		telAvivJobs localJobs = new telAvivJobs(driver);
		//clicking on jobs on main page
		main.clickOnJobs();
		//click on Israel link on the career page
		jobs.clickOnIsraelPositions();
		//creating a list for all tabs that opens on web browser
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		//switches to new tab
		driver.switchTo().window(tabs.get(1)); 
		String currentURL = driver.getCurrentUrl();
		//checking that the driver changed to the new tab
		Assert.assertEquals("https://company.ironsrc.com/careers-tel-aviv/", currentURL);
		//waiting until all the jobs are loaded
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;
		//getting the number of jobs on page and the counter of jobs to compare
		int numbystring = localJobs.getPositionsCounter();
		int numOfRealPositions = localJobs.getNumOfPositions();
		if (numOfRealPositions == numbystring)
			System.out.print("Test passed! number of listed jobs: " + numbystring + ", number of actual jobs: " + numOfRealPositions);
		else 
			System.out.print("Test failed! number of listed jobs: " + numbystring + ", number of actual jobs: " + numOfRealPositions);
		
	}
	


	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
	}

}

