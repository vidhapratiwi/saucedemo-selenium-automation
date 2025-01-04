package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.loginPage;
import pages.dashboardPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class stepSidebarAbout extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user already open sidebar menu")
    public void user_already_open_sidebar_menu(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);
        loginpage = new loginPage(driver);
        loginpage.isDisplayed();
        loginpage.login();

        dashboardpage = new dashboardPage(driver);
        dashboardpage.isDisplayed();
        dashboardpage.clickSidebarMenu();
        dashboardpage.validateSidebarMenu();
    }

    @When("user click about")
    public void user_click_about(){
        dashboardpage.clickSidebarAbout();
    }

    @Then("user is directed to website saucelab")
    public void user_is_directed_to_website_saucedemo(){
        dashboardpage.validateSidebarAbout();
    }

}
