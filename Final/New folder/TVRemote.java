import java.util.HashMap;
import java.util.Map;

public class TVRemote {
  
public static void main(String[] arg)
{
   TVContext context = new TVContext();
   TVOffState off = new TVOffState();
   TVOnState on = new TVOnState();
   // Creating hashmap with corresponding states for input
   Map<Object,TVState> states = new HashMap<>();
   states.put(0,off);
   states.put(1,on);
   states.put(0.0,off);
   states.put(1.0,on);
   states.put("OFF",off);
   states.put("ON",on);
  

  
   // Printing Initial State
   context.doAction();
   /*-----------------Taking integer inputs ---------*/
   int x=Keyboard.getKeyboard().readInt("Enter 0 for OFF and 1 for ON");
   if(states.get(x)==null)
   {
       errorMessage();
   }
   else
   {
       context.setState(states.get(x));
       context.doAction();
   }
   /*-----------------Taking double inputs ---------*/
   double y=Keyboard.getKeyboard().readDouble("Enter 0.0 for OFF and 1.0 for ON");
   if(states.get(y)==null)
   {
       errorMessage();
   }
   else
   {
       context.setState(states.get(y));
       context.doAction();
   }
   /*-----------------Taking String inputs ---------*/
   String s=Keyboard.getKeyboard().readString("Enter OFF OR ON");
   if(states.get(s)==null)
   {
       errorMessage();
   }
   else
   {
       context.setState(states.get(s));
       context.doAction();
   }
}

//Error message for invalid input
private static void errorMessage()
{
System.out.println("Invalid Input");  
}
}