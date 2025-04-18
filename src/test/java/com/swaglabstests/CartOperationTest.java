package com.swaglabstests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartOperationTest extends BaseTest {

    @Test
    public void testAddToCart() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Apply Low to High filter
        driver.findElement(By.className("product_sort_container")).sendKeys("Price (low to high)");

        // Add first product
        WebElement firstAddButton = driver.findElements(By.className("btn_inventory")).get(0);
        firstAddButton.click();

        // Go to cart and check item
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement cartItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue(cartItem.isDisplayed(), "Item not added to cart");
    }
}
