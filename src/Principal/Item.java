package Principal;

public class Item implements Comparable<Item> {
	private String nom;
	private float valeur;
	private float poids;

	public Item(String n, float p, float v) {
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
		return nom + " | " + poids + " | " + valeur;
	}

	@Override
	public int compareTo(Item o) {
		return (int) (((this.valeur / this.poids) - (o.valeur / o.poids)) * 1000);
	}
}
