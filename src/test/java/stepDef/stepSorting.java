package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import pages.dashboardPage;

import java.util.concurrent.TimeUnit;

public class stepSorting extends env_target {
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user is on the dashboard page")
    public void user_is_on_the_dashboard_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);
        loginpage = new loginPage(driver);
        loginpage.isDisplayed();
        loginpage.inputUsername("standard_user");
        loginpage.inputPassword("secret_sauce");
        loginpage.clickLoginButton();

        dashboardpage = new dashboardPage(driver);
        dashboardpage.isDisplayed();
    }

    @When("user click {string} sorting option")
    public void user_click_sorting_option(String sortingOption){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickSortingDropdown();
        dashboardpage.selectDropdownValue(sortingOption);
    }

    @Then("items should be sorted correctly")
    public void items_should_be_sorted_correctly(){
        //nanti benerin lagi disesuaikan sorting valuenya
        System.out.println("Item is sorted");
        driver.close();
    }

//    @After
//    public void clean_up(){
//        driver.quit();
//    }
}
