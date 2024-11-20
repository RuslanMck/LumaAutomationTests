package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class LogoutPage {

    private SelenideElement pageTitle = Selenide.$("h1");

    public String getPageTitle(){
        return pageTitle.text();
    }

    public boolean isPageClosedAfterTimeout(int timeout){
        pageTitle.shouldBe(Condition.hidden, Duration.ofSeconds(timeout));
        return pageTitle.is(Condition.disappear);
    }
}
