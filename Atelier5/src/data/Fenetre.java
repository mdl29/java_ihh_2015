package data;

import data.Pong;
import data.Mobile.*;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.*;


public class Fenetre extends JFrame implements ActionListener
{
		
		protected Pong partie_de_pong;
		public boolean detecteur;		//permet de savoir s'il existe des solides a deplacer ou pas
		private Thread t;
		
///////////////////Gestion Barre des Tâches///////////////////////////
		//toolbar principale
		private JMenuBar menuBar = new JMenuBar();
		//Sous-parties des menus ainsi que leurs composants
		private JMenu Partie = new JMenu("Partie");
		private JMenuItem NouvellePartie = new JMenuItem("Démarrer nouvelle partie");
		private JMenuItem Lancer = new JMenuItem("Lancer la partie");
		private JMenuItem Quitter = new JMenuItem("Quitter");

		private JMenu Parametres = new JMenu("Paramètres");
		private JMenu ajouterSolide = new JMenu("Ajouter des Solides");
		private	JMenuItem cercle = new JMenuItem("Cercle");
		private	JMenuItem triangle = new JMenuItem("Triangle");
		
///////////////////Constructeur de la Fenêtre/////////////////////////////
		
		public Fenetre(){
			//Choix de la taille de fenetre
			int largeur_voulue=500, hauteur_voulue=500;
			//On lui donne un titre
			this.setTitle("Pong");
			//On lui donne les dimensions souhaitées
			this.setSize(largeur_voulue,hauteur_voulue);			
			this.setLocationRelativeTo(null); //lancement centré de fenetre
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet de fermer le programme avec petite (X)
			this.setResizable(true); //fenêtre redimensionnable avec la souris

			//On initialise la "partie_de_pong" associée à la fenêtre instanciée
			this.partie_de_pong=new Pong(this.getWidth(),this.getHeight());
	//////////////////Gestion Interactions Boutons//////////////////
			//Attribution des "écouteurs" aux différents boutons, qui vont se charger de surveiller toute activité concernant les boutons qui leurs sont attribués
			NouvellePartie.addActionListener(new NouvellePartieListener());
			Lancer.addActionListener(new LancerAnimationListener());
			Quitter.addActionListener(new quitterListener());
			triangle.addActionListener(new triangleListener());
			cercle.addActionListener(new cercleListener());
			
	//////////////////Gestion Menu//////////////////////
			//On ajoute les différents éléments à la barre des tâches
			this.menuBar.add(Partie);
			this.Partie.add(NouvellePartie);
			this.Partie.add(Lancer);
			this.Partie.add(Quitter);
			this.Parametres.add(ajouterSolide);
			this.ajouterSolide.add(cercle);
			this.ajouterSolide.add(triangle);
			this.menuBar.add(Parametres);
			this.setJMenuBar(menuBar);
			
	//////////////////Gestion JPanel////////////////////
			
			//On choisit le content pane ("vitre" de contenu) du conteneur partie_de_pong (châssis)
			this.setContentPane(partie_de_pong);
			//On l'affiche
			this.setVisible(true);
			this.setSize(largeur_voulue,hauteur_voulue+50); //redimensionnement à personnaliser selon PC qui l'exécute
		}


		//////////////////Gestion sous-classess///////////////
		//On crée des sous-classes qui vont "surveiller" les boutons de la toolbar et réagir en conséquence
		class NouvellePartieListener implements ActionListener {
				public void actionPerformed(ActionEvent e){
				
				setSize(getWidth(),getHeight()-50);
				//Reset des attributs de l'instance précédente de Pong. Permet d'avoir la liste Pong.mobiles vide
				partie_de_pong = new Pong(getWidth(),getHeight());
				setContentPane(partie_de_pong);
				//Redimensionner permet un rafraîchissement particulier de la JFrame
				setSize(getWidth()+1,getHeight()+1);
				setSize(getWidth()-1,getHeight()-1);
				//N.B. : oui ceci est une bidouille, faute de mieux pour "renouveler" la fenêtre ^^
				
				repaint();
				setSize(getWidth(),getHeight()+50);
				JOptionPane.showMessageDialog(null, "Ajouter des solides puis lancer la partie", "Début de partie", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		class LancerAnimationListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
			    t = new Thread(new LancerAnimation());
			    t.start();
			}
		} 

