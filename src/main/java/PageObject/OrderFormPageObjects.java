package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OrderFormPageObjects {
    private WebDriver driver;

    private By nameField = By.cssSelector("input[placeholder='* Имя']");//имя
    private By surnameField = By.cssSelector("input[placeholder='* Фамилия']");//фамилия
    private By addressField = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");//адрес
    private By metroField = By.cssSelector("input[placeholder='* Станция метро']");//метро
    private By stationSelect = By.xpath("//div[@class='select-search__select']");//станция метро
    private By phoneField = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");//телефон
    private By nextButton = By.xpath("//div[@class='Order_NextButton__1_rCA']/button"); //кнопка Далее

    public OrderFormPageObjects(WebDriver driver){
        this.driver = driver;
    }
    public void formFilling(String name, String surname, String address, String phone){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(stationSelect).click();
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();


    }
}
