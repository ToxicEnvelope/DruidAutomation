package com.saverone.automaitons.locators;

import org.openqa.selenium.By;

public class AndroidCommonLocator {
    public static final By BLUETOOTH_SWITCH = By.xpath("//android.widget.LinearLayout/android.widget.Switch[3]");
    public static final By BLUETOOTH_BUTTON = By.xpath("//android.view.ViewGroup");
    public static final By ANDROID_ID_TITLE = By.id("android:id/title");
    public static final By APPLICATION_ICON_IN_VIEW = By.xpath("//android.widget.FrameLayout[@content-desc=\"%e%\"]");
    public static final By CLEAR_NOTIFICATIONS_BAR_AND_DISMISS = By.id("com.android.systemui:id/dismiss_view");
}
