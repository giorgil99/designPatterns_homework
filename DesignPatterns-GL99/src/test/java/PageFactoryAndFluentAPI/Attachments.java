package PageFactoryAndFluentAPI;

import io.qameta.allure.Attachment;

public class Attachments {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
