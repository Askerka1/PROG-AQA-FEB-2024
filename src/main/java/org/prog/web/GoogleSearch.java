package org.prog.web;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.21vek.by/");

            List<WebElement> cookieButtons =
                    driver.findElements(By.xpath(
                            "//button[contains(@class,'Button-module__button Button-module__blue-primary')]"));

            if (!cookieButtons.isEmpty()) {
                cookieButtons.get(0).click();
            }

            WebElement searchInput = driver.findElement(By.xpath("//input[contains(@class,'Search_searchInput__RoV1W')]"));
            searchInput.sendKeys("Iphone 15");
            searchInput.sendKeys(Keys.ENTER);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            List<WebElement> searchTitles =
                    wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//span[contains(@class,'result__name')]"),5));
                System.out.println(searchTitles.get(0).getText());

        }finally {
            driver.quit();

        }
    }
}
