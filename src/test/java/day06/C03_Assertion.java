package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Assertion {

    //1.Bir Class olusturalim YanlisEmailTesti
    //2.http://automationpractice.com/index.php sayfasina gidelim
    //3.Sign in butonuna basalim
    //4.Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    static WebDriver driver ;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.partialLinkText("Sign in")).click(); // sitede Signin kisminin onunde arkasinda bosluklar var o yuzden partiallinktext aldik.
    }
    @Test
    public void test() throws InterruptedException {
        WebElement emailInputBox = driver.findElement(By.id("email_create"));
        Thread.sleep(2000);
        emailInputBox.sendKeys("merhabaTelevole"+ Keys.ENTER);

        WebElement invalidEmail = driver.findElement(By.id("create_account_error"));

        Assert.assertTrue("Invalid Email yazisi cikmadi",emailInputBox.isDisplayed());
    }
    @AfterClass
    public static void tearDrop(){

        driver.close();

    }


}
