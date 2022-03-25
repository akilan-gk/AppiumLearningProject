package eCommerceAppAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ECommerce_TC_1 extends Capabilities {
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement nameField = driver.findElementById("com.androidsample.generalstore:id/nameField");
        nameField.sendKeys("Hello");
        driver.hideKeyboard();
        WebElement femaleCheckBox = driver.findElementByXPath("//*[@text='Female']");
        femaleCheckBox.click();
        WebElement countryCheckBox = driver.findElementById("android:id/text1");
        countryCheckBox.click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));
        WebElement argentina = driver.findElementByXPath("//*[@text='Argentina']");
        argentina.click();
        WebElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        letsShopButton.click();
}}
