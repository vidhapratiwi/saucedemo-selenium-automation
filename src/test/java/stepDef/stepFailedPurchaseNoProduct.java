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
import pages.yourcartPage;

import java.util.concurrent.TimeUnit;

public class stepFailedPurchaseNoProduct extends env_target{
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;

    @Given("user is on cart page")
    public void user_is_on_cart_page(){
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
        dashboardpage.clickCartButton();

        cartpage = new yourcartPage(driver);
        cartpage.isDisplayed();
    }

    @When("user click the checkout button")
    public void user_click_the_checkout_button(){
        cartpage = new yourcartPage(driver);
        cartpage.clickCheckoutButton();

        driver.close();
    }

    @Then("error message shown and tell user to add product")
    public void error_message_shown_and_tell_user_to_add_product(){
        cartpage = new yourcartPage(driver);
        cartpage.showErrorMessage();
    }

}
