package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class stepCancelYourPage extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;
    yourinfoPage infopage;


    @Given("user is at your info page")
    public void user_is_at_your_info_page(){
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
        //set url
        dashboardpage.clickItem1AddButton();
        dashboardpage.clickCartButton();

        cartpage = new yourcartPage(driver);
        cartpage.isDisplayed();
        cartpage.clickCheckoutButton();

        infopage = new yourinfoPage(driver);
        infopage.isDisplayed();
    }

    @When("user click cancel button")
    public void user_click_cancel_button(){
        infopage.clickCancel();
    }

    @Then("user directed to cart page")
    public void user_directed_to_cart_page(){
        cartpage.isDisplayed();
    }

}
