import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		
				
		boolean retourner=true;
		
		do {
			System.out.println("Entrez le numéro d'un café ");
			System.out.println("1-Colombia");
			System.out.println("2-Sumatra");
			System.out.println("3-Expresso");
			System.out.println("4-Deca");
			System.out.println("5-Quitter");
			int choix=input.nextInt();
			// choix 1
			
			if(choix==1) {
				System.out.println("Entrez le numéro de l'ingrédient");
			    System.out.println("1- Lait");
			    System.out.println("2- chocolat");
			    System.out.println("3- caramel");
			    System.out.println("4-chantily");
			    int choix2=input.nextInt();
			    Boisson b=new Colombia();
			    if(choix2==1){
			    	
			        b=new Lait(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==2){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==3){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==3){
			    	
			        b=new Caramel(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==4){
			    	
			        b=new Chantily(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    
			    }

			}
			// choix 2
			else if(choix==2) {
				System.out.println("----Choix de l'ingedient");
			    System.out.println("1- Lait");
			    System.out.println("2- chocolat");
			    System.out.println("3- caramel");
			    System.out.println("4-chantily");
			    int choix2=input.nextInt();
			    Boisson b=new Sumatra();
			    if(choix2==1){
			    	
			        b=new Lait(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==2){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==3){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==3){
			    	
			        b=new Caramel(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==4){
			    	
			        b=new Chantily(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    
			    }

			}
			//Expresso
			else if(choix==3) {
				System.out.println("----Choix de l'ingedient");
			    System.out.println("1- Lait");
			    System.out.println("2- chocolat");
			    System.out.println("3- caramel");
			    System.out.println("4-chantily");
			    int choix2=input.nextInt();
			    Boisson b=new Expresso();
			    if(choix2==1){
			    	
			        b=new Lait(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==2){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==3){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==3){
			    	
			        b=new Caramel(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==4){
			    	
			        b=new Chantily(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    
			    }

			}
			//DECA
			else if(choix==4) {
				System.out.println("----Choix de l'ingedient");
			    System.out.println("1- Lait");
			    System.out.println("2- chocolat");
			    System.out.println("3- caramel");
			    System.out.println("4-chantily");
			    int choix2=input.nextInt();
			    Boisson b=new Deca();
			    if(choix2==1){
			    	
			        b=new Lait(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==2){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }
			    else if(choix2==3){
			    	
			        b=new Chocolat(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==3){
			    	
			        b=new Caramel(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    }else if(choix2==4){
			    	
			        b=new Chantily(b);
			        System.out.println("Description:"+ b.getDescription()+ " cout: "+ b.count());		    	
			    
			    }

			}
			else if (choix==5) {
				retourner=false;
			}

      
			
		} while (retourner);
		
		
		
		

	}

}
