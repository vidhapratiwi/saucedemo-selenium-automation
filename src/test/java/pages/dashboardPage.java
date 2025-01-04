package pages;

import org.openqa.selenium.*;
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

    By sidebarMenu = By.xpath("//*[@id='react-burger-menu-btn']");
    By sidebarAllItems = By.xpath("//*[@id='inventory_sidebar_link']");
    By sidebarAbout = By.xpath("//*[@id='about_sidebar_link']");
    By sidebarLogout = By.xpath("//*[@id='logout_sidebar_link']");
    By sidebarResetAppState = By.xpath("//*[@id='reset_sidebar_link']");

    By footer = By.xpath("//*[@data-test='footer']");
    By twitterLink = By.xpath("//*[@data-test='social-twitter']");
    By facebookLink = By.xpath("//*[@data-test='social-facebook']");
    By linkedinLink = By.xpath("//*[@data-test='social-linkedin']");

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

    public void clickSideBarMenu(){
        driver.findElement(sidebarMenu).click();
    }

    public void clickLogout(){
        driver.findElement(sidebarLogout).click();
    }

    //---------------------------sidebar menus------------------------
    public void clickSidebarMenu(){
        driver.findElement(sidebarMenu).click();
    }

    public void validateSidebarMenu(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(sidebarMenu)
        );
    }

    public void clickAllItems(){
        driver.findElement(sidebarAllItems).click();
    }

    public void validateAllItems(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(item1Title)
        );
    }

    public void clickSidebarAbout(){
        driver.findElement(sidebarAbout).click();
    }

    public void validateSidebarAbout(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.urlToBe("https://saucelabs.com/")
        );
    }

    public void cartBadgeEnabled(){
        driver.findElement(cartBadge).isEnabled();
    }

    public void clickResetAppState(){
        driver.findElement(sidebarResetAppState).click();
    }

    public void cartBadgeDisabled(){
        boolean isDisabled = !driver.findElement(cartBadge).isEnabled();
        System.out.println("Is " + isDisabled);
    }

    public void removeButtonDisabled(){
        boolean isDisabled = !driver.findElement(item1RemoveButton).isEnabled();
        System.out.println("Is " + isDisabled);
    }

    //-----------------------End sidebar menus-------------------------------


    //-------------------------footer---------------------------------------
//
//    public void clickTwitter(){
//        driver.findElement(twitterLink).click();
//    }
//
//    public void clickFacebook(){
//        driver.findElement(facebookLink).click();
//    }
//
//    public void clickLinkedin(){
//        driver.findElement(linkedinLink).click();
//    }
//
//    public void validateTwitterPage(){
//        Duration duration = Duration.ofSeconds(10);
//        WebDriverWait wait = new WebDriverWait(driver, duration);
//        wait.until(
//                ExpectedConditions.urlToBe("https://x.com/saucelabs")
//        );
//    }
//
//    public void validateFacebookPage(){
//        Duration duration = Duration.ofSeconds(10);
//        WebDriverWait wait = new WebDriverWait(driver, duration);
//        wait.until(
//                ExpectedConditions.urlToBe("https://www.facebook.com/saucelabs")
//        );
//    }
//
//    public void validateLinkedinPage(){
//        Duration duration = Duration.ofSeconds(10);
//        WebDriverWait wait = new WebDriverWait(driver, duration);
//        wait.until(
//                ExpectedConditions.urlToBe("https://www.linkedin.com/company/sauce-labs/")
//        );
//    }

    //masih failed di step terakhir
    public void clickFooterLink(String linkName) {
        switch (linkName.toLowerCase()){
            case "twitter":
                driver.findElement(twitterLink).click();
                break;
            case "facebook":
                driver.findElement(facebookLink).click();
                break;
            case "linkedin":
                driver.findElement(linkedinLink).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid link name: "+linkName);
        }
        System.out.println("Clicked on " + linkName + " link");
    }

    public void validateRedirectURL(String expectedURL){
        Duration duration = Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        //switch to new tab
        for (String windowHandle : driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }

        //validate url in new tab
        wait.until(ExpectedConditions.urlContains(expectedURL));
        System.out.println("Current URL: " + driver.getCurrentUrl());

    }


    //----------------------------End footer---------------------------------------

    //-----------------------scroll page--------------------------------

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
