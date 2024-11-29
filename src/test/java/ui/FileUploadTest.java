package ui;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import steps.FileUploadSteps;

import java.io.File;

public class FileUploadTest extends TestConfig {
    private final FileUploadPage FILE_UPLOAD_PAGE = new FileUploadPage();
    private final FileUploadSteps FILE_UPLOAD_STEPS = new FileUploadSteps();

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(FILE_UPLOAD_PAGE.getPAGE_URL());
    }

    @Test(description = "Verify the file uploading process")
    public void verifyFileUploading(){
        FILE_UPLOAD_STEPS.uploadFile();
        Assert.assertEquals(FILE_UPLOAD_PAGE.getResultHeaderText(), "File Uploaded!");
        String expectedFileName = new File("src/test/resources/file-to-upload.pdf").getName();
        Assert.assertEquals(FILE_UPLOAD_PAGE.getUploadedFileName(), expectedFileName, "Name of uploaded file" +
                " does not match the expected file name");
    }
}
