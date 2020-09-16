
public class Item {
	private String nom;
	private float valeur;
	private float poids;
	
	public Item(String n,float v, float p) {
		this.nom = n;
		this.valeur = v;
		this.poids = p;
	}
	
	public float getPoids() {
		return poids;
	}
	
	public float getValeur() {
		return valeur;
	}
	
	@Override
	public String toString() {
		return nom +" | "+ valeur +" | "+poids ;
	}
}
