package PageFactoryAndFluentAPI;

import com.codeborne.selenide.SelenideElement;
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
    @FindBy(how = How.CSS, css = "#example-modal-sizes-title-lg")
    WebElement visibleText;
    @FindBy(how = How.CSS, css = "tbody > tr:nth-child(1) > td:nth-child(2)")
    WebElement checkInfoName;
    @FindBy(how = How.CSS, css = "tbody > tr:nth-child(3) > td:nth-child(2)")
    WebElement checkInfoGender;
    @FindBy(how = How.CSS, css = "tbody > tr:nth-child(4) > td:nth-child(2)")
    WebElement checkInfoMobile;


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

    public void sendFirstName() {
        $(firstName).sendKeys(SFirstName);
    }

    public void sendLastName() {
        $(lastName).sendKeys(SLastName);
    }

    public void sendGender() {
        if (SGender == 0) {
            $(gender1).click();
        } else if (SGender == 1) {
            $(gender2).click();
        } else {
            System.out.println("Gender selection issue! ");
        }
    }

    public void sendMobileNumber() {
        $(userNumber).sendKeys(SMobileNumber);
    }

    public void clickSubmit() {
        $(submit).scrollIntoView(true);
        $(submit).click();
    }

    //   implementing Fluent API
    public SelenideElement AssertVisibility() {
        //        Check that 'Thanks for submitting the form' text is visible
        $(visibleText).scrollIntoView(true);
        return $(visibleText);
    }

    public SelenideElement checkInfoName() {
        $(checkInfoName).scrollIntoView(true);
        System.out.println("Student info: " + $(checkInfoName).getText());
        return $(checkInfoName);
    }

    public SelenideElement checkInfoGender() {
        $(checkInfoGender).scrollIntoView(true);
        System.out.println("Student gender: " + $(checkInfoGender).getText());
        return $(checkInfoGender);
    }
    public SelenideElement checkInfoMobile() {
        $(checkInfoMobile).scrollIntoView(true);
        System.out.println("Student mobile: " + $(checkInfoMobile).getText());
        return $(checkInfoMobile);
    }


    public PracticeFormPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}
