public class Ticket
{
 
	public static void main(String args[]) 
	{
		double TICKET_PRICE = 100.00;
		
		int numTickets = 2;
		double tTotal = numTickets * TICKET_PRICE;
		
		Amenities amen = new Beverage();
		System.out.println(beverage.getDescription() 
				+ " $" + (beverage.cost() + tTotal));
		tTotal = 0;
		
		Amenities amen2 = new Blanket();
		amen2 = new Beverage(amen2);
		amen2 = new Beverage(amen2);
		System.out.println(amen2.getDescription() 
				+ " $" + (amen2.cost() + tTotal));
		tTotal = 0;
		
		Amenities amen3 = new Beverage();
		amen3 = new Beverage(amen3);
		amen3 = new Beverage(amen3);
		System.out.println(amen3.getDescription() 
				+ " $" + (amen3.cost() + tTotal));
		tTotal = 0;
	}
}