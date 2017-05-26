
// #####################################################################
// #1101 Add lock and unlock for projects in the teams page 
// 
//  Description:
//  As a PI of the website I would like to be able to:
//  - lock&unlock the project for now(so nobody can apply),
//  - Move the fall semester projects to the fall folder and 
//  - when new faculties apply for a project they can’t apply 
// for the fall any more and their new proposed projects goes to the spring 
// folder
// 
//  Acceptance Criteria:
//  Archives should be still available with a link or logo from new similar 
//  projects (PI add them manually like GitHub or Mingle link)
//  if it’s possible lock should be one for whole semester. and another way for
//  a specific project.
//  Pi must be enable to set and change
//  taking care of teams page application form
//  taking care of join buttons in the team page
// #####################################################################

package TestScripts;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;
import java.util.List;
import vip4_userstorytesting.LiveServer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import vip4_userstorytesting.Data;


public class test1101 extends UserStoryTest 
{
    String input; 
    boolean passed = true; 
    private String header; 
    
    public test1101()
    {
        this.ID = 1101;
        this.title = "Add lock and unlock for projects in the teams page "; 
        this.header = ID + " " + title + "\n\t";
    }
    
@Override 
 public void setUp() throws Exception
 {
     LiveServer.routines.loginAdmin(Data.PROF_EMAIL, Data.PROF_PW);
 }
 
 @Override
 public void tearDown() throws Exception
 {
     //LiveServer.routines.logout();
 }
 
 @Override 
 public void RunPartial() throws Exception 
 {
     System.out.print(header);
     
     int projectOptionIndex;
     WebElement comboBox = null; 
     Select sel = null; 
     List<WebElement> w = null;

     try{ 
           
         LiveServer.routines.toAdminPanel(); 
         LiveServer.routines.fetch(By.xpath(
         "//div[@class='container']//h3[.=' Lock/Unlock Projects ']")).click();
         
         while (w == null || w.isEmpty() || w.size() < 2)
         {
            comboBox = LiveServer.routines.fetch
           (By.xpath("//div[1]/div/div[3]/div[3]"
                    + "/div/table[1]/tbody/tr[1]/th/select"));

            sel = new Select(comboBox); 
            w = sel.getOptions();
         }
         
         projectOptionIndex = LiveServer.routines.matchFromList(w, "BOLO"); 
         
         // Not working.... 
         
         /*
         String text = w.get(projectOptionIndex).getText(); 
         System.out.println(text);
         sel.selectByVisibleText(text);
         
         String toAppend = "//option[" + projectOptionIndex +  "]"; 
         String fullXpath = "//div[1]/div/div[3]/div[3]"
                    + "/div/table[1]/tbody/tr[1]/th/select" + toAppend; 
         WebElement pleaseWork = LiveServer.routines.fetch(By.xpath(fullXpath)); 
         
         comboBox.click(); 
         LiveServer.driver.
         pleaseWork.click();
         System.out.println(pleaseWork.toString()); 
         System.out.println(pleaseWork.getText() + "submitted");
         //Thread.sleep(10000); 
         */
         
         
         
        }
     catch(Exception e)
     { 
         System.out.print(e.toString());
         passed = false; }

     if (!passed)
         System.out.println("FAIL"); 
     else
         System.out.println("PASS");
 }    
}
