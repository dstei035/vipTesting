/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vip4_userstorytesting;
import TestScripts.*; 

public class VIP4_UserStoryTesting {
   
    public static void main(String[] args) 
    {   
        try 
        {
        LiveServer.StartDriver(); 
        
        //Program.routines.loginStudent("dstei035@fiu.edu", "fake");
        //LiveServer.routines.loginProf("sadjadi@cs.fiu.edu", "fake");
        //LiveServer.routines.logout();
        
        /*new test1172().Run();
        Thread.sleep(3000);
        new test1158().Run(); 
        new test1195().Run(); 
        */
        
        new test1101().Run();
        
        System.out.println("Press RETURN to finish...");
          System.in.read();
          
          LiveServer.EndDriver();
        }
        catch (Exception ex){System.out.println(ex.toString());}
        
    }
}
