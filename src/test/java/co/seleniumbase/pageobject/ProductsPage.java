package co.seleniumbase.pageobject;

import co.seleniumbase.hook.BaseTest;
import co.seleniumbase.pagecomponent.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends BasePage {

    By addToCartButtonProduct = By.id("add-to-cart-sauce-labs-backpack");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void setAddToCartButton() {
        driver.findElement(addToCartButtonProduct).click();
    }

    public List<Product> getListProducts() {
        List<WebElement> productListWebElements = new ArrayList<>();
        List<Product> productListComponent = new ArrayList<>();
        productListWebElements = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));

        for (WebElement product : productListWebElements) {
            productListComponent.add(new Product(product));
        }

        return productListComponent;

    }

    public Product getProduct(String nameProduct) {
        List<Product> productListComponent = getListProducts();

        for (Product product : productListComponent) {
            if (product.getName().equals(nameProduct)) {
                return product;
            }
        }

        throw new NoSuchElementException("Product No found" + nameProduct);

    }

    public List<Product> getListProductsList(List<String> nameProductsList) {
        List<Product> productListComponent = getListProducts();
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


    public void selectProducts(List<String> nameProductsList){
        ;

        for(Product product: getListProductsList(nameProductsList)){

            product.addToCart();
        }

    }
}