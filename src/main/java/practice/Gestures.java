package practice;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Gestures - Tap and Long press
 */

public class Gestures extends Capabilities{
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        TouchAction touchAction = new TouchAction(driver);
        WebElement expandableList = driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
        //tap
        touchAction.tap(tapOptions().withElement(element(expandableList))).perform();
        //long press
        WebElement customAdapter = driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
        customAdapter.click();
        WebElement peopleNames = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(Duration.ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }
}
