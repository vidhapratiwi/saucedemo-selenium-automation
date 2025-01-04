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

public class stepSidebarLogout extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user is on sidebar menu")
    public void user_is_on_sidebar_menu(){
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

    @When("user click logout menu")
    public void user_click_logout_menu(){
        dashboardpage.clickLogout();
    }

    @Then("user success logout")
    public void user_success_logout(){
        loginpage.isDisplayed();
    }

}

