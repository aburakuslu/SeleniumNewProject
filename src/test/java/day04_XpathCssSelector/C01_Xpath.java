package day04_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //web sayfasına gidin. https://www.amazon.com/
        driver.get("https://amazon.com");
        //Search(ara) “city bike”
        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0"
        aria-label="Search Amazon" spellcheck="false">
        XPATH SYNTAX;
                    //tag_name[@attributeName='atributeDeğeri']
                    //input[@id='twotabsearchtextbox']
         */

        WebElement aramakutusu = driver.findElement(By.xpath("//input[@type='text']"));
        aramakutusu.sendKeys("city bike");
        aramakutusu.submit();

        //Hybrid Bikes bölümüne tıklayın ve gorunur, erisilebilir ve secilebilir olup olmadigini
        // konsolda gosteriniz.

        /*
        (//*[@class='a-size-base a-color-base'])[16] --> Bu şekilde index kullanarak unique olarak Webelement(WE)'e ulasabiliriz.

        //*[text()='Hybrid Bikes'] --> xpath ile locate alirken html kodlarinda attribute name olmayan yani <tagname class=degeri>text()
        metin varsa bu sekilde locate edebiliriz.
         */
        /*
        <span class="a-size-base a-color-base">hybrid bike</span>
         */

        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBike.isDisplayed()); //WE goruntulenebiliyor mu? --> Goruntulenebiliyor True
        System.out.println(hybridBike.isEnabled()); //WE erisilebiliyor mu? Erisilebiliyor True
        System.out.println(hybridBike.isSelected()); //WE secilebiliyor mu? Secilemiyor False
        hybridBike.click();

        //Sadece sonuc sayısını yazdıralım
        /*
        //*[text()='15 results for']
        (//*[@class="a-section a-spacing-small a-spacing-top-small"])(1)
         */

        WebElement sonucSayisi = driver.findElement(By.xpath("//*[text()='15 results for']"));
        String[] sonuc = sonucSayisi.getText().split(" ");
        System.out.println(sonuc[0]);

        //Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@class='a-link-normal s-no-outline'])[1]")).click();

        //Sayfayi kapatiniz
        driver.close();
    }
}