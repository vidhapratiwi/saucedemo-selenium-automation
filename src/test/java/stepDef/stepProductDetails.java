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
import pages.productPage;

import java.util.concurrent.TimeUnit;

public class stepProductDetails extends env_target {
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    productPage productpage;

    @Given("user is on dashboard page")
    public void user_is_on_dashboard_page(){
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

    @When("user click product name")
    public void user_click_product_name(){
        dashboardpage = new dashboardPage(driver);
        dashboardpage.clickItem1();
    }

    @Then("user see product details")
    public void user_see_product_details() {
        productpage = new productPage(driver);
        productpage.isDisplayed();
        productpage.isDisplayingProductDetails();

        driver.close();
    }
}
