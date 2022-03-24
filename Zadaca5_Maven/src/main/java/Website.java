import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Website {

    public static String URL = "https://www.maasu.de/";
    private WebDriver browserDriver;
    private String browser;

    @BeforeTest
    public void SetupBrowser() {
        this.browser = "Firefox";
        if (this.browser.contains("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.browserDriver = new FirefoxDriver();

        } else if (this.browser.contains("Chrome")) {
            WebDriverManager.chromedriver().setup();
            this.browserDriver = new ChromeDriver();

        }
    }

    @Test
    public void OpenHomepage() {
        this.browserDriver.navigate().to(URL);
        String currentUrl = this.browserDriver.getCurrentUrl();
        if (URL.equals(currentUrl)) {
            System.out.println("Test succeeded");
        } else {
            System.out.println("Test failed");
        }

    }

    @AfterTest
    public void CloseBrowser() {
        try {
            Thread.sleep(5000); //We wait a bit before page closes. There is probably an easier method.
            this.browserDriver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
