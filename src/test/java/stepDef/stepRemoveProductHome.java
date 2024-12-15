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

public class stepRemoveProductHome extends env_target{
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user added product and is on home page")
    public void user_added_product_and_is_on_home_page(){
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
        dashboardpage.buttonRemoveEnable();
    }

    @When("user click remove button")
    public void user_click_remove_button(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickRemoveButonn();
    }

    @Then("product removed from cart")
    public void product_removed_from_cart(){
        System.out.println("item removed");
    }

    @And("add to cart button is enabled")
    public void add_to_cart_button_is_enabled(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.buttonItem1AddEnable();

        driver.close();
    }




}
