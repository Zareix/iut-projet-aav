package principal;

public class Item {
	private String nom;
	private float poids;
	private float valeur;

	public Item(String n, float p, float v) {
		this.nom = n;
		this.poids = p;
		this.valeur = v;
	}

	public float getPoids() {
		return poids;
	}

	public float getValeur() {
		return valeur;
	}

	@Override
	public String toString() {
		return nom + " | " + poids + " | " + valeur;
	}
}
