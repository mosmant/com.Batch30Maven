package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Before_After {

    // 3 adet test methodu yapiniz
    //  1. method amazan.com'a
    //  2. method techproeducation.com
    //  3. method ise facebook.com'a gitsin

    // eger her test methodu icin yeni bir sayfa acilsin ve test methodu sonunda kapansin istiyorsak @before ve @after annotation kullanilmali.
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void amazonTesti(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }
    @Test
    public void techproTesti(){
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void facebookTesti(){
        driver.get("https://www.facebook.com");
    }
    @After
    public void tearDown(){
        driver.close();
    }



}
/*
=============================
OZET J UNIT ICIN STATIC KULLANIMI BEFORE VE AFTER CLASS TA KULLANILIR
BEFORE DA VE AFTER DA KULLANILMAZ.
AYRICA 3 TEST OLAN BEFORE VE AFTER CLASS OLAN TESTTE 5 DEFA METHOD CALISIR. ONCE BEFORE CLASS CALISIR ARDINDAN 3 TEST CALISIR ARDINDAN AFTER CLASS CALISIR.
AFTER VE BEFORE ANNOTATION DA 3 TEST OLAN TESTTE TOPLAMDA 9 ADET METHOD CALISIR. BURADA HER TEST ICIN (AFTER>TEST>BEFORE ) X 3 DEFA CALISIR. 9 METHOD BU YUZDEN CALISIR.


 */