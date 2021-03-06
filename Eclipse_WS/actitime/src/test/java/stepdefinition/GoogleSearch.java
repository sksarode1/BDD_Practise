package stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class GoogleSearch 
{

	static WebDriver driver ;

	/*
	 * public GoogleSearch() {
	 * 
	 * }
	 * 
	 * public GoogleSearch(WebDriver driver) { this.driver = driver; }
	 */
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

	@When("guser enter {}")
	public void user_enter(String companyName) {
		driver.findElement(By.name("q")).sendKeys(companyName);
	}

	@Then("user prints the search/google results for {int} page(s)")
	public void user_prints_the_search_results(Integer number) {
		for (int i = 1; i <= number; i++) {
			List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
			for (WebElement result : searchResults) {
				System.out.println(result.getText());
			}
			System.out.println("--- completed page-------- " + i);
			int j = i + 1;
			driver.findElement(By.linkText(String.valueOf(j))).click();
		}

		Assert.assertFalse(true);
//		driver.close();
	}

	@When("data table user search company name and print the search results")
	public void data_table_user_search_company_name_and_print_the_search_results(DataTable dataTable) {

		List<String> data = dataTable.asList();
		String companyName = null;
		for (int i = 0; i < data.size(); i++) {
			companyName = null;
			companyName = data.get(i);
			driver.findElement(By.name("q")).clear();
			driver.findElement(By.name("q")).sendKeys(companyName);
			driver.findElement(By.name("btnK")).click();

			List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
			for (WebElement result : searchResults) {
				System.out.println(result.getText());
			}

			driver.navigate().back();
		}

	}

	@When("lists data table user search company name and print the search results")
	public void lists_data_table_user_search_company_name_and_print_the_search_results(
			DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String companyName = null;
		for (int i = 0; i < data.size(); i++) {
			companyName = null;
			companyName = data.get(i).get(0);
			driver.findElement(By.name("q")).clear();
			driver.findElement(By.name("q")).sendKeys(companyName);
			driver.findElement(By.name("btnK")).click();

			List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
			for (WebElement result : searchResults) {
				System.out.println(result.getText());
			}

			driver.navigate().back();
		}
	}

	@When("map data table user search company name and print the search results")
	public void map_data_table_user_search_company_name_and_print_the_search_results(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		String companyName = null;
		for (int i = 0; i < data.size(); i++) {
			companyName = null;
			companyName = data.get(i).get("company");
			driver.findElement(By.name("q")).clear();
			driver.findElement(By.name("q")).sendKeys(companyName);
			driver.findElement(By.name("btnK")).click();

			List<WebElement> searchResults = driver.findElements(By.tagName("h3"));
			for (WebElement result : searchResults) {
				System.out.println(result.getText());
			}

			driver.navigate().back();
		}

	}

	@Then("user close the browser")
	public void close_the_browser() {
		driver.close();
	}

	
	
	@Given("hookuser is on google page")
	public void hookuser_is_on_google_page() {
		driver.get("https://www.google.com/");
	}
	
	
}
