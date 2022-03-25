package practice;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Swipe extends Capabilities {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        WebElement dateWidgets = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
        dateWidgets.click();
        WebElement inline = driver.findElementByAndroidUIAutomator("text(\"2. Inline\")");
        inline.click();
        WebElement nine = driver.findElementByXPath("//*[@content-desc='9']");
        nine.click();
        TouchAction action = new TouchAction(driver);
        WebElement first = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second = driver.findElementByXPath("//*[@content-desc='45']");
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(first)).
                withDuration(Duration.ofSeconds(2))).moveTo(ElementOption.element(second)).release().perform();
    }
}
