package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class dashboardPage {

    WebDriver driver;

    By dashboardTitle = By.id("item_4_title_link");
    By sortingDropdown = By.className("select_container");
    By item1Title = By.id("item_4_title_link");
    By item1AddButton = By.id("add-to-cart-sauce-labs-backpack");
    By item1RemoveButton = By.id("remove-sauce-labs-backpack");
    By cartButton = By.id("shopping_cart_container");
    By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    //*[@id="shopping_cart_container"]/a
    //By dropdownOptions = By.tagName("option");
    //By optionLocator = By.xpath("//option[@value='\" + value + \"']");


//    By valueAZ = By.xpath("//option[@value='az']");
//    By valueZA = By.xpath("//option[@value='za']");
//    By valueHilo = By.xpath("//option[@value='hilo']");
//    By valueLohi = By.xpath("//option[@value='lohi']");
    // nentuin item di urutan paling pertama

    public dashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public void isDisplayed() {
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(item1Title)
        );
        wait.until(
                ExpectedConditions.urlContains("https://www.saucedemo.com/inventory.html")
        );
        System.out.println("Dashboard page is displayed.");
    }

    public void clickSortingDropdown(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(sortingDropdown)
        );
        dropdown.click();
    }

    public void selectDropdownValue(String value){
        By optionLocator = By.xpath("//option[@value='" + value + "']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(optionLocator)
        );
        option.click();
    }

    public void clickItem1(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement option = wait.until(
                ExpectedConditions.elementToBeClickable(item1Title)
        );
        option.click();
    }

    public void clickItem1AddButton(){
        driver.findElement(item1AddButton).click();
    }

    public void buttonRemoveEnable(){
        driver.findElement(item1RemoveButton).isEnabled();
    }

    public void buttonItem1AddEnable(){
        driver.findElement(item1AddButton).isEnabled();
    }

    public void clickRemoveButonn(){
        driver.findElement(item1RemoveButton).click();
    }

    public void clickCartButton(){
        driver.findElement(cartButton).click();
    }

    public void cartBadgeEnabled(){
        driver.findElement(cartBadge).isEnabled();
    }

//    public boolean cartBadgeDisabled(){
//        return !driver.findElement(cartBadge).isEnabled();
//    }

//    public void selectValueAZ(){
//        driver.findElement(valueAZ).click();
//    }
//
//    public void selectValueZA(){
//        driver.findElement(valueZA).click();
//    }
//
//    public void selectValueHilo(){
//        driver.findElement(valueHilo).click();
//    }
//
//    public void selectValueLohi(){
//        driver.findElement(valueLohi).click();
//    }

}
