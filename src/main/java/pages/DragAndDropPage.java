package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class DragAndDropPage {

    private final String BASE_URL = "https://practice.expandtesting.com/drag-and-drop#google_vignette";
    private SelenideElement firstBox = Selenide.$("#column-a");
    private SelenideElement secondBox = Selenide.$("#column-b");
    private SelenideElement dragAndDropContainer = Selenide.$("#dnd-columns");

    public void dragAndDropBoxAToBoxB() {
        firstBox.shouldBe(Condition.visible);
        secondBox.shouldBe(Condition.visible);

        DragAndDropOptions option = DragAndDropOptions.to(secondBox);
        firstBox.dragAndDrop(option);
    }

    public void dragAndDropBoxBToBoxA() {
        firstBox.shouldBe(Condition.visible);
        secondBox.shouldBe(Condition.visible);

        DragAndDropOptions option = DragAndDropOptions.to(firstBox);
        secondBox.dragAndDrop(option);
    }

    public String getBoxAText(){
        return firstBox.text();
    }

    public String getBoxBText(){
        return secondBox.text();
    }


    /**
     * This method takes the HTML parent element for both draggable elements. Then by using Selenide method
     * Condition.matchText() takes all text from both draggable elements, in our case it's headers "A" and "B".
     * Then we use regular expression <".*" + firstElement + ".*" + secondElement + ".*">. ".*" - Matches any sequence
     * of characters, including an empty sequence.
     * @param firstElement - The elements that has to be first in the HTML structure
     * @param secondElement - The elements that has to be second in the HTML structure
     * @return returns TRUE is the firstElement is actually first in the HTML structure
     */
    public boolean verifyBoxPosition(String firstElement, String secondElement) {
        dragAndDropContainer.shouldHave(Condition.matchText(".*" + firstElement + ".*" + secondElement + ".*"));
        return dragAndDropContainer.is(Condition.matchText(".*" + firstElement + ".*" + secondElement + ".*"));
    }

}
