package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class yourcartPage {

    WebDriver driver;

    By cartTitle = By.xpath("//*[@data-test='title' and text()='Your Cart']");
    By itemName = By.xpath("//*[@data-test='inventory-item-name']");
    By item1RemoveButton = By.id("remove-sauce-labs-backpack");
    By cartItem = By.xpath("//div[@class='cart_item']");
    By checkoutButton = By.id("checkout");
    By errorMessage =  By.xpath(("//div[@class='error-message-container error']"));

    public yourcartPage(WebDriver driver){
        this.driver = driver;
    }

    public void isDisplayed(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(cartTitle)
        );

        System.out.println("Cart page: Your Cart is displayed.");
    }

    //masih salah disini
    public void itemOnCartIsDisplayed(){
        String itemNameDisplayed = driver.findElement(itemName).getText();
        Assert.assertEquals("Sauce Labs Backpack", itemNameDisplayed);
    }

    public void clickRemoveButton(){
        driver.findElement(item1RemoveButton).click();
    }

    //belum nemu caranya
//    public void cartItemHidden(){
//        driver.findElement(cartItem).
//    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }

    public void showErrorMessage() {
        driver.findElement(errorMessage).isDisplayed();
    }


}
