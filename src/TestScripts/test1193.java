// #####################################################################
// #1193 Extend Lock and Unlock Functionality for semester lock
//
// Description:
// As a User I would like to set a Semester to Inactive so that professors 
// can't propose projects for old semesters.
// 
// Acceptance Criteria:
// Terms collection updated
// When a term is locked, any project from that semester is locked
// Projects cannot be proposed for locked semesters
// #####################################################################

package TestScripts;
import vip4_userstorytesting.LiveServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class test1193 extends UserStoryTest 
{
    String input; 
    boolean passed = true; 
    private String header; 
    
    public test1193()
    {
        this.ID = 1193;
        this.title = "Extend Lock and Unlock Functionality for semester lock"; 
        this.header = ID + " " + title + "\n\t";
        System.out.print(header);
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
     try{ 
         
         
        }
     catch(Exception e){passed = false; }

     if (!passed)
         System.out.println("FAIL"); 
     else
         System.out.println("PASS");
 }    
}
