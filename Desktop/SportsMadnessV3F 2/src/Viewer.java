

import java.util.Scanner;

public class Viewer

{

    private java.util.Scanner kbd; // ivar for efficiency
    public Viewer(){
        this.kbd = new Scanner(System.in);
    }

    public void printPrompt(String msg){
         System.out.println(msg);
 
    }
    
    public String getStringChoice(String prompt){
        System.out.println(prompt);
        return kbd.nextLine();
    }
    
    public int getNumberChoice(String prompt){
    	 System.out.println(prompt);
         int result = kbd.nextInt();
         kbd.nextLine(); // eat up extra newline
         return result; 
    }
    
    
    
}

