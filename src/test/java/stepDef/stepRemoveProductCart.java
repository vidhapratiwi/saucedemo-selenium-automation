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

public class stepRemoveProductCart extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;

    @Given("user added product and is on cart page")
    public void user_added_product_and_is_on_cart_page(){
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
        //dashboardpage.buttonRemoveEnable();

    }

    @When("user click the remove button")
    public void user_click_the_remove_button(){
        cartpage = new yourcartPage(driver);
        cartpage.clickRemoveButton();
    }

    @Then("product is removed from cart")
    public void product_is_removed_from_cart() {
        dashboardpage = new dashboardPage(driver);
        System.out.println("item removed");

        driver.close();
    }

}
