import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class GetWebConnection extends DriverConfig {

    public  static  String URL = "https://demoqa.com/";


    public static void ConnectToPage () {
        Config();
//        Navigate to the https://demoqa.com/
        open(URL);
        System.out.println("GetWebConnection is set: ");



}

}
