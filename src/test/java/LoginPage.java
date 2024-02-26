import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "login[username]")
    WebElement txtUserName;
    @FindBy(name = "login[password]")
    WebElement txtLPass;
    @FindBy(name = "send")
    WebElement btnLogin;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email, String password){
        txtUserName.sendKeys(email);
        txtLPass.sendKeys(password);
        btnLogin.click();
    }
}
