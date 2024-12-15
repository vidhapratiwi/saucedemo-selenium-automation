package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class loginPage {

    WebDriver driver;

    //elements
    By loginTitle = By.xpath(("//div[text()='Swag Labs']"));
    By usernameTextBox = By.xpath("//*[@id='user-name']");
    By passwordTextBox = By.xpath("//*[@id='password']");
    By loginButton = By.xpath("//*[@id='login-button']");
    By errorMessage = By.xpath(("//div[@class='error-message-container error']"));

    public loginPage(WebDriver driver) { this.driver = driver; }
    public void isDisplayed() {
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(loginTitle)
        );
    }

    public void inputUsername(String username) {
        driver.findElement(usernameTextBox).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void showErrorMessage() {
        driver.findElement(errorMessage).isDisplayed();
    }

    public void login(){
        driver.findElement(usernameTextBox).sendKeys("standard_user");
        driver.findElement(passwordTextBox).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }

}

