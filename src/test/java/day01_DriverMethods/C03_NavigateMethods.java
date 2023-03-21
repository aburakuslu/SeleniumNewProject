package day01_DriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class C03_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("edgeDriver","src/resources/driver/msedgedriver");
        WebDriver driver = new EdgeDriver();
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        Thread.sleep(3000);//Java kodlarını bekletmek için kullanırız(3 saniye bekletir)
        //Sonra techproeducation sayfasına gidelim
        driver.navigate().to("https://techproeducation.com");//get() methodu ile aynı şekilde çalışır
        Thread.sleep(3000);
        //techpro sayfa başlığını konsola yazdıralım
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        //tekrar amazon sayfasına geri dönelim
        driver.navigate().back();//ilk sayfaya döner
        Thread.sleep(3000);
        //Amazon sayfasının başlığını yazdıralım
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        //tekrar techpro sayfasına geri gidelim
        driver.navigate().forward();
        //son olarak sayfayı yenileyelim ve sayfayı kapatalım
        driver.navigate().refresh();//sayfayı yeniler
        driver.close();//driver'i kapatır
        //NOT: Sayfalar arası geçişler hızlı olacağından 3 saniye geçişler için bekletelim
    }
}