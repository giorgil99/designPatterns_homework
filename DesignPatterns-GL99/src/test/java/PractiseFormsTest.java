import com.codeborne.selenide.Condition;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PractiseFormsTest {


    @DataProvider(name = "filler")
    public Object[][] getDataFromDataProvider() {
        return GetDataForFills.creatObject();
    }

    @Test(dataProvider = "filler")
    public void MainTest(String firstName, String lastName, int gender, String mobileNumber) {
        GetWebConnection.ConnectToPage();

        FindElements1 ElementsAndActions1 = new FindElements1();
        ElementsAndActions1.FormsClicks();
        ElementsAndActions1.PracticeFormClick();

        FindElements2 ElementsAndActions2 = new FindElements2();
        ElementsAndActions2.SetDataForFills(firstName, lastName, gender, mobileNumber);

        ElementsAndActions2.SetFirstName();
        ElementsAndActions2.SetLastName();
        ElementsAndActions2.SetGender();
        ElementsAndActions2.SetMobileNumber();
        ElementsAndActions2.Submit();

//        Check that 'Thanks for submitting the form' text is visible
        ElementsAndActions2.AssertVisibility().shouldBe(Condition.visible);
//        Check that student info is correct
        ElementsAndActions2.AssertInfo().shouldBe(Condition.exactText(firstName + " " + lastName));


    }


}
