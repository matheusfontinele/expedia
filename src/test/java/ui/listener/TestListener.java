package ui.listener;

import org.testng.*;

public class TestListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir").concat("/src/main/resources/driver/chromedriver.exe"));
    }

    @Override
    public void onFinish(ISuite suite) {
    }
}
