package data;

import java.awt.Graphics;


public abstract class Forme {
	/////////////Attributs à trouver//////////
	protected int X,Y,hauteur,largeur;
	protected Couleur coul;
	protected double orientation;

	
	
	public Forme(int x, int y, int hauteur, int largeur, Couleur coul,
			double orientation) {
		super();
		X = x;
		Y = y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.coul = coul;
		this.orientation = orientation;
	}


	/////////////Méthode(s)///////////
	public abstract void dessine (Graphics g); //à définir dans les classes filles

	
	/////////////Accesseurs et Mutateurs////////////
	/**
	 * Generation aussi ici pour gagner du temps ;)
	 */
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public Couleur getCoul() {
		return coul;
	}
	public void setCoul(Couleur coul) {
		this.coul = coul;
	}


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}


	public int getLargeur() {
		return largeur;
	}


	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}


	public double getOrientation() {
		return orientation;
	}


	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}
} 
