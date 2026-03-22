import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import page.object.MainPageObject;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FAQTest extends PreTest {
    @ParameterizedTest
    @MethodSource("dataProvider")
    public void faqTest(String expected,int listNumber) {
        MainPageObject objMainPage = new MainPageObject(driver);
        String actual=objMainPage.clickFaqQuestion(listNumber);
       assertEquals(expected,actual, "Тексты не соответствуют");
    }
    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",0),
                Arguments.of("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",1),
                Arguments.of("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",2),
                Arguments.of("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",3),
                Arguments.of("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",4),
                Arguments.of("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",5),
                Arguments.of("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",6),
                Arguments.of("Да, обязательно. Всем самокатов! И Москве, и Московской области.",7)

        );
    }
}
