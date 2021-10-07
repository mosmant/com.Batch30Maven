package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        /*===============================================================================================================================
        implicitlyWait => yukaridaki satir class basinda yazilirsa bu test boyunca her locator boyunca driver max yazilan zaman kadar bekler.
         ================================================================================================================================*/
        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        // 2- arama kutusunu locate edelim
        WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        // 3- “Samsung headphones” ile arama yapalim
        searchbox.sendKeys("Samsung headphones"+ Keys.ENTER);
        // 4- Bulunan sonuc sayisini yazdiralim
        // WebElement sonucYazisiElementi = driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));

        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        // By class.Name ile locate ettigimiz webelemwntinde class attribute 'nun degerinde bosluk varsa sorun yasanabilir.
        System.out.println(sonucYazisiElementi.getText());

        // 5- Ilk urunu tiklayalim
        // WebElement ilkUrunElementi = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        // ilkUrunElementi.click();
        // SADECE 1 CLICK YAPACAKSAK WEBELEMENT OLSUTURMAYA VE ASSIGN ETMEYE GEREK YOKTUR DIREK LOCATE EDIP CLICK YAPABİLİRİZ.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        // 6- Sayfadaki tum basliklari yazdiralim
        driver.navigate().back();
        List<WebElement> urunlerListesi = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        urunlerListesi.stream().forEach(t-> System.out.println(t.getText()));
    }
}
