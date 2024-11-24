package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class FileUploadPage {

    private final String PAGE_URL = "https://practice.expandtesting.com/upload";

    private SelenideElement fileUploadField = Selenide.$("#fileInput");
    private SelenideElement uploadButton = Selenide.$("#fileSubmit");

    public void clickUploadButton(){
        uploadButton.shouldBe(Condition.visible);
        uploadButton.click();
    }
}
