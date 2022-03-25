package eCommerceAppAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ECommerce_TC_2 extends Capabilities{
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver = capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement letsShopButton = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        letsShopButton.click();
        String toastMessage=driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage,"Please enter your name");//Actual validation
    }
}
