package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeClass {

    // amazon sayfasına gidip 3 farkli test methodu hazirlayin.
    // her method'da farkli aramalar yapalim.
    // JUNIT de siralama belirsizdir.

    // before class her seferinde asagidaki methodu cagirarak her seferinde webdriver manager yazmama gerek yok.
    // Webdriver test1 de calinmaz scope icinde gecerli oldugu icin.Before class her zaman Static olmali.
    static WebDriver driver;
    WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

    }
    @Test
    public void test1(){

        searchBox.clear();
        searchBox.sendKeys("nutella"+ Keys.ENTER);



    }
    @Test
    public void test2(){
        searchBox.clear();
        searchBox.sendKeys("bycycle"+ Keys.ENTER);



    }

    @Test
    public void test3(){
        searchBox.clear();
        searchBox.sendKeys("java"+ Keys.ENTER);

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }


}
/*
==================================================================================
OZET:
ANNOTATION BeforeClass YAPARAK CLASS CALISTIRILMADAN ONCE YAPILACAK ISLERI SETUP METHODUNA YAPTIRILARAK TUM TEST METHODLARINDA KULLANILMASINI SAGLADIK.

TUM TEST METHODLARINDA BeforeClass setup() methodlarini kullandik.

driver objesi method inline scope oldugu icin diger test methodlarinda kullanilamadi.

ardından AfterClass annotation da artik tum testler bitti ve yapilacak isler kaldi. onlari kapatmada kullandik.

before ve after Class lar static olmali.
==================================================================================


 */