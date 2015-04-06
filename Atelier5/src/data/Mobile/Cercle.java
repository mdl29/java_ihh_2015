package data.Mobile;

import java.awt.Color;
import java.awt.Graphics;

import data.Couleur;
import data.Pong;

public class Cercle extends Mobile {

	public Cercle(int x, int y, int rayon, Couleur coul,
			double orientation) {
		super(x, y, rayon, rayon, coul, orientation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deplace(Pong current_game) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dessine(Graphics g) {
	    //Choix de la couleur
	    g.setColor(new Color(coul.getRouge(), coul.getVert(),coul.getBleu()));

	    //Action de dessin d'un cercle avec couleur choisie
	    g.fillOval(X,Y,largeur,hauteur);
	}

}
