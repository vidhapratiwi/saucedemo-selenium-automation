package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class productPage {

    WebDriver driver;

    By item1Name = By.xpath("//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']");
    By item1Picture = By.xpath("//img[@data-test='item-sauce-labs-backpack-img']");
    By item1Price =  By.xpath("//div[@data-test='inventory-item-price']");
    By addToCartButton = By.id("add-to-cart");
    By backToProduct = By.id("back-to-products");
    By removeButton = By.id("remove");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    public productPage(WebDriver driver){
        this.driver = driver;
    }

    public void isDisplayed(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(backToProduct)
        );
        wait.until(
                ExpectedConditions.urlContains("https://www.saucedemo.com/inventory-item.html?id=4")
        );
        System.out.println("Product page is displayed.");
    }

    public void isDisplayingProductDetails(){
        String item1NameDisplayed = driver.findElement(item1Name).getText();
        Assert.assertEquals("Sauce Labs Backpack", item1NameDisplayed);
        driver.findElement(item1Picture).isDisplayed();
        driver.findElement(item1Price).isDisplayed();
        driver.findElement(addToCartButton).isDisplayed();
    }

    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void clickRemoveButton(){
        driver.findElement(removeButton).click();
    }

    public void validateRemoveButtonDisplayed(){
        driver.findElement(removeButton).isDisplayed();
    }

    public void validateCartBadgeDisplayed(){
        driver.findElement(cartBadge).isDisplayed();
    }

    public boolean validateCartBadgeHidden(){
        List<WebElement> badges;
        badges = driver.findElements(cartBadge);
        return badges.isEmpty();
    }

    public void validateAddToCartButton(){
        driver.findElement(addToCartButton).isDisplayed();
    }


}
