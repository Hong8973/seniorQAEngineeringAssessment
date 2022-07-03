package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

/*
This class contains re-usable methods and page objects, applicable to any page
 */

public class Common {

    public static WebDriver driver = initDriver();

    public static WebDriver initDriver(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }



    public WebDriver getDriver(){
        return driver;
    }

    public void openURL(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void closeBrowser(){
        driver.quit();
    }

    public WebElement waitForElement(String xpath, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public List<WebElement> waitForElements(String xpath, int waitTime){
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public boolean isElementPresent(WebElement element) {
        try {
            return (element.isDisplayed());
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}
