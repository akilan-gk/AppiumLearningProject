package eCommerceAppAutomation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ECommerce_TC_5 extends Capabilities {
    public static void main(String[] args) throws InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//*[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        Thread.sleep(4000);
        WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();
        WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
        Thread.sleep(7000);
        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName);
        }
        driver.context((String) contexts.toArray()[1]);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Hello");
        searchBox.sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
    }
}
