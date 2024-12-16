package Webtest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import Utils.BaseTest;

import java.time.Duration;

//import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTest extends BaseTest {

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver\n");

        // Tunggu hingga halaman hasil pencarian termuat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));

        // Debugging log
        String title = driver.getTitle();
        System.out.println("Current page title: " + title);

        // Assertion
        assertTrue(title.contains("Selenium WebDriver"), "Expected title to contain 'Selenium WebDriver'");
    }
}
