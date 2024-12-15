package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class overviewPage {

    WebDriver driver;

    By overviewTitle = By.xpath("//*[@data-test='title' and text()='Checkout: Overview']");
    By overviewItem = By.xpath("//*[@data-test='inventory-item']");
    By finishButton = By.id("finish");

    public overviewPage(WebDriver driver){
        this.driver = driver;
    }

    public void isDisplayed(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(overviewTitle)
        );

        System.out.println("Checkout: Overview is displayed.");
    }

    public void itemIsDisplayed(){
        driver.findElement(overviewItem).isDisplayed();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }


}
