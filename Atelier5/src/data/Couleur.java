package data;

public class Couleur{
	  /*Attributs*/
	  private int rouge;
	private int vert;
	private int bleu;

	  /*Constructeurs*/
	  public Couleur(int r, int v,int b)
	  {setRouge(r);setVert(v);setBleu(b);}

	  public Couleur(){this(0,0,0);}

	public int getRouge() {
		return rouge;
	}

	public void setRouge(int rouge) {
		this.rouge = rouge;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getBleu() {
		return bleu;
	}

	public void setBleu(int bleu) {
		this.bleu = bleu;
	}
}