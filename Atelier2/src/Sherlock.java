public class Sherlock {
	//Attributs
	public int poids = 180;
	/*Impossible :public final int taille=180;
	 * 
	 * puis modifier taille
	 */
	
	
	//Méthodes
	public void modif_poids(){poids++;} // <=> poids = poids + 1
	public final void modif_poids_bis(){poids++;}
	
	//public void modif_qqch(final int qqch){qqch++;}
	//final protege l'argument "qqch" en entree de la fonction


	/**
	 * main(String[]) : première méthode appelée à l'exécution
	 */
	public static void main(String[] args) {
		Sherlock p1=new Sherlock();
		Watson p2=new Watson();
		
		p2.afficher_intelligence();
		/*
		p2.modif_poids();
		System.out.printf("poids de Watson : %d\n", p2.poids);
		
		
		p1.modif_poids_bis();
		System.out.printf("nouveau poids : %d\n", p1.poids);
		p1.modif_poids();
		System.out.printf("re nouveau poids : %d\n", p1.poids);
		
		*/
	}

}
