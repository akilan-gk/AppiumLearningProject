package eCommerceAppAutomation;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ECommerce_TC_4 extends Capabilities {
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
        int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
        double sum = 0;
        for (int index = 0; index < count; index++) {
            String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(index).getText();
            double amount = getAmount(amount1);
            sum = sum + amount;
        }
        System.out.println(sum + "sum of products");
        String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
        total = total.substring(1);
        double totalValue = Double.parseDouble(total);
        System.out.println(totalValue + "Total value of products");
        Assert.assertEquals(sum, totalValue);
        WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
        TouchAction action = new TouchAction(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(checkbox))).perform();
        WebElement tc = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(tc)).withDuration(Duration.ofSeconds(2))).release().perform();
        driver.findElementById("android:id/button1").click();
        driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
    }

    public static double getAmount(String value) {
        value = value.substring(1);
        return Double.parseDouble(value);
    }
}

