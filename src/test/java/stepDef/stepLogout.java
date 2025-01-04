package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import pages.dashboardPage;

import java.util.concurrent.TimeUnit;

public class stepLogout extends  env_target{
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user on homepage")
    public  void  user_on_homepage(){
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

    @When("user click sidebar")
    public  void user_click_sidebar(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickSideBarMenu();
    }

    @And("user click logout")
    public void user_click_logout(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickLogout();
    }

    @Then("user successfully logout")
    public void user_successfully_logout(){
        loginpage = new loginPage(driver);
        loginpage.isDisplayed();
    }


}
