package PageFactoryAndFluentAPI;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FluentAPIImplementation {

    private SelenideElement visibleText;
    private SelenideElement checkInfoName;
    private SelenideElement checkInfoGender;
    private SelenideElement checkInfoMobile;


    public FluentAPIImplementation() {
    }


    @Step("Step with fluent api AssertVisibility")
    //   implementing Fluent API
    public FluentAPIImplementation AssertVisibility() {
        //        Check that 'Thanks for submitting the form' text is visible
        visibleText = $("#example-modal-sizes-title-lg");
        visibleText.scrollIntoView(true);
        this.visibleText.shouldBe(Condition.visible);
        return this;
    }

    @Step("Step with fluent api checkInfoName")
    public FluentAPIImplementation checkInfoName(String expectedName) {
        checkInfoName = $("tbody > tr:nth-child(1) > td:nth-child(2)");
        checkInfoName.scrollIntoView(true);
        System.out.println("Student info: " + $(checkInfoName).getText());
        this.checkInfoName.shouldBe(Condition.exactText(expectedName));
        return this;
    }

    @Step("Step with fluent api checkInfoGender")
    public FluentAPIImplementation checkInfoGender(String gender) {
        checkInfoGender = $("tbody > tr:nth-child(3) > td:nth-child(2)");
        checkInfoGender.scrollIntoView(true);
        System.out.println("Student gender: " + $(checkInfoGender).getText());
        this.checkInfoGender.shouldBe(Condition.exactText(gender));
        return this;
    }

    @Step("Step with fluent api checkInfoMobile")
    public FluentAPIImplementation checkInfoMobile(String mobile) {
        checkInfoMobile = $("tbody > tr:nth-child(4) > td:nth-child(2)");
        checkInfoMobile.scrollIntoView(true);
        System.out.println("Student mobile: " + $(checkInfoMobile).getText());
        this.checkInfoMobile.shouldBe(Condition.exactText(mobile));
        return this;
    }


}
