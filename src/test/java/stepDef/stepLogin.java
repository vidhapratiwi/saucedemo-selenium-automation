package stepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.loginPage;
import pages.dashboardPage;

import java.util.concurrent.TimeUnit;

public class stepLogin extends env_target{
    WebDriver driver;
    loginPage loginpage;
    dashboardPage dashboardpage;

    @Given("user already on stepLogin page")
    public void user_already_on_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        //set url
        driver.get(baseUrl);
        loginpage = new loginPage(driver);
        loginpage.isDisplayed();
    }

    @When("user input (.*) as username$")
    public void user_input_username_as_username(String username){
        loginpage = new loginPage(driver);
        loginpage.inputUsername(username);
    }

    @And("user input (.*) as password$")
    public void user_input_password_as_password(String password){
        loginpage = new loginPage(driver);
        loginpage.inputPassword(password);
    }

    @And("user click stepLogin button")
    public void user_click_login_button(){
        loginpage = new loginPage(driver);
        loginpage.clickLoginButton();
    }

    @Then("user verify (.*) stepLogin result$")
    public void user_verify_status_login_result(@NotNull String status){
        loginpage = new loginPage(driver);
        dashboardpage = new dashboardPage(driver);

        //yang success masih belum bisa selesai sampai close tab
        if(status.equals("success")){
            dashboardpage = new dashboardPage(driver);
            dashboardpage.isDisplayed();
        } else {
            loginpage.showErrorMessage();
        }
        driver.close();
    }



//    @After
//    public void clean_up(){
//        driver.quit();
//    }
}
