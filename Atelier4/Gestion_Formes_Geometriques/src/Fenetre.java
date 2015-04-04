
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;



public class Fenetre extends JFrame {
	
	private JMenuBar menuBar = new JMenuBar();//On ajoute un attribut menuBar à la classe Fenetre
	private JMenu fenetre = new JMenu("Fenetre");
	private JMenuItem infos = new JMenuItem("Informations");
	private JMenuItem Quitter = new JMenuItem("Quitter");

	public Fenetre () {

		///////////Gestion Fenêtre///////////	

		//Lui donner un titre
		this.setTitle("Ma nouvelle fenêtre");
		//On lui donne les dimensions souhaitées
		this.setSize(500,500);			
		//Lancement centré de fenetre
		this.setLocationRelativeTo(null); 
		//Permet de fermer le programme avec petite (X)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//Fenêtre redimensionnable avec la souris
		this.setResizable(true);
		
		this.setBackground(Color.BLACK);

		
		///////////Gestion JPanel////////////
		//Création d'un nouveau JPanel, qui sera le "fond" de notre fenêtre 
		JPanel pan = new JPanel();
		//On lui met un fond orange
		pan.setBackground(Color.ORANGE);
		//On indique à la fenêtre de prendre une instance de la classe Panneau comme fond
		this.setContentPane(new Panneau());
	
	
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
	
	
		///////////Gestion Sous Classe///////////
		// Ces sous-classes vont surveiller les boutons et agir en conséquence
		class quitterListener implements ActionListener {
				  public void actionPerformed(ActionEvent event ){System.exit(0);}
			}

		class infosListener implements ActionListener {
				  public void actionPerformed(ActionEvent event){
					  //appel statique de la methode showMessageDialog
					  JOptionPane.showMessageDialog(null,"Apprenez à dessiner des formes avec Java","Information", JOptionPane.INFORMATION_MESSAGE);
				  }
		}
}