import PageObject.MainPageObjects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FAQTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver(); // Создание драйвера перед каждым тестом
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageObjects objMainPage = new MainPageObjects(driver);
        objMainPage.closeCookie();
    }
    @Test
    public void FaqTest() {
        MainPageObjects objMainPage = new MainPageObjects(driver);
        List<String>actualResult =  objMainPage.clickFaqQuestion();
        List<String>expectedResult = new ArrayList<>();
        expectedResult.add("Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        expectedResult.add("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        expectedResult.add("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        expectedResult.add("Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        expectedResult.add("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        expectedResult.add("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        expectedResult.add("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        expectedResult.add("Да, обязательно. Всем самокатов! И Москве, и Московской области.");
        assertEquals(expectedResult,actualResult, "Тексты не соответствуют");
    }
    @AfterEach
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
