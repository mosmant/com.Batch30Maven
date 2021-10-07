package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_Test01 {
    public static void main(String[] args) {
        // 1-Test01 isimli bir class olusturun
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // 2- https://www.walmart.com/ adresine gidin
        driver.get("https://www.walmart.com/");
        // 3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // 4-Sayfayi “refresh” yapin
        // driver.navigate().refresh();
        // 5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        String expectedTitle = "Save";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title "+ expectedTitle +" kelimesini iceriyor.. TEST PASS");
        }else{
            System.out.println("Title "+ expectedTitle +" kelimesini icermiyor.. TEST FAILED");
        }



        // 6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        String expectedTitleFull = "Walmart.com | Save Money.Live Better";
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Sayfa title i beklenen ile ayni TEST PASS");

        }else  {
            System.out.println("Sayfa title i beklenen ile ayni degil TEST FAILED");
            System.out.println("actual title:"+ actualTitle);
        }

        // 7- URL in walmart.com icerdigini control edin
        String actualURL = driver.getCurrentUrl();
        String URLarananKelime = "walmart.com";
        if (actualURL.contains(URLarananKelime)) {
            System.out.println("URL : " + URLarananKelime +" kelimesini iceriyor TEST PASS");

        }else{
            System.out.println("URL : " + URLarananKelime +" kelimesini icermiyor TEST FAILED");
        }
        // 8-”Nutella” icin arama yapiniz
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        // 9- Kac sonuc bulundugunu yaziniz
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='inline-flex mv3-xl mt3 ml3 ml4-xl mr1 db']"));
        System.out.println(sonucYazisiElementi.getText());
        // 10-Sayfayi kapatin
        driver.close();
    }
}
