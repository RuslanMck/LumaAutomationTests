package steps;

import io.qameta.allure.Step;
import pages.DragAndDropPage;

public class DragAndDropPageSteps {

    private final DragAndDropPage DRAG_AND_DROP_PAGE = new DragAndDropPage();

    @Step("Drag and drop box A to box B")
    public void dropAToB(){
        DRAG_AND_DROP_PAGE.dragAndDropBoxAToBoxB();
    }

    @Step("Drag and drop box B to box A")
    public void dropBToA(){
        DRAG_AND_DROP_PAGE.dragAndDropBoxBToBoxA();
    }

    public boolean verifyElementsPosition(String firstElements, String secondElements){
        return DRAG_AND_DROP_PAGE.verifyBoxPosition(firstElements, secondElements);
    }
}
