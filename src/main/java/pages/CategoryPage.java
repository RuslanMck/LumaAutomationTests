package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import data.ExpactedLinksAddress;
import lombok.Getter;

import java.time.Duration;

@Getter
public class CategoryPage extends BasicPageElements{

    private ElementsCollection productsInGreed = Selenide.$$(".product-item").filter(Condition.visible);
    private final String BASE_URL = ExpactedLinksAddress.CATEGORY_PAGE.getValue();

    public void clickProduct(int position){
        Selenide.executeJavaScript("window.scrollBy(0, 1400);");
        productsInGreed.get(position).scrollIntoView(true).shouldBe(Condition.visible, Duration.ofSeconds(10));
        productsInGreed.filter(Condition.visible).get(position).click();
    }
}
