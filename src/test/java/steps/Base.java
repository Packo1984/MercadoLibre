package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class Base {
    public WebDriver driver=null;
    public Base(WebDriver driver){
        this.driver=driver;
    }

    public Base() {
    }



    public WebDriver chromeDriverConetion(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver= new ChromeDriver();

        return driver;
    }

    public  void type(String inputText, By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(inputText);

        //driver.findElement(locator).sendKeys(inputText);
    }

    public void Click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void clicleable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }


    public void visit(String url){
        driver.get(url);
    }


}

