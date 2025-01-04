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
import pages.yourinfoPage;
import pages.overviewPage;
import pages.completePage;

import java.util.concurrent.TimeUnit;

public class stepSuccessfulPurchase extends env_target {

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;
    yourinfoPage infopage;
    overviewPage overviewpage;
    completePage completepage;

    @Given("user added product and on cart page")
    public void user_added_product_and_on_cart_page(){
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

    @When("user click checkout button")
    public void user_click_checkout_button(){
        cartpage = new yourcartPage(driver);
        cartpage.clickCheckoutButton();
    }

    @Then("user on your info page")
    public void user_on_info_page(){
        infopage = new yourinfoPage(driver);
        infopage.isDisplayed();

    }

    @And("user input firstname")
    public void user_input_firstname(){
        infopage = new yourinfoPage(driver);
        infopage.inputFirstName();
    }

    @And("user input lastname")
    public void user_input_lastname(){
        infopage = new yourinfoPage(driver);
        infopage.inputLastName();

    }

    @And("user input postalcode")
    public void user_input_postalcode(){
        infopage = new yourinfoPage(driver);
        infopage.inputPostalCode();

    }

    @And("user click continue button")
    public void user_click_continue_button(){
        infopage = new yourinfoPage(driver);
        infopage.clickContinue();

    }

    @Then("user is on overview page")
    public void user_is_on_overview_page(){
        overviewpage = new overviewPage(driver);
        overviewpage.isDisplayed();
        overviewpage.itemIsDisplayed();

    }

    @And("user click finish button")
    public void user_click_finish_button(){
        overviewpage = new overviewPage(driver);
        overviewpage.clickFinishButton();

    }

    @Then("purchase successfully made")
    public void purchase_successfully_made(){
        completepage = new completePage(driver);
        completepage.isDisplayed();

    }

    @And("success message appear")
    public void success_message_appears(){
        completepage = new completePage(driver);
        completepage.showSuccessMessage();

        driver.close();
    }





}
