package org.example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppTest {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(05));

    }

    @Test
    public void TrendyolOdev() throws InterruptedException {

        driver.get("https://www.trendyol.com/");

        WebElement element = driver.findElement(By.xpath("//img[@alt=\"Male\"]"));
        element.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class=\"account-nav-item user-login-container\"]")))
                .build().perform();

        WebElement grsekrani = driver.findElement(By.xpath("//div[@class=\"login-button\"]"));
        grsekrani.click();

        WebElement email = driver.findElement(By.id("login-email"));
        email.sendKeys("iibrahimarpacii@gmail.com");

        WebElement sifre = driver.findElement(By.id("login-password-input"));
        sifre.sendKeys("Ibrahim5.");

        WebElement grsbtn = driver.findElement(By.xpath("//button[@class=\"q-primary q-fluid q-button-medium q-button submit\"]"));
        grsbtn.click();

        WebElement arama = driver.findElement(By.xpath("//input[@class=\"search-box\"]"));
        arama.sendKeys("kazak" + Keys.ENTER);


        List<WebElement> items = driver.findElements(By.cssSelector(".p-card-wrppr"));
        items.get(3).click();

        driver.findElement(By.xpath("//div[@class=\"product-button-container\"]")).click();

    }
}
