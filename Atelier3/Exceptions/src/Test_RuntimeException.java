
public class Test_RuntimeException {
	
	public static void main(String[] args) {

		int x = 10;
		int y = 0;
		
			try { 				//On lance le test d'exception car on a affaire à un calcul risqué (susceptible de générer une erreur)
					int resultat =x/y;
			}
			//ce qui suit n'est pas un traitement obligatoire (valable pour tous les RuntimeException)
			catch (ArithmeticException e) { //Si on a une situation exceptionelle de type AritmeticException, on rentre dans le catch,
					System.out.println("Division par zéro\n");
					
					//e.printStackTrace(); //Affiche l'exception et l'état de la pile d'exécution au moment de son appel
			}
			finally{
					System.out.printf("texte du Finally\n");
			}
	}

}		
		

	

