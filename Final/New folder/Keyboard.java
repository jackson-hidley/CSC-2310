import java.util.Scanner;

public class Keyboard {
  
   private Keyboard()
   {
       //Make constructor private to restrict object creation
   }
  
   public static Keyboard instance= null;
  
   // Method to give singleton object
   public static Keyboard getKeyboard()
{
if (instance == null)
   instance = new Keyboard();
return instance;
}
   // Method to read integer from user input
   public int readInt(String prompt)
   {
       System.out.println(prompt);
       Scanner sc = new Scanner(System.in);
       return sc.nextInt();
   }
   // Method to read double from user input
   public double readDouble(String prompt)
   {
       System.out.println(prompt);
       Scanner sc = new Scanner(System.in);
       return sc.nextDouble();
   }
   // Method to read String from user input
   public String readString(String prompt)
   {
       System.out.println(prompt);
       Scanner sc = new Scanner(System.in);
       return sc.nextLine().toUpperCase();
   }
  
}