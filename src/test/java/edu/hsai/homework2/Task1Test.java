package edu.hsai.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Task1Test extends DriverSetup {
    @Test
    public void testTask1() {
        SoftAssert softAssert = new SoftAssert();

        // 2. Assert browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        // 4. Assert Username is logged in


        // 5. Assert that there are 4 items on the header section are displayed, and they have proper texts


        // 6. Assert that there are 4 images on the Index Page, and they are displayed


        // 7. Assert that there are 4 texts on the Index Page under icons, and they have proper text


        // 8. Assert that there is the iframe with “Frame Button” exist


        // 9.  Switch to the iframe and check that there is “Frame Button” in the iframe


        // 10. Switch to original window back


        // 11. Assert that there are 5 items in the Left Section are displayed, and they have proper text


        softAssert.assertAll();
    }
}
