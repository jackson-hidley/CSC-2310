public class Blanket extends AmenitiesDecorator
{
	Amenities amen;
	
	public Blanket(Amenities amen) {
		this.amen = amen;
	}

	public String getDescription() {
		return amen.getDescription() + ", Blanket";
	}

	public double cost() {
		return 10.00 + amen.cost();
	}
}