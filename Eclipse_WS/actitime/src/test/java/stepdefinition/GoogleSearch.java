package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	WebDriver driver = null; 
	
	@Given("user is on google page")
	public void user_is_on_google_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	@When("click on search button")
	public void click_on_search_button() {
	    driver.findElement(By.name("btnK")).click();
	}
//	@When("user enter synechron")
//	public void user_enter_synechron() {
//	    driver.findElement(By.name("q")).sendKeys("synechron");
//	}
//	@When("user enter IBM")
//	public void user_enter_ibm() {
//		driver.findElement(By.name("q")).sendKeys("IBM");
//	}
//	@When("user enter Wipro")
//	public void user_enter_wipro() {
//		driver.findElement(By.name("q")).sendKeys("WIPRO");
//	}
	
	@When("user enter {}")
	public void user_enter(String companyName) {
		driver.findElement(By.name("q")).sendKeys(companyName);
	}
	@Then("user prints the search results for {int} page(s)")
	public void user_prints_the_search_results(Integer number)
	{
	    for (int i = 1; i <= number; i++) 
	    {
	    	List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
			for (WebElement result : searchResults) 
			{
				System.out.println(result.getText());
			}
			System.out.println("--- completed page-------- " + i );
			int j  = i+1;
			driver.findElement(By.linkText(String.valueOf(j))).click();
		}
		
		driver.close();
	}

	
}
