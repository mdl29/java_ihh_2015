public class PropagationException {
    
    public static void main(String[] args) {
        try{
            String chemin="/Un/chemin/vers/une/classe/qui/n'existe/pas";
        	Class.forName(chemin);//levée d'une ClassNotFoundException
            System.out.println("fin du programme");
			
        }catch(ClassNotFoundException ex){
            System.out.println("Une exception est survenue");
        }
    }
}
//Note : au final, le programme fait un "saut" à la ligne 6 et la ligne 7 n'est jamais exécutée