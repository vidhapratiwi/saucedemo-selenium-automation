package stepDef;

import org.junit.Assert;
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

public class stepFailedPurchase extends env_target{
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;
    yourinfoPage infopage;

    @Given("user is on your info page")
    public void user_is_on_your_info_page(){
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

    @When("user enter (.*) as first name$")
    public void user_enter_firstname_as_first_name(String firstName){
        infopage.enterFirstName(firstName);
    }

    @Then("user enter (.*) as last name$")
    public void user_enter_lastname_as_last_name(String lastName){
        infopage.enterLastName(lastName);
    }

    @And("user enter (.*) as zip or postal code$")
    public void user_enter_zipcode_or_postal_code(String zipCode){
        infopage.enterZipCode(zipCode);
    }

    @And("user clicks continue button")
    public void user_clicks_continue_button(){
        infopage.clickContinue();
    }

    @Then("an error message (.*) should be displayed$")
    public void an_error_message_expectedErrorMessage_should_be_displayed(String expectedErrorMessage){
        String actualMessage = infopage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualMessage);
    }

}
