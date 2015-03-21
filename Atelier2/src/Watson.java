
public class Watson extends Sherlock implements Medecin{
/**
* La classe Watson herite (extends) de la classe Sherlock et met en oeuvre (implements) l'interface Medecin
*/

	public void modif_poids(){poids+=5;} //<=> poids = poids +5
	
	public void afficher_intelligence()
	{
		System.out.printf("intell = %d\n",intelligence);
	}
	
	/*Les methodes suivantes ont ete generees par Eclipse de 2 façons possibles :
	-soit en pointant le curseur de la souris sur Watson et en cliquant la suggestion Eclipse "Add unimplemented methods"
	-soit dans le menu "Source>Override/Implement Methods..." puis en cochant les méthodes de Medecin
	*/

	@Override
	public void soigner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parler(String phrase) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recommander() {
		// TODO Auto-generated method stub
		
	}

}
