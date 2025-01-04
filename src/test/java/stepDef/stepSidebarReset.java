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

public class stepSidebarReset extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;


    @Given("user added item to cart and is on sidebar menu")
    public void user_added_item_to_cart_and_is_on_sidebar_menu(){
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
        dashboardpage.buttonItem1AddEnable();
        dashboardpage.clickItem1AddButton();
        dashboardpage.buttonRemoveEnable();

        dashboardpage.cartBadgeEnabled();

        dashboardpage.clickSidebarMenu();
        dashboardpage.validateSidebarMenu();
    }

    @When("user click reset app state")
    public void user_click_reset_app_state(){
        dashboardpage.clickResetAppState();
    }

    @Then("all item on cart is removed")
    public void all_item_on_cart_is_removed(){
        dashboardpage.cartBadgeDisabled();
    }

    @And("remove button changed to add to cart button")
    public void remove_button_changed_to_add_to_cart_button(){
        dashboardpage.removeButtonDisabled();
        dashboardpage.buttonItem1AddEnable();
    }

}
