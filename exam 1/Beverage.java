public class beverage extends AmenitiesDecorator
{
	Amenities amen;

	public Beverage(Amenities amen) {
		this.amen = amen;
	}

	public String getDescription() {
		return amen.getDescription() + ", Beverage";
	}

	public double cost() {
		return 7.00 + amen.cost();
	}
}
