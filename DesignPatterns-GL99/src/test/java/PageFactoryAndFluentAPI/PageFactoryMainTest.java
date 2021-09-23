package PageFactoryAndFluentAPI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageFactoryMainTest {


    @DataProvider(name = "filler")
    public Object[][] getDataFromDataProvider() {
        return GetDataForFills.creatObject();
    }


    @Test(dataProvider = "filler")
    public void MainTest(String firstName, String lastName, int gender, String mobileNumber) {
        GetWebConnection.ConnectToPage();
//          Click on 'Forms'
        FormsPageFactory formsPage = new FormsPageFactory(Selenide.webdriver().object());
        formsPage.clickFroms();
//          Click on 'Practice Form'
        PracticeFormPageFactory practicePage = new PracticeFormPageFactory(Selenide.webdriver().object());
        practicePage.clickPracticeForm();
//          Fill First Name, Last Name , Gender and mobile number
        practicePage.SetDataForFills(firstName, lastName, gender, mobileNumber);
        practicePage.sendFirstName();
        practicePage.sendLastName();
        practicePage.sendGender();
        practicePage.sendMobileNumber();
        practicePage.clickSubmit();
//        Check that 'Thanks for submitting the form' text is visible
        practicePage.AssertVisibility().shouldBe(Condition.visible);
//        Check that student info is correct
        practicePage.checkInfoName().shouldBe(Condition.exactText(firstName + " " + lastName));

        if (gender == 0) {
            practicePage.checkInfoGender().shouldBe(Condition.exactText("Male"));
        } else if (gender == 1) {
            practicePage.checkInfoGender().shouldBe(Condition.exactText("Female"));
        } else {
            System.out.println("Main Test gender assertion error!");
        }

        practicePage.checkInfoMobile().shouldBe(Condition.exactText(mobileNumber));

    }
}
