package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage extends BasePage {

    By itemTitle = By.xpath("//div[@data-test='subtotal-label']");
    By taxTitle = By.xpath("//div[@data-test='tax-label']");
    By totalTitle = By.xpath("//div[@data-test='total-label']");
    By finishButton = By.id("finish");


    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }


    public String getItemTitle(){
        return driver.findElement(itemTitle).getText();
    }

    public String getTaxTitle(){
        return driver.findElement(taxTitle).getText();
    }

    public String getTotalTitle(){
        return driver.findElement(totalTitle).getText();
    }

    public void setFinishButton(){
        driver.findElement(finishButton).click();
    }


}
