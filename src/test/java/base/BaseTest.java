package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.*;

import java.io.File;
import java.net.*;

public abstract class BaseTest {

    public AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp()
    {
        File file = new File(Config.BIN_DIRECTORY.concat("/WhatsApp.apk"));
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(CustomCapabilityType.NO_RESET, true);
        capabilities.setCapability(CustomCapabilityType.FULL_RESET, false);
//        capabilities.setCapability(CustomCapabilityType.APP, file.getAbsolutePath());
        capabilities.setCapability(CustomCapabilityType.AUTOMATION_NAME, AppiumUtils.AUTOMATION_NAME);
        capabilities.setCapability(CustomCapabilityType.DEVICE_NAME, Devices.XiaomiF1.DEVICE_NAME);
        capabilities.setCapability(CustomCapabilityType.UDID, Devices.XiaomiF1.UDID);
        capabilities.setCapability(CustomCapabilityType.PLATFORM_NAME, Devices.XiaomiF1.PLATFORM_NAME);
        capabilities.setCapability(CustomCapabilityType.PLATFORM_VERSION, Devices.XiaomiF1.PLATFORM_VERSION);
//        capabilities.setCapability(CustomCapabilityType.DEVICE_NAME, Devices.AndroidEmulator.DEVICE_NAME);
//        capabilities.setCapability(CustomCapabilityType.UDID, Devices.AndroidEmulator.UDID);
//        capabilities.setCapability(CustomCapabilityType.PLATFORM_NAME, Devices.AndroidEmulator.PLATFORM_NAME);
//        capabilities.setCapability(CustomCapabilityType.PLATFORM_VERSION, Devices.AndroidEmulator.PLATFORM_VERSION);
//        capabilities.setCapability(CustomCapabilityType.APP_PACKAGE, "com.whatsapp");
//        capabilities.setCapability(CustomCapabilityType.APP_ACTIVITY, "com.whatsapp.Main");

        try {
            driver = new AndroidDriver<>(new URL(AppiumUtils.LOCALHOST_URL), capabilities);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @AfterClass
    public void tearDown()
    {
        if (driver != null) { driver.quit(); }
    }

}
