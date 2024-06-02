public class Icontext {
    //injection de l'interface dans la classe
    private IStrategy istrategy;

    public Icontext(IStrategy iStrategy){
        this.istrategy= iStrategy;
    }

    public int executeStrategy(int valeur1, int valeur2){
        return istrategy.doOperation(valeur1, valeur2);
    };
    
}
