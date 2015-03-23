public class Erreur{
		public static void main(String[] args) {

			try { 				//On lance une instruction susceptible de lever une erreur
				String[] tableau=new String[1000000000]; //OutOfMemoryError
			}
				catch (Error e) { //Si on a une erreur, on rentre dans le catch,
					System.out.println("Oh !!! Un petit Hacker a généré une erreur !\n");
					
					//e.printStackTrace(); //Affiche l'exception et l'état de la pile d'exécution au moment de son appel
					//System.out.println(e.getMessage()); //Affiche le message d'erreur correspondant
					//System.out.println(e.getCause()); //Affiche la cause de l'erreur (s'il y en a une)
					
					
					/*Remarque 1 : il est FORTEMENT recommandé de ne pas laisser un catch vide après la levée d'une erreur.
					Le programme continuerait à s'exécuter normalement mais risquerait plus tard
					de produire des bugs logiciels incompréhensibles.
					Si vous ne faites pas de traitement de l'erreur, veillez au moins à mettre un printStackTrace()
					*/
				}
		}
			
			//Remarque 2 : try/catch/finally ont un fonctionnement très similaire à switch/case/default
}