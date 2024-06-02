public class Chocolat  extends DecoratorIngredient{

	public Chocolat(Boisson boisson) {
		super(boisson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.boisson.getDescription()+" Chocolat";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 20+this.boisson.count();
	}

}