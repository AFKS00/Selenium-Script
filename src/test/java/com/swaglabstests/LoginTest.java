package com.swaglabstests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginTest extends BaseTest {

    @DataProvider(name = "csvCredentials")
    public Object[][] readCredentialsFromCsv() throws IOException, CsvValidationException {
        List<Object[]> data = new ArrayList<>();
        String file = "src/test/resources/credentials.csv";

        CSVReader reader = new CSVReader(new FileReader(file));
        String[] line;
        boolean isFirstLine = true;

        while ((line = reader.readNext()) != null) {
            if (isFirstLine) {
                isFirstLine = false; // Skip the header
                continue;
            }
            data.add(new Object[]{line[0], line[1]});
        }

        reader.close();
        return data.toArray(new Object[0][0]);
    }

    @Test(dataProvider = "csvCredentials")
    public void testHomePageLoadAfterLogin(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"), "Login failed or homepage not loaded.");
        System.out.println("Login successful for user: " + username);
    }
}
