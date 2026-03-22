import page.object.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends PreTest {
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void orderTopButtonPositiveTest(String name, String surname, String address, String phone, String comment){
        MainPageObject objMainPage = new MainPageObject(driver);
        OrderFormPageObject objFormPage = new OrderFormPageObject(driver);
        OrderDetailsPageObject objDetailsPage = new OrderDetailsPageObject(driver);
        ConfirmationPageObject objConfirmationPage = new ConfirmationPageObject(driver);
        OrderSuccessPageObject objOrderSuccessPage = new OrderSuccessPageObject(driver);
        objMainPage.orderButtonTopClick();
        objFormPage.formFilling(name,surname,address,phone);
        objDetailsPage.orderDetailsFilling(comment);
        objConfirmationPage.confirmButtonClick();
        boolean actual = objOrderSuccessPage.orderSuccessCheck();
        assertTrue(actual, "Заказ не оформлен");

    }
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void orderMiddleButtonPositiveTest(String name, String surname, String address, String phone, String comment){
        MainPageObject objMainPage = new MainPageObject(driver);
        OrderFormPageObject objFormPage = new OrderFormPageObject(driver);
        OrderDetailsPageObject objDetailsPage = new OrderDetailsPageObject(driver);
        ConfirmationPageObject objConfirmationPage = new ConfirmationPageObject(driver);
        OrderSuccessPageObject objOrderSuccessPage = new OrderSuccessPageObject(driver);
        objMainPage.orderButtonMiddleClick();
        objFormPage.formFilling(name,surname,address,phone);
        objDetailsPage.orderDetailsFilling(comment);
        objConfirmationPage.confirmButtonClick();
        boolean actual = objOrderSuccessPage.orderSuccessCheck();
        assertTrue(actual,"Заказ не оформлен");

    }
    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Имя", "Фамилия", "МОСКВА", "+79219219292","Привезите лучший самокат"),
                Arguments.of("ПЕТР", "ПЕТРОВ", "Москва, ул.Строителей, д.25, кв.12", "89999219292","Привезите лучший самокат")
        );
    }
}
