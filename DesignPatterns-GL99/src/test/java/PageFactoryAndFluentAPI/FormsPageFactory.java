package PageFactoryAndFluentAPI;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class FormsPageFactory {
    WebDriver driver;

    @FindBy(how = How.CSS, css = "div.home-body > div > div:nth-child(2)")
    WebElement forms;

    @Step
    public void clickFroms() {
        $(forms).scrollIntoView(true);
        $(forms).click();
    }
    public FormsPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
