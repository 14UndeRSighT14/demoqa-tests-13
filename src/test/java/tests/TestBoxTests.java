package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests extends TestBase {
    @Test
    void successfulTest() {
        String name = "Slava";

        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("slava@gmail.com");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 2");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("slava@gmail.com"),
                text("Some address 1"), text("Another address 2"));
    }

}
