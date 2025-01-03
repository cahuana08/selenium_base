package co.seleniumbase.pagecomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseComponent{

    public Cart(WebElement root) {
        super(root);
    }

    public String getNameCart(){
        return root.findElement(By.xpath("//div[@data-test='inventory-item']")).getText();
    }

    public BigDecimal getPriceCart(){
        return new BigDecimal(
                root.findElement(By.className("inventory_item_price")).
                        getText().replace("$", "")).setScale(2, RoundingMode.UNNECESSARY);

    }

    public void removeCart(){
        root.findElement(By.xpath("//button[contains(@name.,'remove')]")).click();
    }




}
