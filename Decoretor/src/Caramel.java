public class Caramel  extends DecoratorIngredient{

	public Caramel(Boisson boisson) {
		super(boisson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.boisson.getDescription()+" Caramel";
	}

	@Override
	public double count() {
		// TODO Auto-generated method stub
		return 30+this.boisson.count();
	}

}