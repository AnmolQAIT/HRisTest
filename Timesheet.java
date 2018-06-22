/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MavenHris;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

/**
 *
 * @author anmol
 */
public class Timesheet {
    WebDriver driver;
    public Timesheet(WebDriver driver) 
    {
        this.driver=driver;
    }
    public boolean isloginpage() {
		return this.driver.getCurrentUrl().equals("https://hris.qainfotech.com/login.php");
	}
}
