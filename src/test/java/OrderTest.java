import PageObject.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private WebDriver driver;
    @BeforeEach
    public void setUp() {
       //  driver = new FirefoxDriver();
        driver = new ChromeDriver(); // в хроме не нажимается кнопка подтверждения заказа "Да"
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageObjects objMainPage = new MainPageObjects(driver);
        objMainPage.closeCookie();
    }
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void OrderTopButtonPositiveTest(String name, String surname, String address, String phone){
        MainPageObjects objMainPage = new MainPageObjects(driver);
        OrderFormPageObjects objFormPage = new OrderFormPageObjects(driver);
        OrderDetailsPageObject objDetailsPage = new OrderDetailsPageObject(driver);
        ConfirmationPageObject objConfirmationPage = new ConfirmationPageObject(driver);
        OrderSuccessPageObject objOrderSuccessPage = new OrderSuccessPageObject(driver);
        objMainPage.orderButtonTopClick();
        objFormPage.formFilling(name,surname,address,phone);
        objDetailsPage.orderDetailsFilling();
        objConfirmationPage.confirmButtonClick();
        boolean actual = objOrderSuccessPage.orderSuccessCheck();
        assertTrue(actual, "Заказ не оформлен");

    }
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void OrderMiddleButtonPositiveTest(String name, String surname, String address, String phone){
        MainPageObjects objMainPage = new MainPageObjects(driver);
        OrderFormPageObjects objFormPage = new OrderFormPageObjects(driver);
        OrderDetailsPageObject objDetailsPage = new OrderDetailsPageObject(driver);
        ConfirmationPageObject objConfirmationPage = new ConfirmationPageObject(driver);
        OrderSuccessPageObject objOrderSuccessPage = new OrderSuccessPageObject(driver);
        objMainPage.orderButtonMiddleClick();
        objFormPage.formFilling(name,surname,address,phone);
        objDetailsPage.orderDetailsFilling();
        objConfirmationPage.confirmButtonClick();
        boolean actual = objOrderSuccessPage.orderSuccessCheck();
        assertTrue(actual,"Заказ не оформлен");

    }
    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Имя", "Фамилия", "МОСКВА", "+79219219292"),
                Arguments.of("ПЕТР", "ПЕТРОВ", "Москва, ул.Строителей, д.25, кв.12", "89999219292")
        );
    }
    @AfterEach
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}
