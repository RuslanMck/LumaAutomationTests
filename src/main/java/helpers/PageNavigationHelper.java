package helpers;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

public abstract class PageNavigationHelper {

    /**
     * This method allows to scroll page to needed element
     * @param element is SelenideElement to be scrolled to
     */
    public static void ScrollPageToElement(SelenideElement element){
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

    }
}
