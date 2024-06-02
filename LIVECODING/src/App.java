public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //création de l'objet icontext
        Icontext icontext= new  Icontext(new Oadd());

        System.out.println(icontext.executeStrategy(14, 5));
        icontext=new Icontext(new Osub());
        System.out.println(icontext.executeStrategy(14, 5));
//reprendre le meme code mais le client doit pouvoir switcher entre les opérations
        
    }
}
