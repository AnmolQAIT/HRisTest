/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MavenHris;

import org.openqa.selenium.*;
import static org.testng.Assert.*;

/**
 *
 * @author anmol
 */
public class Login {
    WebDriver driver;
    public  Login(WebDriver driver) 
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
    {
                gettextField().clear();
		gettextField().sendKeys(username);
		getpasswordField().clear();
		getpasswordField().sendKeys(password);
		gettextField().submit();
    }
    
    public String LoginByInvalidCredentials(String username, String password) {
		Enter(username, password);
		return driver.findElement(By.className("loginTxt")).getText();
	}
    
    public String LoginByBlankPassword(String username,String password)
    {
        Enter(username, password);
        return driver.findElement(By.className("loginTxt")).getText();
    }
    public Timesheet LoginByCorrectCredentials(String username,String password)
    {
        Enter(username, password);
         return new Timesheet(driver);
    }
}
