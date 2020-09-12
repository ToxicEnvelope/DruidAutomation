package com.saverone.automaitons.views;

import com.saverone.automaitons.base.BaseAppView;
import com.saverone.automaitons.locators.WhatsAppRegisterViewLocators;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

public class WhatsAppRegisterView extends BaseAppView {

    public WhatsAppRegisterView(AppiumDriver driver) throws IOException {
        super(driver);
    }

    public void clickContinueAndAgree() {
        super.waitClick(WhatsAppRegisterViewLocators.CONTINUE_AND_ACCEPT_BUTTON);
    }

    public void expandCountriesDropDownAndSelect(String country)
    {
        super.waitClick(WhatsAppRegisterViewLocators.REGISTRATION_COUNTRY_DROPDOWN);
        super.waitClick(WhatsAppRegisterViewLocators.SEARCH_REGISTRATION_COUNTRY_BUTTON);
        super.waitSendKeys(WhatsAppRegisterViewLocators.SEARCH_REGISTRATION_COUNTRY_INPUT, country);
        super.waitClick(WhatsAppRegisterViewLocators.COUNTRY_FIRST_NAME_RESULT);
    }

    public void setRegistrationPhoneNumber(String phoneNumber)
    {
        super.waitSendKeys(WhatsAppRegisterViewLocators.REGISTRATION_PHONE_NUMBER_INPUT, phoneNumber);
        super.waitClick(WhatsAppRegisterViewLocators.NEXT_BUTTON);
    }
}
