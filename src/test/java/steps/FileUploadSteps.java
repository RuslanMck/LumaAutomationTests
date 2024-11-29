package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import pages.FileUploadPage;

public class FileUploadSteps {
    private final FileUploadPage FILE_UPLOAD_PAGE = new FileUploadPage();

    @Step("Upload the file")
    public void uploadFile(){
        Selenide.refresh();
        FILE_UPLOAD_PAGE.uploadFile();
        FILE_UPLOAD_PAGE.clickUploadButton();
    }
}
