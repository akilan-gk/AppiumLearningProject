package generalStoreMobileAutomation.testScripts;

import generalStoreMobileAutomation.reUsables.ActionReUsables;
import generalStoreMobileAutomation.suiteFile.GeneralStoreBase;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddingProductToCartTest extends GeneralStoreBase {
    static Logger logger = Logger.getLogger(AddingProductToCartTest.class);

    @Test
    public void testAddingProductToCart() {
        String productOne = testDataPropertyObject.getProperty("productOne");
        String productTwo = testDataPropertyObject.getProperty("productTwo");
        logger.info("Searching and adding the products into the cart");
        ActionReUsables.click(ActionReUsables.findProduct(driver, locatorsPropertyObject.getProperty("productOne")));
        ActionReUsables.click(ActionReUsables.findProduct(driver, locatorsPropertyObject.getProperty("productTwo")));
        logger.info("Opening the cart");
        ActionReUsables.click(ActionReUsables.findElement(driver, "ID", locatorsPropertyObject.getProperty("cart")));
        logger.info("Verifying that the added products in the cart are same as the user's choice");
        List<AndroidElement> productNameElements = ActionReUsables.findElements(driver, "ID", locatorsPropertyObject.getProperty("productNames"));
        for (AndroidElement product : productNameElements) {
            String name = ActionReUsables.getText(product);
            boolean result = name.equals(productOne) || name.equals(productTwo);
            Assert.assertTrue(result, "Product Mismatch: " + name);
            logger.info("Products Matched");
        }
    }
}

