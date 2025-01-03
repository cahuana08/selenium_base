package co.seleniumbase.pagecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product extends BaseComponent{

    public Product(WebElement root) {
        super(root);
    }

    public String getName(){
        return root.findElement(By.className("inventory_item_name")).getText();
    }

    public BigDecimal getPrice(){
        return new BigDecimal(
                root.findElement(By.className("inventory_item_price")).
                        getText().replace("$", "")).setScale(2, RoundingMode.UNNECESSARY);

    }

    public void remove(){
        root.findElement(By.id("remove"));
    }

    public void addToCart(){
        root.findElement(By.xpath("//button[contains(@id,'add-to-cart')]")).click();

    }


}
