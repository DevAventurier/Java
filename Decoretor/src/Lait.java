public class Lait  extends DecoratorIngredient{

	public Lait(Boisson boisson) {
		super(boisson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.boisson.getDescription()+" Lait";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 10+this.boisson.count();
	}

}