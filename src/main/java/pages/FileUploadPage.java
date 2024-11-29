package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.PageNavigationHelper;
import lombok.Getter;

import java.io.File;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class FileUploadPage {

    private final String PAGE_URL = "https://practice.expandtesting.com/upload";

    private SelenideElement fileUploadField = Selenide.$("#fileInput");
    private SelenideElement uploadButton = Selenide.$("#fileSubmit");
    private SelenideElement resultHeader = Selenide.$x("//h1");
//    private SelenideElement nameOfOneUploadedFile = Selenide.
//            $x("//p[normalize-space(text())='1732889746830_file-to-upload.pdf']");
    private SelenideElement nameOfOneUploadedFile = Selenide.$("#uploaded-files");

    public void clickUploadButton() {
        PageNavigationHelper.ScrollPageToElement(uploadButton);
        uploadButton.shouldBe(Condition.visible);
        uploadButton.click();
    }

    public void uploadFile() {
        fileUploadField.shouldBe(Condition.visible);
        fileUploadField.uploadFile(new File("src/test/resources/file-to-upload.pdf"));
    }

    public String getResultHeaderText() {
        return resultHeader.text();
    }

    private String getNameOfOneUploadedFile(){
        return nameOfOneUploadedFile.text();
    }

    public String getUploadedFileName() {
        String nameRegex = "(?<=_).+$";

        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(getNameOfOneUploadedFile());

        if (matcher.find()) {
            return matcher.group();
        } else {
            System.out.println("No match found.");
        }
        return null;
    }
}