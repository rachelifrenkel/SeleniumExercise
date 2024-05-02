import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public static WebDriver driver;
    ConfigReader configReader = new ConfigReader("src/main/resources/urlDriver.properties");
    public WebDriver driverInit() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configReader.getProperty("base_url"));
        return driver;
    }
}
