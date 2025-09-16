package com.test.selenium.ex07_WaitHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
WaitHelpers Function Summary
|------------------------------------------------------|-------------------------------------------------------------------------|
| Function Name                                        | Description                                                             |
|------------------------------------------------------|-------------------------------------------------------------------------|
| waitJVM(int timeInMillis)                            | Pauses execution using Thread.sleep.                                   |
| waitImplicit(WebDriver, int)                         | Sets implicit wait for locating elements.                              |
| checkVisibility(WebDriver, By, int)                  | Waits explicitly for an element to be visible with custom timeout.     |
| checkVisibility(WebDriver, By)                       | Same as above, but uses default timeout of 10 seconds.                 |
| checkVisibilityOfAndText(WebDriver, WebElement, String) | Waits for element visibility and specific text to appear.           |
| waitForVisibility(WebDriver, int, String)            | Waits for visibility of element using XPath.                           |
| waitFluentVisibility(WebDriver, int, int, String)    | Uses FluentWait to wait for visibility with polling and exception      |
                                                                                                                      handling. |
| waitUntilClickable(WebDriver, By, int)               | Waits until element is clickable.                                      |
| waitUntilPresent(WebDriver, By, int)                 | Waits until element is present in the DOM.                             |
| waitUntilInvisible(WebDriver, By, int)               | Waits until element becomes invisible.                                 |
| waitUntilUrlContains(WebDriver, String, int)         | Waits until current URL contains a specific substring.                 |
| waitUntilTitleIs(WebDriver, String, int)             | Waits until page title matches expected title.                         |
|------------------------------------------------------|-------------------------------------------------------------------------|
 */
public class WaitHelpers {

    // Pause execution using Thread.sleep
    public static void waitJVM(int timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // Set implicit wait
    public static void waitImplicit(WebDriver driver, int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    // Explicit wait for visibility with custom timeout
    public static void checkVisibility(WebDriver driver, By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Explicit wait for visibility with default timeout
    public static void checkVisibility(WebDriver driver, By locator) {
        checkVisibility(driver, locator, 10);
    }

    // Wait for visibility and specific text in element
    public static void checkVisibilityOfAndText(WebDriver driver, WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    // Wait for visibility using XPath
    public static void waitForVisibility(WebDriver driver, int timeInSeconds, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    // Fluent wait for visibility using XPath
    public static WebElement waitFluentVisibility(WebDriver driver, int maxTime, int pollingTime, String xpath) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        return wait.until(driver1 -> driver1.findElement(By.xpath(xpath)));
    }

    // Wait for element to be clickable
    public static WebElement waitUntilClickable(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for element to be present in DOM
    public static WebElement waitUntilPresent(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for element to become invisible
    public static boolean waitUntilInvisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for URL to contain a specific string
    public static boolean waitUntilUrlContains(WebDriver driver, String partialUrl, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // Wait for page title to match expected title
    public static boolean waitUntilTitleIs(WebDriver driver, String expectedTitle, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.titleIs(expectedTitle));
    }
}