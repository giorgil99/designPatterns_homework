package PageFactoryAndFluentAPI;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

@Listeners(LocalListenerAllureFailedCase.class)
public class PageFactoryMainTest {

    public static String trueGender;


    @DataProvider(name = "filler")
    public Object[][] getDataFromDataProvider() {
        return GetDataForFills.creatObject();
    }


    @Test(dataProvider = "filler",description ="this discretion is already set at @Description" )
    @Epic("main test state")
    @Feature("main test run")
    @Story("main test now")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Main test for allure")
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

//        logic to determine trueGender !
        if (gender == 0) {
            trueGender = "Male";
        } else if (gender == 1) {
            trueGender = "Female";
        } else {
            System.out.println("Main Test gender assertion error!");
        }
        //        Check that 'Thanks for submitting the form' text is visible
        //        Check that student info is correct

        FluentAPIImplementation fluentApi = new FluentAPIImplementation();
        fluentApi
                .AssertVisibility()
                .checkInfoName(firstName + " " + lastName)
                .checkInfoGender(trueGender)
                .checkInfoMobile(mobileNumber);

    }


    @Test
    @Epic("helper test2 state")
    @Feature("helper test run")
    @Story("helper test now")
    @Severity(SeverityLevel.MINOR)
    @Description("Helper test for failed case")
    public void failTest()
    {


        open("https://duckduckgo.com/?t=opera");
        SoftAssert softAssert = new SoftAssert() ;
        softAssert.fail();

//        Attachments attach = new Attachments() ;
//        attach.saveScreenshot(Selenide.screenshot(OutputType.BYTES));

        softAssert.assertAll();



    }



}
