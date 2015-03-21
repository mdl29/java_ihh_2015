/** /!\ /!\ /!\ Ceci n'est pas une classe mais une interface  /!\ /!\ /!\
* Elle decrit le comportement des classes qui vont l'utiliser
* mais sans le "detailler" (les methodes ne peuvent pas etre implementees ici)
*/
public interface Medecin {
		//Attributs
		public int intelligence = 424242;	
		
		//Méthodes
		public void soigner();
		public void consulter();
		public void parler(String phrase);
		public void recommander();

}
