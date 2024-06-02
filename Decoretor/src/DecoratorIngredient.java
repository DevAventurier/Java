public abstract class DecoratorIngredient extends Boisson {
	protected Boisson boisson;
	
	public DecoratorIngredient(Boisson boisson) {
		this.boisson = boisson;
	}


	public abstract String getDescription();

}