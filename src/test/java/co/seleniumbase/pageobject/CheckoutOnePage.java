package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOnePage extends BasePage {



    By firstNameInput = By.id("first-name");
    By lastNameInput = By.id("last-name");
    By zipCodeInput = By.id("postal-code");
    By continueButton = By.id("continue");

   public CheckoutOnePage(WebDriver driver){
       super(driver);
   }

   public void setCheckoutPage(String firstName, String lastName, String zipCode){

       driver.findElement(firstNameInput).sendKeys(firstName);
       driver.findElement(lastNameInput).sendKeys(lastName);
       driver.findElement(zipCodeInput).sendKeys(zipCode);
       driver.findElement(continueButton).click();

   }

}
