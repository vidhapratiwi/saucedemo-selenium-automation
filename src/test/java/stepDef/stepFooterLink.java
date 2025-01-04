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

public class stepFooterLink extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user in homepage")
    public void user_in_homepage(){
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
    }

    @When("user click (.*) link in the footer$")
    public void user_click_linkName_link_in_the_footer(String linkName){
        dashboardpage.clickFooterLink(linkName);
    }

    @Then("user is redirected to the correct (.*)$")
    public void user_is_redirected_to_the_correct_expectedURL(String expectedURL){
        dashboardpage.validateRedirectURL(expectedURL);
    }

}
