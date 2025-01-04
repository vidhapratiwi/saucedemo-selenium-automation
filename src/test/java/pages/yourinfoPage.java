package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class yourinfoPage {
    WebDriver driver;

    By infoTitle = By.xpath("//*[@data-test='title' and text()='Checkout: Your Information']");
    By firstNameTextbox = By.id("first-name");
    By lastNameTextbox = By.id("last-name");
    By postalCodeTextbox = By.id("postal-code");
    By continueButton = By.id("continue");
    By errorMessage =  By.xpath("//div[contains(@class, 'error-message-container')]");
    By cancelButton = By.id("cancel");

    public yourinfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public void isDisplayed(){
        Duration duration = Duration.ofSeconds(20);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(infoTitle)
        );

        System.out.println("Checkout: Your Information is displayed.");
    }

    public void inputFirstName() {
        driver.findElement(firstNameTextbox).sendKeys("moa");
    }

    public void inputLastName() {
        driver.findElement(lastNameTextbox).sendKeys("ina");
    }

    public void inputPostalCode() {
        driver.findElement(postalCodeTextbox).sendKeys("43299");
    }

    public void clickContinue(){
        driver.findElement(continueButton).click();
    }

    public void showErrorMessage() {
        driver.findElement(errorMessage).isDisplayed();
    }

    //without bdd
    public void fillInformationForm() {
        driver.findElement(firstNameTextbox).sendKeys("moa");
        driver.findElement(lastNameTextbox).sendKeys("ina");
        driver.findElement(postalCodeTextbox).sendKeys("43299");
        driver.findElement(continueButton).click();
    }

    //coba baru
    public void enterFirstName(String firstName){
        driver.findElement(firstNameTextbox).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        driver.findElement(lastNameTextbox).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode){
        driver.findElement(postalCodeTextbox).sendKeys(zipCode);
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    //-----------------\\

    public void clickCancel(){
        driver.findElement(cancelButton).click();
    }

}

