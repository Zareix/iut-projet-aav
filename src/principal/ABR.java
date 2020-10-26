package principal;

import java.util.ArrayList;

public class ABR {
	private ABR leftTree, rightTree;

	private ArrayList<Item> value;
	private int profondeur;

	private float borneInférieure; // Static ??
	private float borneSupérieure;

	public ABR(ArrayList<Item> listeObjetsPossibles, float poidsMaximal, ArrayList<Item> listeItems, int i) {
		if (i <= listeObjetsPossibles.size()) {
			this.value = new ArrayList<>(listeItems);
			this.profondeur = i;

			calcBorneInférieure();
			calcBorneSupérieure(listeObjetsPossibles);

			if (i != listeObjetsPossibles.size()) {
				this.leftTree = new ABR(listeObjetsPossibles, poidsMaximal, new ArrayList<>(listeItems), i + 1);

				listeItems.add(listeObjetsPossibles.get(i));
				if (poidsListe(listeItems) <= poidsMaximal)
					this.rightTree = new ABR(listeObjetsPossibles, poidsMaximal, new ArrayList<>(listeItems), i + 1);
			}
		}
	}

	/*
	 * Retourne le poids d'une liste d'Item donnée en paramètre
	 */
	private float poidsListe(ArrayList<Item> liste) {
		float res = 0;
		for (Item item : liste)
			res += item.getPoids();
		return res;
	}

	/*
	 * Retourne la valeur du noeud
	 */
	private float valeurListe() {
		float res = 0;
		for (Item item : this.value)
			res += item.getValeur();
		return res;
	}

	/*
	 * Calcule la borne supérieure d'un noeud
	 */
	private void calcBorneSupérieure(ArrayList<Item> liste) {
		float res = 0;
		res += valeurListe(); // Ajoute la valeur actuelle du noeud
		for (int i = this.profondeur; i < liste.size(); i++) {
			res += liste.get(i).getValeur(); // Ajoute la valeur des objets restants
		}
		this.borneSupérieure = res;
	}

	private void calcBorneInférieure() {
		// TODO
	}

	@Override
	public String toString() {
		String s = "";
		s += this.profondeur + " : " + this.value + "\n";
		if (this.leftTree != null)
			s += leftTree + "\n";
		if (this.rightTree != null)
			s += rightTree + "\n";
		return s;
	}
}
