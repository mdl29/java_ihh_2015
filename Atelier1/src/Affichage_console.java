import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Affichage_console {

	/**
	 * @param args
	 */
	
	//Attributs
	private int x,y,z;
	private boolean vivant;
	
	//tous les "get et set" qui suivent (appeles accesseurs et mutateurs ont ete generes avec Eclipse, menu Source>Generate Getters and Setters)
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}


	public boolean isVivant() {
		return vivant;
	}


	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}


	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Affichage_console(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//Ci-dessous a ete genere un constructeur de la classe avec Eclipse (Menu Source>Generate Constructor using Fields)
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 * @param vivant
	 */
	public Affichage_console(int x, int y, int z, boolean vivant) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.vivant = vivant;
	}


	
	//Méthodes
	public void afficher(String phrase)
	{
		System.out.printf(phrase);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Affichage_console nom_instance = new Affichage_console(1,3,7);

		int somme = 0;
	    String ligne = "";
	    StringTokenizer st; 
	    BufferedReader entree = new BufferedReader
	      (new InputStreamReader(System.in));
	 
		//saisie de texte depuis console
	    try{
	    	ligne = entree.readLine();
	    	}
	    catch(IOException e){}
	    
	    System.out.println(ligne); //affichage de la saisie
		//nom_instance.afficher("Hello !\n");
	}

}
