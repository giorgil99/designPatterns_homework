import com.codeborne.selenide.Configuration;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DriverConfig {





    public static void  Config () {

        Configuration.browser = "Edge";
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Path root = Paths.get(".").normalize().toAbsolutePath();
        Configuration.reportsFolder = root + "\\src\\main\\resources\\Reports";
        Configuration.savePageSource = false;
        System.out.println("DriverConfig is set: ");


    }







}
