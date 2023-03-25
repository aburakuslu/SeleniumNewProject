package day04_XpathCssSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_cssSelector {
    public static void main(String[] args) {
        System.setProperty("chromeDriver", "src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        // 2- Add Element butonuna basin

        //Delete butonu’nun gorunur oldugunu test edin
        //Delete tusuna basin
        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
    }
}
