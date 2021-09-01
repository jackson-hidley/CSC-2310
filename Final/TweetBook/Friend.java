public class Friend implements Observer {
		
	String name;
	User u;
	
	//Constructor
	public Friend(String name, User u) {
		this.name = name;
		this.u = u;
	}

		
	//method update() implemented
	@Override
	public void update() {
		System.out.println("Hi "+name+", "+this.u.name+" uploaded new Status");
	}
}