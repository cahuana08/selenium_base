package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage {


    By username = By.id("user-name");
    By passwordInput = By.id("password");
    By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void loginInput(String userName, String password){
        driver.findElement(username).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
