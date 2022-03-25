package eCommerceAppAutomation;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ECommerce_TC_3 extends Capabilities{
    public static void main(String[] args) {
        AndroidDriver<AndroidElement> driver=capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Hello");
        driver.hideKeyboard();
        driver.findElementByXPath("//*[@text='Female']").click();
        driver.findElementById("android:id/text1").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
        driver.findElementByXPath("//*[@text='Argentina']").click();
        driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
        int count=    driver.findElementsById("com.androidsample.generalstore:id/productName").size();
        for(int i=0;i<count;i++)
        {
            String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
            if(text.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
                break;
            }
        }
        driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
        String lastPageText=    driver.findElementById("com.androidsample.generalstore:id/productName").getText();
        Assert.assertEquals("Jordan 6 Rings", lastPageText);
    }
}
