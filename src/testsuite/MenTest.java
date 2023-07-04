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

public class MenTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
        public void userShouldAddProductSuccessFullyToShoppinCart(){
            WebElement men=driver.findElement(By.xpath("//a[@id='ui-id-5']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(men).build().perform();

            WebElement bottoms =driver.findElement(By.xpath("//a[@id='ui-id-18']"));
            actions.moveToElement(bottoms).build().perform();

            WebElement pants =driver.findElement(By.xpath("//a[@id='ui-id-23']"));
            actions.moveToElement(pants).click().build().perform();

            //Mouse hover on cronus yogs pant
            WebElement productName= driver.findElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            actions.moveToElement(productName).build().perform();

            // click on size 32
            driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']")).click();

            // click on colour black
            driver.findElement(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']")).click();

            // click on add to cart
            driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]")).click();

            //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
            String expectedText="You added Cronus Yoga Pant to your shopping cart.";
            String actualText= driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
            Assert.assertEquals(expectedText,actualText);

            //Click on ‘shopping cart’ Link into message
            driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

            //Verify the text ‘Shopping Cart.’
            String expectedText1="Shopping Cart";
            String actualText1= driver.findElement(By.xpath("//body/div[1]/main[1]/div[1]/h1[1]/span[1]")).getText();
            Assert.assertEquals(expectedText1,actualText1);

            //verify the product name ‘Cronus Yoga Pant’
            String expectedText2="Cronus Yoga Pant";
            String actualText2= driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/strong[1]/a[1]")).getText();
            Assert.assertEquals(expectedText2,actualText2);

            // Verify the product size ‘32’
            String expectedText3="32";
            String actualText3= driver.findElement(By.xpath("//dd[contains(text(),'32')]")).getText();
            Assert.assertEquals(expectedText3,actualText3);

            //Verify the product colour ‘Black’
            String expectedText4="Black";
            String actualText4= driver.findElement(By.xpath("//dd[contains(text(),'Black')]")).getText();
            Assert.assertEquals(expectedText,actualText);
        }
    @After
    public void tearDown(){
        closeBrowser();
    }


}


