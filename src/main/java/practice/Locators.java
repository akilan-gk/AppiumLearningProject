package practice;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Locators extends Capabilities{

    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement preferences = driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
        preferences.click();
        WebElement preferenceDependencies = driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']");
        preferenceDependencies.click();
        WebElement wifiCheckBox = driver.findElementById("android:id/checkbox");
        wifiCheckBox.click();
        WebElement wifiSettings = driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']");
        wifiSettings.click();
        WebElement wifiTextBox = driver.findElementByClassName("android.widget.EditText");
        wifiTextBox.sendKeys("Hello, Akilan");
        WebElement okButton = driver.findElementById("android:id/button1");
        okButton.click();
    }
}
