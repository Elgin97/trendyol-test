import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.Set;


public class UyelikGirisi {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        String firstWindow=driver.getWindowHandle();
        String firstWindowUrl= driver.getCurrentUrl();

        //Giriş Yap sayfasına gidip bilgileri giriyoruz.
        driver.findElement(By.xpath("//div[@class='link account-user']")).click();
        driver.findElement(By.xpath("//input[@class='q-input']")).click();
        driver.findElement(By.xpath("//input[@class='q-input']")).sendKeys("elgin123@gmail.com");
        driver.findElement(By.xpath("//input[@name='login-password']")).sendKeys("elgin123");
        driver.findElement(By.xpath("//button[@class='q-primary q-fluid q-button-medium q-button submit']")).click();


        //Elektronik butonuna tıklayarak telefon seçeneğini seçiyoruz.
        driver.navigate().refresh();
        driver.findElement(By.xpath("//li[@class='tab-link'][9]")).click();
        driver.findElement(By.xpath("//span[text()='Cep Telefonu']")).click();
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='fltr-item-text' and text()='Apple']")).click();
        driver.findElement(By.xpath("//span[text()='iPhone SE 64GB Siyah Cep Telefonu (Apple Türkiye Garantili) Aksesuarsız Kutu']")).click();


        //Yeni bir sekmeye atıyor.Bu sekmede işleme devam etmek için yeni sekmeye geçiş yapıyoruz.
        Set<String> allWindows=driver.getWindowHandles();
        for (String window:allWindows){
            driver.switchTo().window(window);
        }

        //Ürünü sepete ekleyip siliyoruz.
        driver.findElement(By.xpath("//button[@class='add-to-basket']")).click();
        driver.findElement(By.xpath("//a[@class='link account-basket']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[1]/a/img")).click();

    }
}