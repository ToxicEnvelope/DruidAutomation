package com.saverone.automaitons.views;

import com.saverone.automaitons.base.BaseAppView;
import com.saverone.automaitons.locators.AndroidCommonLocator;
import com.saverone.automaitons.utils.CommonAttributes;
import com.saverone.automaitons.utils.States;

import com.saverone.automaitons.utils.WaitTime;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.util.List;

public class AndroidViewController extends BaseAppView {

    public AndroidViewController(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void openNotificationBar()
    {
        ((AndroidDriver) _driver).openNotifications();
    }

    public void clearNotificationsAndCloseBar()
    {
        MobileElement mainFrame = _driver.findElement(AndroidCommonLocator.CLEAR_NOTIFICATIONS_BAR_AND_DISMISS);
        mainFrame.click();
    }

    public void openNotificationBarThenTurnOnBleAndPairWith(String pairingTargetName)
    {
        try {
            this.openNotificationBar();
            MobileElement bluetoothSwitch = _driver.findElement(AndroidCommonLocator.BLUETOOTH_SWITCH);
            MobileElement bluetoothButton = bluetoothSwitch.findElement(AndroidCommonLocator.BLUETOOTH_BUTTON);
            String attributeValue = bluetoothButton.getAttribute(CommonAttributes.CONTENT_DESC);
            int x = bluetoothButton.getLocation().getX();
            int y = bluetoothButton.getLocation().getY();
            if (attributeValue.contains(States.TURNED_OFF)) {
                bluetoothButton.click();
            }
            _action.longPress(PointOption.point(x, y)).waitAction().release().perform();
            List<MobileElement> sourcesList = _driver.findElements(AndroidCommonLocator.ANDROID_ID_TITLE);
            for (MobileElement source : sourcesList) {
                if (source.getText().equals(pairingTargetName)) {
                    source.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openTargetApplication(String targetApp)
    {
        try {
            String finalLocator = AndroidCommonLocator.APPLICATION_ICON_IN_VIEW
                    .toString().replace("%e%", targetApp);
            MobileElement application = _driver.findElement(toByObject(finalLocator));
            application.click();
            Thread.sleep(WaitTime.MEDIUM_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
