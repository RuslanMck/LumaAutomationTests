package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;


public abstract class PageNavigationHelper {

    /**
     * This method allows to scroll page to needed element
     * @param element is SelenideElement to be scrolled to
     */
    public static void ScrollPageToElement(SelenideElement element){
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    /**
     * This method allows to scroll until the searched SelenideElement appears on the page.
     * The WHILE loop checks if searched element is existed on the page. If not - the JavascriptExecutor executes
     * .executeScript("window.scrollBy(0, 1000)");
     * @param element SelenideElement that needs to be lazy loaded
     * @param scrollDepth value identifies the depth of scroll
     */
    public static void ScrollPageToLoadElement(SelenideElement element, int scrollDepth){
        while (!element.exists()){

            ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.scrollBy(0, "+scrollDepth+")");

            Selenide.sleep(scrollDepth);
        }
    }
}
