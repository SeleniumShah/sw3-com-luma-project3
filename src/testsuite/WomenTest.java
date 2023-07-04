package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WomenTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyTheSortByProductNameFilter() {

        //Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();

        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        actions.moveToElement(tops).build().perform();

        //Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        actions.moveToElement(jackets).click().build().perform();


        //Select Sort By filter “Product Name”
        WebElement dropDown = driver.findElement(By.xpath("//div[2]//div[3]//select[1]"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name ");

        //Verify alphabetical order

        List<WebElement> productAtoZ = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : productAtoZ) {
            System.out.println(result.getText());
        }
    }


    @Test
    public void verifyTheSortByPriceFilter(){
        //Mouse Hover on Women Menu
        WebElement women = driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(women).build().perform();

        //Mouse Hover on Tops
        WebElement tops = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
        actions.moveToElement(tops).build().perform();

        //Click on Jackets
        WebElement jackets = driver.findElement(By.xpath("//a[@id='ui-id-11']"));
        actions.moveToElement(jackets).click().build().perform();


        //Select Sort By filter “Price”
        WebElement dropDown = driver.findElement(By.xpath("//div[2]//div[3]//select[1]"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price ");


        // Verify price Low to high
        List<WebElement> priceLowToHigh = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : priceLowToHigh) {
            System.out.println(result.getText());
        }

}

    @After
    public void tearDown(){
        closeBrowser();
    }
}