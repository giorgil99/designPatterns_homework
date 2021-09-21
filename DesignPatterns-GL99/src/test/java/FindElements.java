import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class FindElements extends PractiseFormsTest {

    By forms = By.cssSelector("div.home-body > div > div:nth-child(2)");
    By practiceForm = By.cssSelector("div.element-list.collapse.show");

    By firstNameCss = By.cssSelector("#firstName");
    By lastNameCss = By.cssSelector("#lastName");
    By genderCss = By.cssSelector("div.custom-control.custom-radio.custom-control-inline");
    By mobileNumberCss = By.cssSelector("#userNumber");
    By submit = By.cssSelector("#submit");
    By visibleText = By.cssSelector("#example-modal-sizes-title-lg");
    By checkInfo = By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(2)");

    public void ElementsAndActionsClicks() {
        $(forms).scrollIntoView(true);
        $(forms).click();
//        Click on 'Forms'
        switchTo().defaultContent();
//        Click on 'Practice Form'
        $(practiceForm).scrollIntoView(true);
        $(practiceForm).click();

    }


    public void ElementsAndActionsFills(String firstName, String lastName, int gender, String mobileNumber) {
//        Fill First Name, Last Name , Gender and mobile number
        $(firstNameCss).sendKeys(firstName);
        $(lastNameCss).sendKeys(lastName);
        $(genderCss, gender).click();
        $(mobileNumberCss).sendKeys(mobileNumber);
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
