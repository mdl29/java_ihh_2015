import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; //ajout de cette classe pour dessiner triangles et autres formes a plusieurs points

import javax.swing.JPanel;

public class Panneau extends JPanel{

	public void paintComponent(Graphics g){
		
		/***************
		 * 
		 *      -----------> X
			 	|
			 	|
			 	|
			 	|
			 	V
			 	Y
		 */	
		
		
		g.fillOval(20, 20, 60, 60); //Permet de dessiner un disque à la position (20,20) et de rayon 20
		g.drawOval(80, 80, 60, 60); //Permet de dessiner un cercle à la position (80,80) et de rayon 20
		g.fillRect(150, 150, 50, 50);//Permet de dessiner un rectangle plein à la position (150,150), de largeur 50, et de hauteur 50
		g.drawRect(210, 210, 50, 50);//Permet de dessiner un rectangle vide à la position (210,210), de largeur 50, et de hauteur 50
		
		
		//Choix de la couleur
	    g.setColor(new Color(100,250,120)); //couleur perso avec "new Color(R,G,B)"

	    //Calcul des positions des sommets

	    	//Positions horizontales
	    	int xs[] = {1,30,150};

	    	//Positions verticales
	    	int ys[] = {50,200,60};

	    	
	    Polygon poly = new Polygon(xs , ys , 3);

	    //Action de dessin d'un triangle avec couleur choisie
	    g.fillPolygon(poly);
	}
}
