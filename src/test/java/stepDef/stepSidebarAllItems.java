package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import pages.dashboardPage;

import java.util.concurrent.TimeUnit;

public class stepSidebarAllItems extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user already opened sidebar menu")
    public void user_already_opened_sidebar_menu(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);
        loginpage = new loginPage(driver);
        loginpage.isDisplayed();
        loginpage.login();

        dashboardpage = new dashboardPage(driver);
        dashboardpage.isDisplayed();
        dashboardpage.clickSidebarMenu();
        dashboardpage.validateSidebarMenu();

        dashboardpage.clickAllItems();
        dashboardpage.validateAllItems();

    }

    @When("user click all item")
    public void user_click_all_item(){

    }

    @Then("the product item is displayed")
    public void the_product_item_is_displayed(){

    }

}
