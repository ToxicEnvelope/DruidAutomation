package com.saverone.automaitons.base;

import com.saverone.automaitons.utils.WaitTime;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public abstract class BaseAppView {

    public AppiumDriver<MobileElement> _driver;
    public TouchAction _action;

    public BaseAppView(AppiumDriver<MobileElement> driver) {
        _driver = driver;
        _action = new TouchAction(_driver);
    }

    protected void waitClick(By by)
    {
        try {
            new WebDriverWait(_driver, WaitTime.MAXIMUM_DRIVER_WAIT, WaitTime.POLLING_FREQUENCY)
                    .until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
            throw e;
        }
    }

    protected void waitSendKeys(By by, String value)
    {
        try {
            WebElement prxyElem = new WebDriverWait(_driver, WaitTime.MAXIMUM_DRIVER_WAIT, WaitTime.POLLING_FREQUENCY)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            if (prxyElem.isDisplayed() && prxyElem.isEnabled())
            {
                prxyElem.clear();
                prxyElem.sendKeys(value);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public By toByObject(String byAsString)
    {
        String[] parsedByString = byAsString.split(" ");
        String method = parsedByString[0];
        String locator = parsedByString[1];
        By by = switch (method) {
            case "By.id:" -> By.id(locator);
            case "By.linkText:" -> By.linkText(locator);
            case "By.partialLinkText:" -> By.partialLinkText(locator);
            case "By.name:" -> By.name(locator);
            case "By.tagName:" -> By.tagName(locator);
            case "By.xpath:" -> By.xpath(locator);
            case "By.className:" -> By.className(locator);
            case "By.cssSelector:" -> By.cssSelector(locator);
            default -> null;
        };
        return by;
    }

}
