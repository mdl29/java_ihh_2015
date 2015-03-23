package data;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Fenetre extends JFrame implements ActionListener{
	
	/*Attributs*/
	private JButton bouton1 = new JButton("Bouton 1");//On donne un attribut bouton1 à la classe Fenetre
	private JButton bouton2 = new JButton("Bouton 2");//On donne un attribut bouton2 à la classe Fenetre
	private JLabel texte = new JLabel("Le fond");//On donne un attribut texte à la classe Fenetre
	
	private int compteur = 0;
	
	private JMenuBar menuBar = new JMenuBar();//On ajoute un attribut menuBar à la classe Fenetre
	private JMenu fenetre = new JMenu("Fenetre");
	private JMenuItem infos = new JMenuItem("Informations");
	private JMenuItem Quitter = new JMenuItem("Quitter");
	
	
	/*Methodes*/
	public Fenetre () {
	///////////Gestion Fenêtre///////////	

		//Lui donner un titre
		this.setTitle("Ma nouvelle fenêtre");
		//Note : this designe l'instance (et indrirectement sa classe) qui appelle cette methode (ici le constructeur)
		
		//On lui donne les dimensions souhaitées
		this.setSize(500,500);			
		//Lancement centré de fenetre
		this.setLocationRelativeTo(null); 
		//Permet de fermer le programme avec petite (X)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//Fenêtre redimensionnable avec la souris
		this.setResizable(true);

		
		///////////Gestion JPanel////////////
		//Création d'un nouveau JPanel, qui sera le "fond" (contenant) de notre fenêtre 
		JPanel pan = new JPanel();
		//On lui met un fond orange (Color.ORANGE)
		pan.setBackground(Color.ORANGE);
		//On indique à la fenêtre de prendre "pan" comme fond
		this.setContentPane(pan);
		
		
		///////////Gestion Layout////////////
		//On initialise une nouvelle disposition 
		this.setLayout(new BorderLayout());
		
		
		///////////Gestion JLabel////////////
		//On peut modifier le positionnement du texte sur sa ligne
		texte.setHorizontalAlignment(JLabel.CENTER);
		//On ajoute le texte à notre fond
		pan.add(texte, BorderLayout.NORTH);
		
		
		///////////Gestion Bouton////////////
		//On dit au bouton qu'il est "écouté" par la classe elle-même
		bouton1.addActionListener(this);
		//On place le bouton avec la disposition demandée
		pan.add(bouton1, BorderLayout.SOUTH);

		
		////////////Gestion Menu/////////////
		this.menuBar.add(fenetre);
		this.fenetre.add(infos);
		this.fenetre.add(Quitter);
		this.setJMenuBar(menuBar);
		Quitter.addActionListener(new quitterListener());
		infos.addActionListener(new infosListener());
		//On rend finalement visible la fenêtre
		this.setVisible(true);

	}
	
		//Cette méthode permet d'incrémenter le compteur lorsque l'on clique sur le bouton1
		public void actionPerformed(ActionEvent arg0) {
			this.compteur++;
			texte.setText("Tu as cliqué" + this.compteur + "fois");
		}
	
		///////////Gestion Sous Classe///////////
		// Ces sous-classes vont "écouter/surveiller" les boutons et agir en conséquence dès que le bouton associé est cliqué
		class quitterListener implements ActionListener {
				public void actionPerformed(ActionEvent event ){
						int reponse=JOptionPane.showConfirmDialog( fenetre, "Êtes-vous sur ?" );
						if(reponse==JOptionPane.YES_OPTION)
						{
							System.out.println("Programme fermé");
							System.exit(0);
						}

				}
		}

		class infosListener implements ActionListener {
				public void actionPerformed(ActionEvent event){
					  JOptionPane.showMessageDialog(null,"Hello world ! :)","Information", JOptionPane.INFORMATION_MESSAGE);
				}
		}


}
