package stepdefinition;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.DashboardPage;
import page.LoginPage;


public class AcititmeTests {

	
	String url = "http://localhost/login.do";
	String testName = null;
	WebDriver driver = null;
	LoginPage lp  = null;
	DashboardPage dp  = null;
	ExtentTest test = null;
	static ExtentReports reports = null;
	@After
	public void saveReports()
	{
		reports.flush();
		reports = null;
		
	}
	@Before
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		 reports = new ExtentReports("target\\reports\\Automation_Report_" + new Date().toString().replace(" ", "_").replace(":", "_") + ".html", false);
		
	}
	@Given("pomuser is on login page")
	public void pomuser_is_on_login_page() {
		test = reports.startTest("Test Login");
		test.log(LogStatus.INFO	, "Launcting the application " + url);	
	    driver.get(url);
	    test.log(LogStatus.PASS, "launching application is successful");
	}
	@When("pomuser enter valid username and password")
	public void pomuser_enter_valid_username_and_password() {
		test.log(LogStatus.INFO, "Entering username and password");
	    lp.enterUsername("admin");
	    lp.enterPassword("manager");
		test.log(LogStatus.PASS, "Entering username and password");
		
	}
	@When("pomuser click on login Button")
	public void pomuser_click_on_login_button() throws InterruptedException {
		test.log(LogStatus.INFO, "Clicking on Login Button");
	    lp.clickOnLogin();
	    Thread.sleep(5000);
	}
	@Then("pomuser will be landed in dashboard page")
	public void pomuser_will_be_landed_in_dashboard_page() {
		test.log(LogStatus.INFO, "Verifying user is on dasboard page");
	   Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());
		test.log(LogStatus.PASS, "Verifying user is on dasboard page");
		   
	}
	@Then("pomuser will logout and close browser")
	public void pomuser_will_logout_and_close_browser() {
		test.log(LogStatus.INFO, "Logout from the application");
	    dp.clickLogout();
	    driver.close();
		test.log(LogStatus.PASS, "Logout from the application");
		reports.endTest(test);
		  	    
	}

}
