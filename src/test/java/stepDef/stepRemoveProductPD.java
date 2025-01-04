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

public class stepRemoveProductPD extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    productPage productpage;

    @Given("user has already added product to cart")
    public void user_has_already_added_product_to_cart(){
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
        productpage.clickAddToCart();
        productpage.validateRemoveButtonDisplayed();
        productpage.validateCartBadgeDisplayed();
    }

    @When("user clicks remove button")
    public void user_clicks_remove_button(){
        productpage.clickRemoveButton();
    }

    //still failed at this step
    @Then("product removed from the cart")
    public void product_removed_from_the_cart(){
        productpage.validateCartBadgeHidden();
    }

    @And("add to cart button is displayed")
    public void add_to_cart_button_is_displayed(){
        productpage.validateAddToCartButton();
    }

}
