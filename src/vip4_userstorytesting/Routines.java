
package vip4_userstorytesting;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class Routines
{
    private boolean loggedIn = false; 

    
    private final WebDriver dr = LiveServer.driver; 
    private final WebDriverWait  wait= LiveServer.wait; 
    
    private WebElement loginButton, googleEmailField, googlePasswordField, 
            googleButton, vipEmailField, vipPasswordField; 
                    
    public Routines()
    {
    }
    
    public void toHomepage() 
    {
        dr.get("http://www.vip.fiu.edu");
    }
    
    public void toAdminPanel() throws InterruptedException
    {
        while (!dr.getCurrentUrl().contains("adminpanel"))
        {
            Thread.sleep(500);
            fetch(By.cssSelector("i.fa.fa-wrench")).click();
        }
    }
    
    public void toProjectPage() throws InterruptedException
    {
           while (!dr.getCurrentUrl().contains("vip-projects"))
        {
            Thread.sleep(500);
            
            fetch(By.xpath("//div[@id='bs-example-navbar-collapse-1']//a[.='PROJECTS ']")).click(); 
        }
    }
    
    public void toProjectProposalPage() throws InterruptedException 
    {
            while (!dr.getCurrentUrl().contains("project-proposal"))
        {
            Thread.sleep(500);
            
            WebElement parentMenu = fetch(By.xpath("//div["
                    + "@id='bs-example-navbar-collapse-1']//a[.='FACULTY']")); 
           
            parentMenu.click();
            
            fetch(By.xpath(
                    "//div[@id='bs-example-navbar-collapse-1']"
                            + "//a[.='PROPOSE PROJECT']")).click(); 
        }
    }
    
    public void toProjectApprovePage() throws InterruptedException 
    {
            while (!dr.getCurrentUrl().contains("reviewproject"))
        {
            Thread.sleep(500);
            
            WebElement parentMenu = fetch(By.xpath("//div["
                    + "@id='bs-example-navbar-collapse-1']//a[.='FACULTY']")); 
           
            parentMenu.click();
            
            fetch(By.xpath(
                    "//div[@id='bs-example-navbar-collapse-1']"
                            + "//a[.='REVIEW PROJECT PROPOSALS']")).click(); 
        }   
    }
    protected boolean isElementPresent(By by){
        try{
            dr.findElement(by);
            return true;
        }
        catch(NoSuchElementException nse)
        {
            return false; 
        }
    }
    
    public int matchFromList(List<WebElement> wlist, String input)
    {
        int counter = wlist.size(); 
        
        for(int i = 0; i < counter; i++) 
        {
            String str = wlist.get(i).getText();
            //System.out.print(str);
            
            if (str.toUpperCase().contains(input))
            {
                return i;  
            }
        }
        
        return -1; 
    }
    
    public WebElement fetch(By statement)
    {    
        WebElement wElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(statement)); 

        if (wElement.toString().equals(""))
            return fetch(statement); 
        else
            
        return wElement;
    }
    
    public void logout() throws InterruptedException 
    {
        if (!loggedIn)
            return; 
        
        Thread.sleep(1000);
        //System.out.println("Attempting to log out...");
        
        WebElement logOutButton;
        logOutButton = fetch(By.xpath("//div[@class='loginHeader']//button[.='Log Out']")); 
        
        logOutButton.click();
        
        loggedIn = false; 
        
        //System.out.println("User has been logged out!");
    }
    
    private void login() 
    {
         loginButton = fetch(By.className("btn btn-primary log-btn"));  
         loginButton.click();
    }
    
     public void loginAdmin(String username, String password)
    {
        loginProf(username, password); 
    }
     
    public void loginProf(String username, String password)
    {
      //  System.out.println("Attempting to log in as professor / admin");
        
        login(); 
        vipEmailField = fetch(By.id("email")); 
        vipPasswordField = fetch(By.id("password"));
        
        vipEmailField.click(); 
        vipEmailField.sendKeys(username);
        
        vipPasswordField.click(); 
        vipPasswordField.sendKeys(password);
        
        WebElement localloginButton = fetch(By.id("login")); 
        
        while(dr.getCurrentUrl().contains("vip.fiu.edu/#/login"))
            localloginButton.click(); 
        while(dr.getCurrentUrl().contains("/login") ||dr.getCurrentUrl().contains("proxy") )
        {// wait
            
        }
        
        
        // System.out.println("Professor / admin login successful!");
         loggedIn = true; 
    }
    
    public void loginStudent(String username, String password) throws InterruptedException
    {
        //System.out.println("Attempting to log in as student");
        
        login(); 
    
        googleButton = fetch(By.className("fa fa-2x fa-google btn btn-danger"));
        googleButton.click(); 
    
        googleEmailField = fetch(By.id("identifierId"));
    
        googleEmailField.click(); 
        googleEmailField.clear();
        googleEmailField.sendKeys(username);
    
        WebElement nextButton; 
        nextButton = dr.findElement(By.className("RveJvd snByac")); 
        nextButton.click();
    
       googlePasswordField = fetch(By.name("password"));
    
       googlePasswordField.sendKeys(password);
       googlePasswordField.sendKeys("\n");
       
        Thread.sleep(1000); 
    
        nextButton = dr.findElement(By.className("RveJvd snByac")); 

        nextButton.click(); 
        nextButton.click(); 
        
        while(dr.getCurrentUrl().contains("google")){} 
        
      // System.out.println("Student login successful!");
       loggedIn = true; 
    }
    
}