		//Présence de sous-classes dérivant de Runnable pour pouvoir lancer correctement de nouvelles parties de jeu
		class LancerAnimation implements Runnable {
			public void run(){
			    detecteur=true;
			    while(true)
			    {
					partie_de_pong.execute();
					
/*-------DECOMMENTER APRES 15H----------
					
					//Collision avec un mur
					for (Mobile mob : partie_de_pong.getMobiles())
					{
					  for (Mur wall : partie_de_pong.getWalls())
					  {
					    if(partie_de_pong.Collision(wall,mob))
							partie_de_pong.Choc(mob,wall);
					  }
					}

					//Collision avec un autre mobile
					for(int index=0;index<partie_de_pong.getMobiles().size();index++)
					{
					   for(int index_bis=index;index_bis<partie_de_pong.getMobiles().size();index_bis++)
					   {
					   		if(partie_de_pong.Collision(partie_de_pong.getMobiles().get(index),partie_de_pong.getMobiles().get(index_bis)))
								partie_de_pong.Choc(partie_de_pong.getMobiles().get(index),partie_de_pong.getMobiles().get(index_bis));
					   }
					}

-------FIN POUR DECOMMENTER APRES 15H----------*/

					if(!detecteur)return;
			    }
			}
		}
		
		class triangleListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
				detecteur=false;
				t = new Thread(new ajouterTriangle());
				t.start();
			}
		}

		class ajouterTriangle implements Runnable {
			public void run(){
				//AJOUTER ICI autant de String que d'attributs saisis
			    String X="0" ,Y="0";
			    
			    
			    //Présence de boîte de dialogue demandant de rentrer différents paramètres pour le futur triangle
				if ((X = (String)JOptionPane.showInputDialog(null, "Veuillez saisir la position en X de votre triangle", "Saisie des paramètres du nouveau triangle",JOptionPane.PLAIN_MESSAGE,null,null,"valeur >0")) != null);
				else 
				{
						JOptionPane.showMessageDialog(null, "Création de triangle abandonnée", "Attention", JOptionPane.WARNING_MESSAGE);
						return;
				}
				int posX = Integer.decode(X);//Transtypage du texte saisi dans les formats adaptés

				if ((Y = (String)JOptionPane.showInputDialog(null, "Veuillez saisir la position en Y de votre triangle", "Saisie des paramètres du nouveau triangle",JOptionPane.PLAIN_MESSAGE,null,null,"valeur >0")) != null);
				else 
				{
						JOptionPane.showMessageDialog(null, "Création de triangle abandonnée", "Attention", JOptionPane.WARNING_MESSAGE);
						return;
				}
				int posY = Integer.decode(Y);

			    //Verification des valeurs saisies>>>>>>>>>>>>>>>>> A PERSONNALISER selon les attributs saisis et lesconstructeurs definis    
			    if(posX>0 && posY>0){}
					//partie_de_pong.getMobiles().add(new Triangle(posX,posY));
			    else
					JOptionPane.showMessageDialog(null, "Veuillez rentrer des données valables", "Attention", JOptionPane.ERROR_MESSAGE);
				repaint();
			}
		}

		class cercleListener implements ActionListener {
			public void actionPerformed(ActionEvent e){
			    detecteur=false;
			    t = new Thread(new ajouterCercle());
			    t.start();    
			}
		}

		class ajouterCercle implements Runnable {
			public void run(){
			    
				//AJOUTER ICI autant de String que d'attributs saisis
			    String X="0" ,Y="0";
			    //Présence de boîte de dialogue demandant de rentrer différents paramètres pour le futur cercle
			
			    //SI une valeur est rentrée puis OK
				if ((X = (String)JOptionPane.showInputDialog(null, "Veuillez saisir la position en X de votre cercle", "Saisie des paramètres du nouveau cercle",JOptionPane.PLAIN_MESSAGE,null,null,"valeur >0")) != null);
				else 
				{
						//SI le joueur a choisi Annuler
						JOptionPane.showMessageDialog(null, "Création de cercle abandonnée", "Attention", JOptionPane.WARNING_MESSAGE);
						return;
				}
				int posX = Integer.decode(X);//Transtypage du texte saisi dans les formats adaptés

				if ((Y = (String)JOptionPane.showInputDialog(null, "Veuillez saisir la position en Y de votre cercle", "Saisie des paramètres du nouveau cercle",JOptionPane.PLAIN_MESSAGE,null,null,"valeur >0")) != null);
				else 
				{
						JOptionPane.showMessageDialog(null, "Création de cercle abandonnée", "Attention", JOptionPane.WARNING_MESSAGE);
						return;
				}
				int posY = Integer.decode(Y);

			    //Verification des valeurs saisies >>>>>>>>>>>>>>>>> A PERSONNALISER selon les attributs saisis et les constructeurs definis
			    if(posX>0 && posY>0){}		    
					//partie_de_pong.getMobiles().add(new Cercle(posX,posY));
			    else
					JOptionPane.showMessageDialog(null, "Veuillez rentrer des données valables", "Attention", JOptionPane.ERROR_MESSAGE);
			    repaint();
			}
		}

		class quitterListener implements ActionListener {
		      public void actionPerformed(ActionEvent event ){System.exit(0);}
		}

		/////////////////Gestion Méthodes////////////////////
		//Obligé d'implementer cette méthode car Fenetre dérive d'une interface
		public void actionPerformed(ActionEvent e){}

		public Pong getGame(){return partie_de_pong;}
    
}