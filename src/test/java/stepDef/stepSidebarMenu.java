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

public class stepSidebarMenu extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user already on homepage")
    public void user_already_on_homepage(){
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
    }

    @When("user click sidebar menu")
    public void user_click_sidebar_menu(){
        dashboardpage.clickSidebarMenu();
    }

    @Then("sidebar menu is diplayed")
    public void sidebar_menu_is_displayed(){
        dashboardpage.validateSidebarMenu();
    }

}
