import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class FindElements2 {

    private static String SFirstName;
    private static String SLastName;
    private static int SGender;
    private static String SMobileNumber;

    By firstNameCss = By.cssSelector("#firstName");
    By lastNameCss = By.cssSelector("#lastName");
    By genderCss = By.cssSelector("div.custom-control.custom-radio.custom-control-inline");
    By mobileNumberCss = By.cssSelector("#userNumber");
    By submit = By.cssSelector("#submit");
    By visibleText = By.cssSelector("#example-modal-sizes-title-lg");
    By checkInfo = By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(2)");

    public void SetDataForFills(String firstName, String lastName, int gender, String mobileNumber) {
//        Fill First Name, Last Name , Gender and mobile number
        SFirstName = firstName;
        SLastName = lastName;
        SGender = gender;
        SMobileNumber = mobileNumber;
    }

    public void SetFirstName() {
        $(firstNameCss).sendKeys(SFirstName);
    }

    public void SetLastName() {
        $(lastNameCss).sendKeys(SLastName);
    }

    public void SetGender() {
        $(genderCss, SGender).click();
    }

    public void SetMobileNumber() {
        $(mobileNumberCss).sendKeys(SMobileNumber);
    }

    public void Submit() {
        $(submit).scrollIntoView(true);
        $(submit).click();
    }


    public SelenideElement AssertVisibility() {
        //        Check that 'Thanks for submitting the form' text is visible
        $(visibleText).scrollIntoView(true);
        return $(visibleText);


    }

    public SelenideElement AssertInfo() {

        $(checkInfo).scrollIntoView(true);
        System.out.println("Student info: " + $(checkInfo).getText());
        return $(checkInfo);
    }


}

