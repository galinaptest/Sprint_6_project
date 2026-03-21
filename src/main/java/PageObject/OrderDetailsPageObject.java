package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderDetailsPageObject {
    private WebDriver driver;
    private By dateField = By.className("react-datepicker__input-container");
    private By datepicker = By.xpath("//div[@class='react-datepicker__week']/div[@aria-label='Choose среда, 25-е марта 2026 г.']");
    private By durationField = By.className("Dropdown-placeholder");
    private By durationList = By.xpath("//div[@class='Dropdown-menu']/div[2]");
    private By colorCheckbox = By.id("black");
    private By commentField = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public OrderDetailsPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void orderDetailsFilling(){
        driver.findElement(dateField).click();
        driver.findElement(datepicker).click();
        driver.findElement(durationField).click();
        driver.findElement(durationList).click();
        driver.findElement(colorCheckbox).click();
        driver.findElement(commentField).sendKeys("Лучший самокат");
        driver.findElement(orderButton).click();
    }
}
