package ui;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import steps.DragAndDropPageSteps;

public class DragAndDropPageTests extends TestConfig{
    private final DragAndDropPage DRAG_AND_DROP_PAGE = new DragAndDropPage();
    private final DragAndDropPageSteps DRAG_AND_DROP_PAGE_STEPS = new DragAndDropPageSteps();

    @BeforeClass
    public void setUp(){
        super.basicConfigs();
        Selenide.open(DRAG_AND_DROP_PAGE.getBASE_URL());
    }

    @Test(description = "Verify that elements can be dragged and dropped")
    public void verifyElementsDragAndDrop(){
        String firstBoxText = DRAG_AND_DROP_PAGE.getFirstBox().text();
        String secondBoxText = DRAG_AND_DROP_PAGE.getSecondBox().text();

        DRAG_AND_DROP_PAGE_STEPS.dropAToB();
        Assert.assertTrue(DRAG_AND_DROP_PAGE_STEPS.verifyElementsPosition(secondBoxText,firstBoxText),
                "Box B is not before Box A");

        DRAG_AND_DROP_PAGE_STEPS.dropBToA();
        Assert.assertTrue(DRAG_AND_DROP_PAGE_STEPS.verifyElementsPosition(firstBoxText,secondBoxText),
                "Box A is not before Box B");
    }
}
