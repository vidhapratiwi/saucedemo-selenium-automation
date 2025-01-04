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

import java.util.concurrent.TimeUnit;

public class stepCancelOverview extends env_target{

    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;
    yourcartPage cartpage;
    yourinfoPage infopage;
    overviewPage overviewpage;

    @Given("user on overview page")
    public void user_on_overview_page(){
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
        cartpage.clickCheckoutButton();

        infopage = new yourinfoPage(driver);
        infopage.isDisplayed();
        infopage.fillInformationForm();
        infopage.clickContinue();

        overviewpage = new overviewPage(driver);
        overviewpage.isDisplayed();
        overviewpage.itemIsDisplayed();
    }

    @When("user clicks on cancel button")
    public void user_clicks_on_cancel_button(){
        overviewpage = new overviewPage(driver);
        overviewpage.clickCancelButton();
    }

    @Then("user is directed to your info page")
    public void user_is_directed_to_your_info_page(){
        infopage = new yourinfoPage(driver);
        infopage.isDisplayed();
    }

}
