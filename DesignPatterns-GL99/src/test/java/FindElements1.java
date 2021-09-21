import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class FindElements1 extends PractiseFormsTest {

    By forms = By.cssSelector("div.home-body > div > div:nth-child(2)");
    By practiceForm = By.cssSelector("div.element-list.collapse.show");


    public void FormsClicks() {
        //        Click on 'Forms'
        $(forms).scrollIntoView(true);
        $(forms).click();

    }

    public void PracticeFormClick() {
        //        Click on 'Practice Form'
        $(practiceForm).scrollIntoView(true);
        $(practiceForm).click();

    }
}



