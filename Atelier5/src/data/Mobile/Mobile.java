package data.Mobile;

import data.Couleur;
import data.Forme;
import data.Pong;

import java.awt.Graphics;

public abstract class Mobile extends Forme {
	public Mobile(int x, int y, int hauteur, int largeur, Couleur coul,
			double orientation) {
		super(x, y, hauteur, largeur, coul, orientation);
		// TODO Auto-generated constructor stub
	}
	////////Attribut//////////////
	protected int vitesse;
		
	////////Méthodes///////////////
    public abstract void deplace (Pong current_game);
    public abstract void dessine (Graphics g);
	
	////////Accesseurs et Mutateurs///////////
	
	public int GetVitesse() {return vitesse;}
	public void SetVitesse(int v) {vitesse=v;}
	
	
  
}