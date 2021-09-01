public class TVContext{

   private TVState currentState;
  
   public TVContext()
   { //Initializing TV to OFF State
       currentState=new TVOffState();
   }
  
   public void setState(TVState state)
   { //Set the give state
       currentState=state;
   }
  
   public void doAction()
   { //Call do action of current state
       currentState.doAction();
   }
  

}