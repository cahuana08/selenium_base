package co.seleniumbase.test;

import co.seleniumbase.hook.BaseTest;
import co.seleniumbase.pagecomponent.Product;
import co.seleniumbase.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingPOM extends BaseTest {

    @Test

    public void shoppingSuccess(){
        //siempre que se instancia un objeto se utiliza new
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput("standard_user","secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        //se crean variables de cualquier clase
        Product productos = productPage.getProduct("Sauce Labs Backpack");
        productos.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.goToCheckout();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        checkoutOnePage.setCheckoutPage("Leidy", "Rios", "50001");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.setFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualResult = checkoutCompletePage.getTotalTitle();

        Assert.assertEquals(actualResult,"Thank you for your order!");

    }
    @Test
    public void shoppingListSuccess(){
        //siempre que se instancia un objeto se utiliza new
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput("standard_user","secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        //se crean variables de cualquier clase
        List<String> listaNameProducts = new ArrayList<>();
        listaNameProducts.add("Sauce Labs Backpack");
        listaNameProducts.add("Sauce Labs Bike Light");
        listaNameProducts.add("Sauce Labs Bolt T-Shirt");
        //cuando el metodo es void y no devuelve nada simplemente se llama desde donde se realizò
        productPage.selectProducts(listaNameProducts);


        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.goToCheckout();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        checkoutOnePage.setCheckoutPage("Leidy", "Rios", "50001");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.setFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualResult = checkoutCompletePage.getTotalTitle();

        Assert.assertEquals(actualResult,"Thank you for your order!");

    }


    @Test
    public void shoppingListPriceSuccess(){
        //siempre que se instancia un objeto se utiliza new
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput("standard_user","secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        //se crean variables de cualquier clase
        List<String> listaNameProducts = new ArrayList<>();
        listaNameProducts.add("Sauce Labs Backpack");
        listaNameProducts.add("Sauce Labs Bike Light");
        listaNameProducts.add("Sauce Labs Bolt T-Shirt");
        //cuando el metodo es void y no devuelve nada simplemente se llama desde donde se realizò
        List<Product> listaProductos = productPage.getListProductsList(listaNameProducts);
        listaProductos.get(0).addToCart();
        listaProductos.get(1).addToCart();
        listaProductos.get(2).addToCart();

        BigDecimal price1 = listaProductos.get(0).getPrice();
        BigDecimal price2 = listaProductos.get(1).getPrice();
        BigDecimal price3 = listaProductos.get(2).getPrice();


       /* CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.goToCheckout();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        checkoutOnePage.setCheckoutPage("Leidy", "Rios", "50001");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.setFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualResult = checkoutCompletePage.getTotalTitle();

        Assert.assertEquals(actualResult,"Thank you for your order!");*/

    }

    @Test
    public void shoppingListPriceFromCart(){
        //siempre que se instancia un objeto se utiliza new
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInput("standard_user","secret_sauce");

        ProductsPage productPage = new ProductsPage(driver);
        //se crean variables de cualquier clase
        List<String> listaNameProducts = new ArrayList<>();
        listaNameProducts.add("Sauce Labs Backpack");
        listaNameProducts.add("Sauce Labs Bike Light");
        listaNameProducts.add("Sauce Labs Bolt T-Shirt");
        //cuando el metodo es void y no devuelve nada simplemente se llama desde donde se realizò
        List<Product> listaProductos = productPage.getListProductsList(listaNameProducts);
        listaProductos.get(0).addToCart();
        listaProductos.get(1).addToCart();
        listaProductos.get(2).addToCart();

       String name1 = listaProductos.get(0).getName();
       String name2 = listaProductos.get(1).getName();
       String name3 = listaProductos.get(2).getName();

        BigDecimal price1 = listaProductos.get(0).getPrice();
        BigDecimal price2 = listaProductos.get(1).getPrice();
        BigDecimal price3 = listaProductos.get(2).getPrice();


       CartPage cartPage = new CartPage(driver);
       cartPage.goToCart();
        List<Product> listaProductosCart = cartPage.getListProductsListCart(listaNameProducts);
        String nameCart1 = listaProductosCart.get(0).getName();
        String nameCart2 = listaProductosCart.get(1).getName();
        String nameCart3 = listaProductosCart.get(2).getName();

        BigDecimal priceCart1 = listaProductosCart.get(0).getPrice();
        BigDecimal priceCart2 = listaProductosCart.get(1).getPrice();
        BigDecimal priceCart3 = listaProductosCart.get(2).getPrice();

        Assert.assertEquals(name1, nameCart1);
        Assert.assertEquals(name2, nameCart2);
        Assert.assertEquals(name3, nameCart3);
        Assert.assertEquals(price1, priceCart1);
        Assert.assertEquals(price2, priceCart2);
        Assert.assertEquals(price3, priceCart3);


        /*cartPage.goToCheckout();

        CheckoutOnePage checkoutOnePage = new CheckoutOnePage(driver);
        checkoutOnePage.setCheckoutPage("Leidy", "Rios", "50001");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.setFinishButton();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        String actualResult = checkoutCompletePage.getTotalTitle();

        Assert.assertEquals(actualResult,"Thank you for your order!");*/

    }

}
