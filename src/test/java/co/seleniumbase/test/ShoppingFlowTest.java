package co.seleniumbase.test;

import co.seleniumbase.hook.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingFlowTest extends BaseTest {


 @Test

    public void shoppingTest (){



       WebElement username = driver.findElement(By.id("user-name"));
       WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginButton.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();


        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));

        firstNameInput.sendKeys("Leidy");
        lastNameInput.sendKeys("Rios");
        zipCodeInput.sendKeys("50001");
        continueButton.click();


        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement title = driver.findElement(By.xpath("//h2[@data-test ='complete-header']"));

        Assert.assertEquals(title.getText(),"Thank you for your order!");
    }

}
