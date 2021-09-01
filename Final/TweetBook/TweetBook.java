public class TweetBook {

	public static void main(String[] args) {

		// Create a main user OP
		User u = new User("OP");

		// Create some of his friends or followers 
		Friend f1 = new Friend("John", u);
		Friend f2 = new Friend("Bob", u);
		Friend f3 = new Friend("Charles", u);
		Friend f4 = new Friend("David", u);

		// Add or attach all the friends in user u's friend list
		u.attach(f1);
		u.attach(f2);
		u.attach(f3);
		u.attach(f4);

		// Now user u updates his status
		u.statusUpload();       

		// Now user OP Unfriends his friend f3
		u.detach(f3);
		
		System.out.println();
		
		// Now again user u updates his status
		u.statusUpload();
	}
}