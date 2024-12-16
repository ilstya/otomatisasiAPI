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
    @Step("Testing Google Search")
    public void testGoogleSearch() {
        driver.get("https://www.google.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("Selenium WebDriver\n");
        String title = driver.getTitle();
        System.out.println("Page title: " + title); // Debugging
        assertTrue(title.contains("Selenium WebDriver"), "Expected title to contain 'Selenium WebDriver'");
    }
}
