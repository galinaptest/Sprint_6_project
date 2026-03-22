import constants.PageAddress;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.MainPageObject;

public class PreTest {
    public WebDriver driver;
    @BeforeEach
    public void setUp() {
        //  driver = new FirefoxDriver();
        driver = new ChromeDriver(); // в хроме не нажимается кнопка подтверждения заказа "Да"
        driver.get(PageAddress.URL);
        MainPageObject objMainPage = new MainPageObject(driver);
        objMainPage.closeCookie();
    }
    @AfterEach
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
