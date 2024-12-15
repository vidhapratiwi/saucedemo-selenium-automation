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

import java.util.concurrent.TimeUnit;

public class stepAddToCart extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user on dashboard page")
    public void user_on_dashboard_page(){
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
    }

    @When("user click on add to cart button")
    public  void user_click_on_add_to_cart_button(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickItem1AddButton();
    }

    @Then("remove button is enable")
    public void remove_button_is_enable(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.buttonRemoveEnable();

        driver.close();
    }

}

