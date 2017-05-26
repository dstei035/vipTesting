
// #####################################################################
// #1172 Divide Login page to two parts
//
// Description:
// The login page of the VIP website should have two login sections.
// 1. For Non-FIU students i.e., faculty, admins. For this section it would 
// have a form format with login username and password. 2. For FIU students: 
// We have a google gmail icon, which when clicked would let them login to the
// VIP website, since FIU students have the panther mail linked with gmail.
// Also we have user guide line videos which would help the students/faculty 
// if they have any concerns.
// 
//
// Acceptance Criteria:
// Faculty must be able to login by giving their username and password.
// Students should be able to login by clicking on the Google Icon.
// The user videos must be played when clicked on them.
// #####################################################################

package TestScripts;

import vip4_userstorytesting.Data;
import vip4_userstorytesting.LiveServer;

public class test1172 extends UserStoryTest{
    
    boolean studentCouldLogin = true; 
    boolean professorCouldLogin = true; 
    private String header; 
    
    public test1172()
    {
        this.ID = 1172; 
        this.title = "Divide login page to two parts"; 
        this.header = ID + " " + title + "\n\t";
    }
    
@Override 
 public void setUp() throws Exception
 {}
 
 @Override
 public void tearDown() throws Exception
 {
     Thread.sleep(3000);
     LiveServer.routines.logout(); 
 }
 
 @Override 
 public void RunPartial() throws Exception 
 {
    System.out.print(header);

     try{ LiveServer.routines.loginProf(Data.PROF_EMAIL, Data.PROF_PW);
          LiveServer.routines.logout();
        }
     catch(Exception e){professorCouldLogin = false; }
     
     Thread.sleep(3000);
     
     try  { LiveServer.routines.loginStudent(Data.USER_EMAIL, Data.USER_PW);}
     catch(Exception ex) {studentCouldLogin = false; }
     
     if (!professorCouldLogin && studentCouldLogin)
         System.out.println("FAIL, "
                 + "professorCouldLogin = " + professorCouldLogin + 
                 ", studentCouldLogin = " + studentCouldLogin);
     else
         System.out.println("PASS");
 }
}
