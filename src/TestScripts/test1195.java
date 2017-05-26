
// #####################################################################
// #1195 Add a search Box in VIP projects page
//
// Description:
// As a user I would like to have a Search box which would let me search for
// the projects easily.
//
// Acceptance Criteria:
// When any word is entered the respective project should be displayed.
// #####################################################################

package TestScripts;
import java.util.List;
import vip4_userstorytesting.LiveServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class test1195 extends UserStoryTest 
{
    private String input = "Be on the look"; 
    boolean passed = true; 
    private String header; 
    
    
    private void build() 
    {
        this.ID = 1195;
        this.title = "Add a search Box in VIP projects page"; 
        this.header = ID + " " + title + "\n\t";
    }
    
    public test1195()
    {
        build(); 
    }
    
    public test1195(String input)
    {
        this.input = input; 
    }
    
@Override 
 public void setUp() throws Exception
 {
     // none; does not require log-in 
 }
 
 @Override
 public void tearDown() throws Exception
 {
     LiveServer.routines.toHomepage(); 
 }
 
 @Override 
 public void RunPartial() throws Exception 
 {
        System.out.print(header);
        
     try{ 
         
         WebElement searchBox; 
         List<WebElement> results; 
         
         LiveServer.routines.toProjectPage();
         searchBox = LiveServer.routines.fetch(
         By.xpath("//div[@class='container']/div/div/div[2]/table/tbody/"
                 + "tr/td[2]/label/input"));
         
         searchBox.click();
         searchBox.clear();
         searchBox.sendKeys(input);
         
         results = LiveServer.driver.findElements(By.className(
         "col-md-6 project-info ng-scope")); 
                 
         int count = results.size(); 
         for (int i = 0; i < count; i++)
         {
             WebElement res = results.get(i); 
             String str = res.getText(); 
             
             passed = str.toUpperCase().contains(input.toUpperCase()); 
             
             if (!passed)
                 break; 
         }
         
        }
     
     catch(Exception e){passed = false; }

     if (!passed)
         System.out.println("FAIL"); 
     else
         System.out.println("PASS");
 }    
}
