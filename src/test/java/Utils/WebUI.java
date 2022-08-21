package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;


public class WebUI {
    private static WebDriver driver;
    private static int TIMEOUT = 10;
    private static double sleep_seconds = 0;

//    public WebUI(WebDriver driver) {
//        WebUI.driver = driver;
//    }

    public WebUI(WebDriver driver) {
        WebUI.driver = driver; //vi object driver la static nen ko dung this.driver duoc
        //this.driver = driver;
    }

    public static void navigateToURL(String URL) {
        driver.get(URL);
        sleep(sleep_seconds);
        logConsole("Open: " + URL);
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (1000 * seconds));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static void setTexts(By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)); // Default: 10s
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(sleep_seconds);
        driver.findElement(by).sendKeys(value);
        sleep(sleep_seconds);
        logConsole("Set text on: " + by + " with value: " + value);
    }

    public static String getElementTexts(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)); // Default: 10s
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(sleep_seconds);
        logConsole("Get texts of: " + by);
        String text = driver.findElement(by).getText();
        logConsole("Returned Texts: " + text);
        return text;
    }

    public  void waitForElementClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)); // Default: 10s
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementClickable(By by, long TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clickElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        sleep(sleep_seconds);
        driver.findElement(by).click();
        sleep(sleep_seconds);
        logConsole("Click element: " + by);
    }

    public static void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)); // Default: 10s
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by, long TIMEOUT) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
