/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestScripts;

/**
 *
 * @author Dafna
 */
public abstract class UserStoryTest {
    
    int ID; 
    String title; 
    
    public UserStoryTest() 
    {
    }
    
    public void Run() throws Exception
    {
        try { setUp();}
        catch(Exception e){ System.out.println(e.toString()); return; } 
        
        try { RunPartial(); }
        catch(Exception e){System.out.println(e.toString()); return;}  
        
        try { tearDown();}
        catch(Exception e){System.out.println(e.toString()); return;} 
    }
    public abstract void RunPartial() throws Exception; 
    public abstract void setUp() throws Exception;   
    public abstract void tearDown() throws Exception;
    
}
