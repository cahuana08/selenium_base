package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import co.seleniumbase.pagecomponent.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    By cartButton = By.className("shopping_cart_link");
    By productAdded = By.id("add-to-cart-sauce-labs-backpack");
    By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart(){
        driver.findElement(cartButton).click();
    }

    public String getProductAdded(){
        return driver.findElement(productAdded).getText();
    }


    public void goToCheckout(){
        driver.findElement(checkoutButton).click();
    }

    public List<Product> getListProductsCart() {
        List<WebElement> productListWebElements = new ArrayList<>();
        List<Product> productListComponent = new ArrayList<>();
        productListWebElements = driver.findElements(By.xpath("//div[@class = 'cart_item_label']"));

        for (WebElement product : productListWebElements) {
            productListComponent.add(new Product(product));
        }

        return productListComponent;

    }

    public List<Product> getListProductsListCart(List<String> nameProductsList) {
        List<Product> productListComponent = getListProductsCart();
        List<Product> productListFinal = new ArrayList<>();

        for (Product product : productListComponent) {
            //nameProduct es el indice de la lista
            for (String nameProduct : nameProductsList) {

                if (product.getName().equals(nameProduct)) {
                    productListFinal.add(product);
                }
            }

        }
        return productListFinal;
    }
}
