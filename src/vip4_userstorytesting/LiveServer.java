/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vip4_userstorytesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Dafna
 */
public interface LiveServer {
    
       WebDriver driver = new SafariDriver();  
       WebDriverWait  wait = new WebDriverWait(driver, 10); 
       Routines routines = new Routines(); 
              
       public static void StartDriver() throws InterruptedException
       {
           driver.get("http://www.vip.fiu.edu");
           Thread.sleep(1000); 
           
           System.out.println("Navigated to VIP.FIU.edu"); 
       }
       
       public static void EndDriver()
       {
           driver.quit();
             driver.manage().deleteAllCookies();
       }
}
