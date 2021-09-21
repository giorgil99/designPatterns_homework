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
        FindElements ElementsAndActions = new FindElements();
        ElementsAndActions.ElementsAndActionsClicks();
        ElementsAndActions.ElementsAndActionsFills(firstName, lastName, gender, mobileNumber);

//        Check that 'Thanks for submitting the form' text is visible
        ElementsAndActions.AssertVisibility().shouldBe(Condition.visible);
//        Check that student info is correct
        ElementsAndActions.AssertInfo().shouldBe(Condition.exactText(firstName + " " + lastName));


    }


}
