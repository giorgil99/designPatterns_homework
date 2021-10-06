package PageFactoryAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPageFactory {
    WebDriver driver;
    private static String SFirstName;
    private static String SLastName;
    private static int SGender;
    private static String SMobileNumber;

    @FindBy(how = How.CSS, css = "div.element-list.collapse.show")
    WebElement practiceForm;
    @FindBy(how = How.CSS, css = "#firstName")
    WebElement firstName;
    @FindBy(how = How.CSS, css = "#lastName")
    WebElement lastName;
    @FindBy(how = How.CSS, css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)")
    WebElement gender1;
    @FindBy(how = How.CSS, css = "#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)")
    WebElement gender2;
    @FindBy(how = How.CSS, css = "#userNumber")
    WebElement userNumber;
    @FindBy(how = How.CSS, css = "#submit")
    WebElement submit;



    public void clickPracticeForm() {
        $(practiceForm).scrollIntoView(true);
        $(practiceForm).click();
    }

    public void SetDataForFills(String firstName, String lastName, int gender, String mobileNumber) {
//        Fill First Name, Last Name , Gender and mobile number
        SFirstName = firstName;
        SLastName = lastName;
        SGender = gender;
        SMobileNumber = mobileNumber;
    }
    @Step
    public void sendFirstName() {
        $(firstName).sendKeys(SFirstName);
    }
    @Step
    public void sendLastName() {
        $(lastName).sendKeys(SLastName);
    }
    @Step
    public void sendGender() {
        if (SGender == 0) {
            $(gender1).click();
        } else if (SGender == 1) {
            $(gender2).click();
        } else {
            System.out.println("Gender selection issue! ");
        }
    }
    @Step
    public void sendMobileNumber() {
        $(userNumber).sendKeys(SMobileNumber);
    }
    @Step
    public void clickSubmit() {
        $(submit).scrollIntoView(true);
        $(submit).click();
    }



    public PracticeFormPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
