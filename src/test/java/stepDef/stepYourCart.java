package stepDef;

import config.env_target;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import pages.dashboardPage;
import pages.yourcartPage;

import java.util.concurrent.TimeUnit;

public class stepYourCart extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;

    @Given("user already added product to cart")
    public void user_already_added_product_to_cart(){
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

    }

    @When("user click on shopping cart")
    public void user_click_on_shopping_cart(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickCartButton();
    }

    @Then("user see product on your cart page")
    public void user_see_product_on_your_cart_page(){
        cartpage = new yourcartPage(driver);
        cartpage.isDisplayed();
        cartpage.itemOnCartIsDisplayed();

        driver.close();
    }
}
