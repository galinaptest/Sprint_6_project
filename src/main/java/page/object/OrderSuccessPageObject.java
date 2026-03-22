package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSuccessPageObject {
    private WebDriver driver;
    private By orderSuccessWindowName = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[text()='Заказ оформлен']");

    public OrderSuccessPageObject(WebDriver driver){
        this.driver = driver;
    }
    public boolean orderSuccessCheck(){
        return driver.findElement(orderSuccessWindowName).isDisplayed();
    }
}
