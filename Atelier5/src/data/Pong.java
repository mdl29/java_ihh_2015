package data;

import data.*;			//importation de TOUTES les classes du package data
import data.Mobile.*;	//importation de TOUTES les classes du package Mobile, interne à data

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;


public class Pong extends JPanel {

	/////////Attributs/////////
	private ArrayList<Mobile> mobiles = new ArrayList<Mobile> ();
	//private ArrayList<Mur>murs = new ArrayList<Mur> ();

	//////////Méthodes/////////


	public Pong(int width, int height)
	{
		//Encerclement du terrain par 4 murs

		/**
		 * A COMPLETER (a faire apres les solides geometriques)
		 */
		
		//Creation de solides
		/**
		 * Ajouter ici vos solides selon le modele :
		 * this.mobiles.add(new INSTANCE D'UN SOLIDE);
		 */
		/*Creation d'un cercle a la position (100,150) (pour son coin superieur gauche)
		 * de rayon 50, rempli par une couleur de composantes rouge a 200, verte et bleue a 50
		 * et orientation a 0°
		 * Remarque : les unites des dimensions sont donnees en pixel
		 */
		this.mobiles.add(new Cercle(100, 150, 50, new Couleur(200,50,50), 0));
	}

	public ArrayList<Mobile> getMobiles(){return mobiles;}

	//public ArrayList<Mur> getWalls(){return murs;}

	public void paintComponent(Graphics g)
	{
		/**
		* methode appelée par repaint() depuis un objet JPanel
		*/
		//Ecrasement graphique du dernier dessin
		g.setColor(Color.gray);		//couleur du fond de la fenetre
		g.fillRect(0,0,2000,2000);

		/*
		//Reconstruction des murs
		//Parcours en mode for each ... {do ...}
		for (Mur m : this.murs)
		{m.dessine(g);}
		*/

		//Affichage des nouvelles positions des mobiles
		for (Mobile mob : this.mobiles)
			{mob.dessine(g);}

	}

/*-----------A DECOMMENTER APRES 15H----------------
	public boolean Collision(Mur wall, Mobile mob)
	{
		boolean touche = false;
 
		//cote gauche
		if ((wall.getX() <= mob.getX())
			&& (mob.getX() <= (wall.getX() + wall.getEpaisseur())))
			{touche = true;System.out.printf("Touché à gauche!!!\n");}
		
		//cote droit
		else if (((wall.getX() + wall.getEpaisseur()) >= (mob.getX() + mob.getLargeur()))
			&& ((mob.getX() + mob.getLargeur()) >= wall.getX()))
			{touche = true;System.out.printf("Touché à droite!!!\n");}

		//cote superieur
		else if ((wall.getY() <= mob.getY())
			&& (mob.getY() <= (wall.getY() + wall.getEpaisseur())))
			{touche = true;System.out.printf("Touché en haut!!!\n");}

		//cote inferieur
		else if(((wall.getY() + wall.getEpaisseur()) >= (mob.getY() + mob.getHauteur())) && ((mob.getY() + mob.getHauteur()) >= wall.getY()))
		//else if ((mob.getY() + mob.getHauteur()) >= wall.getY())
			{touche = true;System.out.printf("Touché en bas!!!\n");
			System.out.printf("avec Y_mur_haut=%d et bas=%d | Y_mob=%d\n",wall.getY(),wall.getY() + wall.getEpaisseur(),mob.getY() + mob.getHauteur());}

		return touche;
	}

	public boolean Collision(Mobile m1, Mobile m2)
	{
		/**
		* @return indique s'il y a collision entre 2 mobiles ou non
		* Remarque : il faut faire de plus en plus de tests si on rajoute des nouvelles formes.
		* Par exemple : si on peut faire des cercles, des rectangles et des losanges,
		* il faut penser à faire les calculs pour :
		-->1. 2 Cercles
		-->2. 1 Cercle VS 1 Rectangle
		-->3. 1 Cercle VS 1 Losange
		-->4. 2 Rectangles
		-->5. 1 Rectangle VS 1 Losange
		-->6. 2 Losanges
		6 types de tests a faire, sachant qu'il y a plusieurs cotés qu'il faut surveiller. Et pour seulement 3 formes différentes.
		Cela peut donc devenir très vite usant à implémenter entièrement.
		L'une des solutions pour y remédier peut être d'attribuer des "hitbox" (zones de contact) approximatives, par exemple
		le cercle ou le rectangle (qui existe déja pour l'affichage avec Graphics) qui englobe entièrement une forme.
		*/
	
/*-------A RETIRER POUR DECOMMENTER----------

		//Test sur 2 cercles
		if (m1 instanceof Cercle && m2 instanceof Cercle)
		{
			//Calcul des positions des centres
			double X1=(double)(m1.getX() + m1.getLargeur()/2), Y1=(double)(m1.getY() + m1.getHauteur()/2); //centre de m1
			double X2=(double)(m2.getX() + m2.getLargeur()/2), Y2=(double)(m2.getY() + m2.getHauteur()/2); //centre de m2

			//Rappel : la largeur correspond au diamètre d'un cercle ici
			if (Math.sqrt((X2-X1)*(X2-X1) + (Y2-Y1)*(Y2-Y1)) <= (m1.getLargeur()/2 + m2.getLargeur()/2))
				return true;
		}

		return false;
	}

	public void Choc(Mobile m, Mur w)
	{
	  //Mur vertical ou horizontal ?
	  if(w.getOrientation() == 0) m.SetOrientation(Math.PI - m.getOrientation());
	  else m.SetOrientation(-1*m.getOrientation());

	  m.SetVitesse(m.getVitesse()*(int)(w.getCoefficient())); //amortissement ou accélération du mobile selon le mur
	}

	public void Choc(Mobile m1, Mobile m2)
	{
		//calcul spécial a faire avec transmission d'energie particuliere lorsque les mobiles ont une vitesse differente (voir pages Internet)
	}

-------FIN POUR DECOMMENTER APRES 15H----------*/

	public void execute()
	{
		/**
		 * Placer ici toutes les actions souhaitées après les initialisations
		 */
	}
	
	
	public static void main(String[] args)
	{
		new Fenetre();
	}
}