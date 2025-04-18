package com.swaglabstests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class ProductFilterTest extends BaseTest {

    @Test
    public void testProductFilterLowToHigh() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Apply filter
        WebElement filter = driver.findElement(By.className("product_sort_container"));
        filter.sendKeys("Price (low to high)");

        // Get product names
        List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
        System.out.println("Products sorted by price (Low to High):");
        for (WebElement product : productNames) {
            System.out.println(product.getText());
        }
    }
}

