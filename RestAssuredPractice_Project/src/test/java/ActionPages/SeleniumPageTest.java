package ActionPages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.Locale;

public class SeleniumPageTest {

//    public static Durationn time= Duration.ofSeconds(10);
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://accounts.google.com/signin");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("dkumar@payfare.com");
        driver.findElement(By.id("identifierNext")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Passwd']"))).sendKeys("Arjun941995@");
        driver.findElement(By.id("passwordNext")).click();
//        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("dummy")));
        Thread.sleep(30000);
        System.out.println(driver.getTitle());
    }
}
