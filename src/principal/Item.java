package principal;

/**
 * <b>Item est la classe représentant un objet du sac</b>
 * <p>
 * Un Item est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un nom</li>
 * <li>Un poids</li>
 * <li>Une valeur</li>
 * <li>Un boolean pour savoir s'il est stocké ou non</li>
 * </ul>
 * </p>
 *
 */
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

	/**
	 * @return poids de l'item
	 */
	public float getPoids() {
		return poids;
	}

	/**
	 * @return valeur de l'item
	 */
	public float getValeur() {
		return valeur;
	}

	/**
	 * Retourne si l'item est stocké ou non
	 * 
	 * @return true si l'item est stocké ou false si l'item n'est pas stocké
	 */
	public boolean getStocké() {
		return stocké;
	}

	/**
	 * Change la situation de stockage de l'item
	 * 
	 * @param stocké : true si l'item est stocké ou false si l'item n'est pas stocké
	 */
	public void setStocké(boolean stocké) {
		this.stocké = stocké;
	}

	/**
	 * toString permettant d'afficher l'ensemble des données des items Utilisé pour
	 * les tests mais désormais inutile
	 * 
	 * @deprecated
	 * @return
	 */
	public String toStringFull() {
		return nom + ", " + poids + ", " + valeur;
	}

	@Override
	public String toString() {
		return nom;
	};
}
