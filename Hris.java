package Login;

import com.google.j2objc.annotations.Weak;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;
/**
 *
 * @author anmol
 */
public class Hris {
    LoginMain login;
    WebDriver driver;
    Timesheet timesheet;
   
    @BeforeClass
    public void invokeHris()
    {
        driver=new ChromeDriver();
        driver.get("https://hris.qainfotech.com/login.php");
        login=new LoginMain(driver);
    }
    
    @Test(priority=1)
	 public void LoginWithIncorrectpassword() 
         {
		 Assert.assertEquals(login.LoginByInvalidCredentials("anmol aggarwal", "Anmol"),"Invalid Login");
         }
         
    @Test(priority=2)
    public void LoginWithBlankPassword()
    { String str="border: 1px solid red;";
        Assert.assertEquals(login.LoginByBlankPassword("anmolaggarwal",""),str);
    }
    
    @Test(priority=3)
    public void LoginWithCorrectCredentials()
    { 
    	timesheet=login.LoginByCorrectCredentials("anmolaggarwal","Anmol@321#");
        Assert.assertFalse(timesheet.isloginpage());
     }
    
//    @Test
//    public void gettimefromTimesheetpage()
//    {
//     Assert.assertTrue(condition);
//    }
    
    @Test(priority=4)
    public void logout()
    {
    Assert.assertTrue(timesheet.isTimesheetPage());
    String str=timesheet.logout();
    Assert.assertEquals(str,"https://hris.qainfotech.com/login.php");
    }
    
}
