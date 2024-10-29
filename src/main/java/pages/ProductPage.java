package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.ExpactedLinksAddress;
import helpers.ElementSelectionHelper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductPage {

    private SelenideElement addToCartButton = Selenide.$("#product-addtocart-button");
    private SelenideElement sizeSelectionBlock = Selenide.$x("//div[@attribute-code='color']");
    private SelenideElement colorSelectionBlock = Selenide.$x("//div[@class='swatch-attribute color']");
    private ElementsCollection colorSelectionButtons = Selenide.$$x("//div[@class='swatch-option color']");
    private ElementsCollection sizeSelectionButtons = Selenide.$$x("//div[@class='swatch-option text']");
    private SelenideElement addToCartConfirmation = Selenide.$("[role='alert']");

    private final String BASE_URL = ExpactedLinksAddress.PRODUCT_PAGE.getValue();

    public boolean addToCartConfirmationVisible(){
        addToCartConfirmation.shouldBe(Condition.visible);
        return addToCartConfirmation.is(Condition.have(Condition.text("You added")));
    }

    public void clickAddToCartButton(){
        addToCartButton.shouldBe(Condition.visible);
        addToCartButton.click();
    }

    public void selectSize(String size){
        sizeSelectionBlock.shouldBe(Condition.visible);
        for(SelenideElement button : sizeSelectionButtons){
            if(button.getAttribute("option-label").equals(size)){
                button.click();
                break;
            }
        }
    }

    public void selectColor(String color){
        colorSelectionBlock.shouldBe(Condition.visible);
        ElementSelectionHelper.clickElementByAttribute("option-label","Gray", colorSelectionButtons);
    }
}
