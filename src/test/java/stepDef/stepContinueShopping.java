package stepDef;

import config.env_target;
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

public class stepContinueShopping extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;

    @Given("user added product to cart")
    public void user_added_product_to_cart(){
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

    }

    @When("user click continue shopping")
    public void user_click_continue_button(){
        cartpage.clickContinueShopping();
    }

    @Then("user directed to home page")
    public void user_directed_to_home_page(){
        dashboardpage.isDisplayed();
    }
}
