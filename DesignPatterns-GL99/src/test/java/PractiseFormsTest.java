import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PractiseFormsTest {


    @DataProvider(name = "filler")
    public Object[][] getDataFromDataProvider() {
        return GetDataForFills.creatObject();
    }

    @Test(dataProvider = "filler")
    public void MainTest(String firstName, String lastName, int gender, String mobileNumber) throws InterruptedException {
        GetWebConnection.ConnectToPage();
        FindElements ElementsAndActions = new FindElements();
        ElementsAndActions.ElementsAndActionsClicks();
        ElementsAndActions.ElementsAndActionsFills(firstName, lastName, gender, mobileNumber);



    }


}
