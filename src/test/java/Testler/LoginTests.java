package Testler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sayfalar.AnaSayfa;
import sayfalar.GirisYapSayfasi;

import java.time.Duration;

public class LoginTests {
    private WebDriver driver;
    private AnaSayfa anaSayfa;
    private GirisYapSayfasi girisYapSayfasi;
    @BeforeEach
    void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        anaSayfa=new AnaSayfa(driver);
        girisYapSayfasi=new GirisYapSayfasi(driver);
        driver.get("https://www.hepsiburada.com");
    }

    @Test
    void hepsiBuradaLoginTesti() {
        //POM
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.hesabim);
        anaSayfa.tusaBas(anaSayfa.hesabim);
        anaSayfa.elementGozukeneKadarBekle(anaSayfa.girisYap);
        anaSayfa.tusaBas(anaSayfa.girisYap);
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.emailAdresi);
        girisYapSayfasi.alanaYaziYaz(girisYapSayfasi.emailAdresi,"seleniumotomasyon@gmail.com");
        girisYapSayfasi.elementGozukeneKadarBekle(girisYapSayfasi.girisYapTusu);
        girisYapSayfasi.tusaBas(girisYapSayfasi.girisYapTusu);



        //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20L));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myAccount")));
        // driver.findElement(By.id("myAccount")).click();
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        //driver.findElement(By.id("login")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
        // driver.findElement(By.id("txtUserName")).sendKeys("ecedlplt@gmail.com");
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        //driver.findElement(By.id("btnLogin")).click();
    }
    @Test
    void urunAramaTests(){
   anaSayfa.elementGozukeneKadarBekleCss(anaSayfa.urunArama);
   anaSayfa.alanaYaziYazCss(anaSayfa.urunArama, "Araba");
   anaSayfa.klavyeTusunaBas(anaSayfa.urunArama, Keys.ENTER);

    }
    @AfterEach
    void tearDown(){
        driver.close();
    }
}
