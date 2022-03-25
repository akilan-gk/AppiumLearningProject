package eCommerceAppAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {
    public static String getAppPath() {
        String userDirectory = System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        return userDirectory + pathSeparator + "src" + pathSeparator + "main" + pathSeparator + "java" + pathSeparator +
                "eCommerceAppAutomation" + pathSeparator + "apkFile" + pathSeparator + "General-Store.apk";
    }

    public static AndroidDriver<AndroidElement> capabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PixelXLTiramisuEmulator");
        capabilities.setCapability(MobileCapabilityType.APP, getAppPath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
        AndroidDriver<AndroidElement> androidDriver = null;
        try {
            androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException exception) {
            System.out.println("Check the passed url is legal and its following proper protocol.");
        }
        return androidDriver;
    }
}
