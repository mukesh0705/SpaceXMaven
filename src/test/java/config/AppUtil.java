package config;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppUtil {
	public static WebDriver driver;
    //public static WebDriverWait wait;
    
    @BeforeTest
    public void setup() {
        Reporter.log("=====Browser Session Started=====", true);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.spacex.com/");
    }

    @AfterTest
    public void close() {
        driver.quit();
        Reporter.log("=====Browser Session End=====", true);

    }

}
