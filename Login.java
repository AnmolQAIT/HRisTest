package Login;

import org.openqa.selenium.*;
import static org.testng.Assert.*;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anmol
 */
public class LoginMain {
    WebDriver driver;
    public  LoginMain(WebDriver driver) 
    {
        this.driver=driver;
    }
    
    private WebElement gettextField()
    {
       return (this.driver.findElement(By.id("txtUserName")));
    }
    private WebElement getpasswordField()
    {
       return (this.driver.findElement(By.id("txtPassword")));
    }
    
    private void Enter(String username,String password)
    { driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        gettextField().clear();
		gettextField().sendKeys(username);
		getpasswordField().clear();
		getpasswordField().sendKeys(password);
		gettextField().submit();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    
    public String LoginByInvalidCredentials(String username, String password) {
		Enter(username, password);
		return driver.findElement(By.className("loginTxt")).getText();
	}
    
    public String LoginByBlankPassword(String username,String password)
    {
        Enter(username, password);
        return driver.findElement(By.id("txtPassword")).getAttribute("style");
    }
    public Timesheet LoginByCorrectCredentials(String username,String password)
    {
        Enter(username, password);
         return new Timesheet(driver);
    }
   
}
