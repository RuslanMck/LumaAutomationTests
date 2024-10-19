package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import data.ExpactedLinksAddress;
import lombok.Getter;

@Getter
public class CategoryPage extends BasicPageElements{

    private ElementsCollection productsInGreed = Selenide.$$(".product-item");
    private final String BASE_URL = ExpactedLinksAddress.CATEGORY_PAGE.getValue();

    public void clickProduct(int position){
        productsInGreed.get(position).click();
    }
}
