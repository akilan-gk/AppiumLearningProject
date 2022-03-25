package practice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Scrolling extends Capabilities {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver=capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        views.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }
}
