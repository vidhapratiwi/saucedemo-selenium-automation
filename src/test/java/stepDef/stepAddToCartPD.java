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
import pages.productPage;

import java.util.concurrent.TimeUnit;


public class stepAddToCartPD extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    productPage productpage;

    @Given("user is on product details page")
    public void user_is_on_product_details_page(){
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
        dashboardpage.clickItem1();

        productpage = new productPage(driver);
        productpage.isDisplayingProductDetails();
    }

    @When("user click add to cart")
    public void user_click_add_to_cart(){
        productpage.clickAddToCart();
    }

    @Then("remove button is displayed")
    public void remove_button_is_displayed(){
        productpage.validateRemoveButtonDisplayed();
    }

    @And("cart badge is displayed")
    public void cart_badge_is_displayed(){
        productpage.validateCartBadgeDisplayed();
    }


}
