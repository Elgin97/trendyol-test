import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class TrendyolTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.trendyol.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        String firstWindow=driver.getWindowHandle();
        String firstWindowUrl= driver.getCurrentUrl();
        driver.findElement(By.xpath("//input[@class='search-box']")).click();
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("Laptop");
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys(Keys.ENTER);

        //Marka seçiyoruz.
        driver.findElement(By.xpath("//div[@class='fltr-item-text']")).click();
        Thread.sleep(1000);

        //Fiyatın olduğu bölümü görebilmek için sayfayı biraz kaydırıyoruz.
        WebElement price=driver.findElement(By.xpath("//div[text()='Laptop']"));
        js.executeScript("arguments[0].scrollIntoView();",price);
        Thread.sleep(1000);

        //Fiyat aralığı giriyoruz.
        driver.findElement(By.xpath("//div[text()='Fiyat']")).click();
        driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input min']")).sendKeys("10000");
        driver.findElement(By.xpath("//input[@class='fltr-srch-prc-rng-input max']")).sendKeys("15000");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/button")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[5]/div/div[1]/div[1]/a/div[2]/div[1]/div")).click();

        //Geçiş yapılan yeni sekmede işlem yapabilmek için
        Set<String> allWindows=driver.getWindowHandles();

        for (String window:allWindows){
            driver.switchTo().window(window);
        }

        //Ürünün özelliklerine göz atıyoruz.
        driver.findElement(By.xpath("//a[text()='ÜRÜNÜN TÜM ÖZELLİKLERİ']")).click();
        Thread.sleep(2000);


        //Sepete ürün ekleyip siliyoruz.
        driver.findElement(By.xpath("//button[@class='add-to-basket']")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/div/div/div[3]/div/div/div/div[2]/a/div[2]"));
        driver.findElement(By.xpath("//body/div[@id='container']/div[@id='header']/div[@id='headerMain']/div[@id='sticky-header']/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/a[1]/p[1]")).click();




    }

}