package com.swaglabstests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutProcess() {
        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add first product
        driver.findElement(By.className("btn_inventory")).click();

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        // Confirmation
        WebElement confirmation = driver.findElement(By.className("complete-header"));
        Assert.assertTrue(confirmation.isDisplayed(), "Order not completed.");
        System.out.println("Order confirmation message: " + confirmation.getText());
    }
}
