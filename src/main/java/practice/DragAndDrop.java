package practice;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DragAndDrop extends Capabilities{
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement views = driver.findElementByAndroidUIAutomator("text(\"Views\")");
        views.click();
        WebElement dragAndDrop = driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']");
        dragAndDrop.click();
        WebElement source = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
        TouchAction action = new TouchAction(driver);
        action.longPress(LongPressOptions.longPressOptions().withElement
                (ElementOption.element(source))).moveTo(ElementOption.element(destination)).release().perform();
    }
}
