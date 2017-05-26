// #####################################################################
// JUST A TEMPLATE 
// #####################################################################

package TestScripts;
import vip4_userstorytesting.LiveServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class test0000 extends UserStoryTest 
{
    boolean passed = true; 
    private String header; 
    String input; 
    
    public test0000()
    {
        this.ID = 0;
        this.title = ""; 
        this.header = ID + " " + title + "\n\t";
    }
    
@Override 
 public void setUp() throws Exception
 {
 }
 
 @Override
 public void tearDown() throws Exception
 {
 }
 
 @Override 
 public void RunPartial() throws Exception 
 {
    System.out.print(header);
     try{ 
         
         
        }
     catch(Exception e){passed = false; }

     if (!passed)
         System.out.println("FAIL"); 
     else
         System.out.println("PASS");
 }    
}
