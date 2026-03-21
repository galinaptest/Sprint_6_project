package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPageObjects {
    private WebDriver driver;

    private By orderButtonTop = By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']"); // Кнопка «Заказать» верх страницы
    private By orderButtonMiddle = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']"); // Кнопка «Заказать» середина страницы
    private By faqListName = By.className("Home_SubHeader__zwi_E"); // Заголовок вопросов о важном
    private By faqQuestionsList = By.className("accordion__button");// Вопросы о важном список вопросов
    private By faqAnswersList = By.className("accordion__panel");//Вопросы о важном список ответов
    private By cookieButton = By.className("App_CookieButton__3cvqF");//

    public MainPageObjects(WebDriver driver){
        this.driver = driver;
    }
    public void closeCookie(){
        driver.findElement(cookieButton).click();
    };

    public List<String> clickFaqQuestion() {
        WebElement element = driver.findElement(faqListName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        List<WebElement> questionButtons = driver.findElements(faqQuestionsList);
        List<WebElement> answerButtons = driver.findElements(faqAnswersList);
        List<String> textAnswer = new ArrayList<>();
        for (int i = 0; i < questionButtons.size(); i++) {
            WebElement questionButton = questionButtons.get(i);
            questionButton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement answerButton = answerButtons.get(i);
            textAnswer.add(answerButton.getAttribute("innerText"));
        }
        System.out.println(textAnswer);
        return textAnswer;
    }

    public void orderButtonTopClick(){
        driver.findElement(orderButtonTop).click();
    }

    public void orderButtonMiddleClick(){
        WebElement element = driver.findElement(orderButtonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(orderButtonMiddle).click();
    }


}
