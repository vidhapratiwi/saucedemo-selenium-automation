package stepDef;

import org.openqa.selenium.WebDriver;
import pages.dashboardPage;
import pages.loginPage;
import pages.yourcartPage;
import pages.yourinfoPage;

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
import pages.yourcartPage;
import pages.yourinfoPage;

import java.util.concurrent.TimeUnit;

public class stepFailedPurchaseNoInfo extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;
    yourinfoPage infopage;

    @Given("user added product and on info page")
    public void user_added_product_and_on_info_page(){
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
        dashboardpage.clickItem1AddButton();
        dashboardpage.clickCartButton();

        cartpage = new yourcartPage(driver);
        cartpage.isDisplayed();
        cartpage.clickCheckoutButton();

        infopage = new yourinfoPage(driver);
        infopage.isDisplayed();
    }

    @When("user click on continue button")
    public void user_click_on_continue_button(){
        infopage = new yourinfoPage(driver);
        infopage.clickContinue();
    }

    @Then("error message shown and tell user to fill form")
    public void error_message_shown_and_tell_user_to_fill_form(){
        infopage = new yourinfoPage(driver);
        infopage.showErrorMessage();

        driver.close();
    }
}
