import java.util.ArrayList;

public class User implements Subject {
        
	//Create an ArrayList that will hold the Observer(Friends) references 
	private ArrayList<Observer> observers = new ArrayList<>();
	String name;
	//Constructor
	public User(String name) {
		this.name=name;
	}
	//Method implementations
	@Override
	public void attach(Observer o) {
		observers.add(o);
	}
	@Override
	public void detach(Observer o) {
		observers.remove(o);
	}
	//Here when a new Status got uploaded by User then all his Friends or Followers will got notified
	@Override
	public void statusUpload() {
		for(Observer o: observers) {
			o.update();
		}
	}

}
