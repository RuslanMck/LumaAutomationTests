package helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ElementSelectionHelper {
    public static void clickElementByAttribute(String actualAttribute, String expectedAttributeValue, ElementsCollection listOfElements){
        for(SelenideElement button : listOfElements){
            if(button.getAttribute(actualAttribute).equals(expectedAttributeValue)){
                button.click();
                break;
            }
        }
    }
}
