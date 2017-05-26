
// #####################################################################
// #1158 Search name in admin panel 
//  
// Description:
// As a user, I would like to search the students in the list of Users 
// available in the admin panel so that it would be feasible for quick 
// navigation.
//
// Acceptance Criteria:
// Admin panel should be open without any errors
// Search box should result in finding the students if they are available 
// in the list
// #####################################################################


package TestScripts;
import vip4_userstorytesting.LiveServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import vip4_userstorytesting.Data;

public class test1158 extends UserStoryTest 
{
    
    private String input = "Dafna S"; 
    private String header; 
    
    boolean passed = true; 
   
    private void build()
    {
        this.ID = 1158; 
        this.title = "Search name in admin panel"; 
        this.header = ID + " " + title + "\n\t";
    }
    
     public test1158()
    {
       build(); 
    }
    
    public test1158(String input)
    {
        this.input = input; 
        build(); 
    }
    
@Override 
 public void setUp() throws Exception
 {
     Thread.sleep(500); 
     LiveServer.routines.loginAdmin(Data.PROF_EMAIL, Data.PROF_PW);
 }
 
 @Override
 public void tearDown() throws Exception
 {
     Thread.sleep(500); 
     LiveServer.routines.logout(); 
 }
 
 @Override 
 public void RunPartial() throws Exception 
 {
     System.out.print(header);
     
     try{ 
         
         WebElement searchBox, userButton, infoPanel; 
         
         LiveServer.routines.toAdminPanel();
         Thread.sleep(2000); 
        
        searchBox = LiveServer.routines.fetch(By.name("search")); 
        searchBox.click(); 
        searchBox.clear();
        searchBox.sendKeys(input);
        
        
         userButton = LiveServer.routines.fetch(
                 By.xpath("//div/div/div[1]/div/div[2]/table/tbody/tr[3]/td/"
                         + "button")); 
         
         userButton.click();
         
         infoPanel = LiveServer.routines.fetch(
                 By.xpath("//div[@class='container']/div/div[1]/div/div[3]"));
         
         infoPanel.click();   
         String infoText = infoPanel.getText();
      
         passed = infoText.toUpperCase().contains(input.toUpperCase()); 
         
        }
     catch(Exception e){passed = false; }

     if (!passed)
         System.out.println("FAIL"); 
     else
         System.out.println("PASS");
 }    
}
