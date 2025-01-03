package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    By totalTitle = By.xpath("//h2[@data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getTotalTitle(){
        return driver.findElement(totalTitle).getText();
    }
}
