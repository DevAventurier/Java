public class Chantily  extends DecoratorIngredient{

	public Chantily(Boisson boisson) {
		super(boisson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.boisson.getDescription()+" Chantily";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 40+this.boisson.count();
	}

}