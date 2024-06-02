public class Osub implements IStrategy{
   @Override
   public int doOperation(int valeur1, int valeur2){

    return valeur1>valeur2?valeur1-valeur2: valeur2-valeur1 ;
    
   } 
}
