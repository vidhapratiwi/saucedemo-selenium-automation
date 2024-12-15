package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class completePage {

    WebDriver driver;

    By completeTitle = By.xpath("//*[@data-test='title' and text()='Checkout: Complete!']");
    By completeContainer = By.id("checkout_complete_container");
    By backButton = By.id("back-to-products");

    public completePage(WebDriver driver){this.driver = driver;}

    public void isDisplayed(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(completeTitle)
        );

        System.out.println("Checkout: Complete is displayed.");
    }

    public void showSuccessMessage(){
        driver.findElement(completeContainer).isDisplayed();
    }

    public void clickButtonBackHome(){
        driver.findElement(backButton).click();
    }


}
