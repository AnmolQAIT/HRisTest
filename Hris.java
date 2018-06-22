/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MavenHris;

import com.google.j2objc.annotations.Weak;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
/**
 *
 * @author anmol
 */
public class Hris {
    Login login;WebDriver driver;
   
    @Test
    public void invokeHris()
    {
        driver=new ChromeDriver();
        driver.get("https://hris.qainfotech.com/login.php");
        login=new Login(driver);
    }
    
    @Test
	 public void LoginWithIncorrectpassword() 
         {

		 Assert.assertEquals( login.LoginByInvalidCredentials("anmol aggarwal", "Anmol"),"Invalid Login");
         }
         
    @Test
    public void LoginWithBlankPassword()
    {
        Assert.assertEquals(login.LoginByBlankPassword("anmolaggarwal",""),null);
    }
    
    @Test
    public void LoginWithCorrectCredentials()
    {
        Assert.assertFalse(login.LoginByCorrectCredentials("anmolaggarwal","Anmol@321#").isloginpage());
    }
}
