import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {
    @Test
    public void doLogin(){
        LoginPage loginPage=new LoginPage(driver);

        //Directed to the site and login
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Sign In")).click();
        loginPage.doLogin("haakter.30@gmail.com","test@1234");


        //Add the product in the cart
        driver.get("https://magento.softwaretestingboard.com/radiant-tee.html");
        driver.findElement(By.id("option-label-size-143-item-166")).click();
        driver.findElement(By.id("option-label-color-93-item-57")).click();
        driver.findElement(By.id("product-addtocart-button")).click();


        //Verify the Successfully adding the product in the cart
        WebElement SuccessText = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div"));
        String Success_actual= SuccessText.getText();
        String Success_expected= "You added Radiant Tee to your shopping cart.";
        Assert.assertEquals(Success_actual,Success_expected);

        driver.findElement((By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a"))).click();
        WebElement CartText = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[1]/div/strong/a"));
        Assert.assertTrue(CartText.isDisplayed());
    }
}
