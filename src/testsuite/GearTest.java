package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GearTest extends BaseTest {

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
// Mouse Hover on Gear Menu
        WebElement gear = driver.findElement(By.xpath("//span[contains(text(),'Gear')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).build().perform();
        driver.navigate().to("https://magento.softwaretestingboard.com/gear/bags.html");

        //click on bags
        //driver.findElement(By.xpath("//a[@id='ui-id-25']//span[contains(text(),'Bags')]")).click();

        // Click on Product Name ‘Overnight Duffle’
        driver.findElement(By.xpath("//a[contains(text(),'Overnight Duffle')]")).click();

        //Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Overnight Duffle')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        // Change Qty 3
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("3");

        //Click on ‘Add to Cart’ Button.
        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();

        // Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedText1, actualText1);

        // Click on ‘shopping cart’ Link into message
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

        //Verify the product name ‘Overnight Duffle’
        String expectedText2 = "Overnight Duffle";
        String actualText2 = driver.findElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")).getText();
        Assert.assertEquals(expectedText2, actualText2);

        //Verify the Qty is ‘3’
        String expectedText3 = "3";
        String actualText3 = driver.findElement(By.xpath("//input[@id='cart-236154-qty']")).getText();
        Assert.assertEquals(expectedText3, actualText3);

        //Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']")).getText();
        Assert.assertEquals(expectedText4, actualText4);

        //Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@id='cart-236154-qty']")).clear();
        driver.findElement(By.xpath("//input[@id='cart-236154-qty']")).sendKeys("5");

        //Click on ‘Update Shopping Cart’ button
        driver.findElement(By.xpath("//span[normalize-space()='Update Shopping Cart']")).click();

        //Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        String actualText5 = driver.findElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$225.00']")).getText();
        Assert.assertEquals(expectedText5, actualText5);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
