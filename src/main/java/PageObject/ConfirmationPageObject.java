package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPageObject {
    private WebDriver driver;
    private By confirmButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public ConfirmationPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void confirmButtonClick(){
        driver.findElement(confirmButton).click();
    }
}
