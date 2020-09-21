package principal;

public class Item {
	private String nom;
	private float poids;
	private float valeur;
	private boolean stocké;

	public Item(String n, float p, float v) {
		this.nom = n;
		this.poids = p;
		this.valeur = v;
		this.stocké = false;
	}

	public float getPoids() {
		return poids;
	}

	public float getValeur() {
		return valeur;
	}

	public boolean getStocké() {
		return stocké;
	}

	public void setStocké(boolean stocké) {
		this.stocké = stocké;
	}

	@Override
	public String toString() {
		return nom + ", " + poids + ", " + valeur;
	}
}
