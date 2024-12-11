import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    WebDriver webDriver = new ChromeDriver();


    @Test
    public  void openBrowser(){

        //cofiguracion expera implicita
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // abrir una url especifica
        webDriver.get("https://www.saucedemo.com/");


        // configuracion del navegador maximizar
        webDriver.manage().window().maximize();

        //webDriver.findElement(By.id("login_button_container")).findElement(By.xpath("//input[@placeholder='Username']"))

        webDriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        webDriver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        webDriver.findElement(By.name("login-button")).click();

        String nombreLogo =  webDriver.findElement(By.className("app_logo")).getText();

        Assert.assertEquals(nombreLogo,"Swag Labs");

    }

    @Test
    public void elementsTest(){
        //cofiguracion expera implicita
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // abrir una url especifica
        webDriver.get("https://www.saucedemo.com/");


        // configuracion del navegador maximizar
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));


        WebElement usernameInput = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput =  webDriver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement loginButton =   webDriver.findElement(By.name("login-button"));

        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        String nombreLogo =  webDriver.findElement(By.className("app_logo")).getText();
        Assert.assertEquals(nombreLogo,"Swag Labs");

        webDriver.close();
        webDriver.quit();
    }

     @Test
    public void  getElementsTest(){
        //cofiguracion expera implicita
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // abrir una url especifica
        webDriver.get("https://www.saucedemo.com/");


        // configuracion del navegador maximizar
        webDriver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));


        WebElement usernameInput = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordInput =  webDriver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement loginButton =   webDriver.findElement(By.name("login-button"));

        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        List<WebElement> productList = webDriver.findElements(By.xpath("//div[@data-test='inventory-list']/div[@data-test='inventory-item']"));

        for(WebElement element:productList){
            String elementTitle = element.findElement(By.xpath(".//div[@data-test='inventory-item-name']")).getText();
            System.out.println(elementTitle);
        }

    }

}
