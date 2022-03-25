package practice;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AndroidUiAutomator extends Capabilities{
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        WebElement animation = driver.findElementByAndroidUIAutomator("text(\"Animation\")");
        animation.click();
        System.out.println("Clickable: " + driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(false)").size());
    }
}
