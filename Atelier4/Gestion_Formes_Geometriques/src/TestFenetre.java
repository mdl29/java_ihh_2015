import java.awt.Graphics;

import javax.swing.JPanel;

public class TestFenetre extends JPanel {

	public static void main(String[] args) {

		//appel statique de la methode showMessageDialog
		new Fenetre();

	}
	
		//Fonctionne aussi et remplace la création de la classe Panneau
	  public void paintComponent(Graphics g){
		g.fillOval(20,20,60,60);
	}
	
}
