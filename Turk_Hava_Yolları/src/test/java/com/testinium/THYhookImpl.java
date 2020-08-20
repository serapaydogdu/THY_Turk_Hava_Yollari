package com.testinium;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class THYhookImpl {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeScenario
    public void setup () throws MalformedURLException {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("deviceName" , "emulator-5554");
        capability.setCapability("platformName", "Android");
        capability.setCapability("version", "7.0");
        capability.setCapability("appPackage", "com.turkishairlines.mobile");
        capability.setCapability("appActivity","com.turkishairlines.mobile.ui.ACSplash");
        capability.setCapability("autoGrantPermissions", true);
        capability.setCapability("autoDismissAlerts", true);
        capability.setCapability("autoAcceptAlerts", true);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capability);
        wait = new WebDriverWait(driver, 10);
        System.out.println("Connecting...");
    }

    @AfterScenario
    public void teardown(){
        if(driver != null){
            driver.quit();
        }

    }
}
