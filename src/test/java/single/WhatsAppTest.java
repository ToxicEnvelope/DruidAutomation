package single;

import base.BaseTest;
import com.saverone.automaitons.utils.WaitTime;
import com.saverone.automaitons.views.AndroidViewController;
import org.testng.annotations.Test;

import java.io.IOException;

public class WhatsAppTest extends BaseTest {

    private final String WHATS_APP_ICON = "WhatsApp";

    @Test(priority = 1)
    public void openWhatsAppThenRegisterFormTheFirstTimeTest() throws IOException {

        AndroidViewController androidViewCtrl = new AndroidViewController(driver);
        androidViewCtrl.openTargetApplication(WHATS_APP_ICON);
        androidViewCtrl.openNotificationBar();
        try {
            Thread.sleep(WaitTime.SHORT_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        androidViewCtrl.clearNotificationsAndCloseBar();
//        androidViewCtrl.openNotificationBarThenTurnOnBleAndPairWith("");

//        WhatsAppRegisterView view = new WhatsAppRegisterView(driver);
//        view.clickContinueAndAgree();
//        view.expandCountriesDropDownAndSelect("");
//        view.setRegistrationPhoneNumber("");
    }
}

