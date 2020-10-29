package principal;

import java.util.ArrayList;

public class ABR {
	private ABR leftTree, rightTree;

	private ArrayList<Item> value;
	private int profondeur;

	private static float borneInférieure;
	private float borneSupérieure;

	private static ArrayList<Item> solution;

	/**
	 * @param listeObjetsPossibles
	 * @param poidsMaximal
	 * @param listeItems
	 * @param profondeur
	 */
	public ABR(ArrayList<Item> listeObjetsPossibles, float poidsMaximal, ArrayList<Item> listeItems, int profondeur) {
		if (profondeur <= listeObjetsPossibles.size()) {
			this.value = new ArrayList<>(listeItems);
			this.profondeur = profondeur;

			calcBorneInférieure();
			calcBorneSupérieure(listeObjetsPossibles);

			if (profondeur != listeObjetsPossibles.size()) {
				this.leftTree = new ABR(listeObjetsPossibles, poidsMaximal, new ArrayList<>(listeItems),
						profondeur + 1);

				listeItems.add(listeObjetsPossibles.get(profondeur));
				if (poidsListe(listeItems) <= poidsMaximal && this.borneSupérieure > ABR.borneInférieure)
					this.rightTree = new ABR(listeObjetsPossibles, poidsMaximal, new ArrayList<>(listeItems),
							profondeur + 1);
			}
		}
	}

	/**
	 * Retourne le poids d'une liste d'items donnée en paramètre
	 * 
	 * @param liste
	 * @return poids de la liste
	 */
	private float poidsListe(ArrayList<Item> liste) {
		float res = 0;
		for (Item item : liste)
			res += item.getPoids();
		return res;
	}

	/**
	 * Retourne la valeur du noeud
	 * 
	 * @return valeur du noeud
	 */
	private float valeurNoeud() {
		float res = 0;
		for (Item item : this.value)
			res += item.getValeur();
		return res;
	}

	/**
	 * Calcule la borne supérieure du noeud
	 * 
	 * @param listeObjetsPossibles
	 */
	private void calcBorneSupérieure(ArrayList<Item> listeObjetsPossibles) {
		float res = 0;
		res += valeurNoeud(); // Ajoute la valeur actuelle du noeud
		for (int i = this.profondeur; i < listeObjetsPossibles.size(); i++)
			res += listeObjetsPossibles.get(i).getValeur(); // Ajoute la valeur des objets restants
		this.borneSupérieure = res;
	}

	/**
	 * Met à jour la borne inférieure de l'arbre
	 */
	private void calcBorneInférieure() {
		if (valeurNoeud() > ABR.borneInférieure)
			ABR.borneInférieure = this.valeurNoeud();
	}

	/**
	 * Met à jour la borne inférieure de l'arbre
	 */
	public void calcMeilleurListe() {
		if (this.valeurNoeud() == ABR.borneInférieure)
			ABR.solution = this.value;
		else {
			if (this.leftTree == null && this.rightTree == null)
				return;
			if (this.leftTree == null)
				this.rightTree.calcMeilleurListe();
			if (this.rightTree == null)
				this.leftTree.calcMeilleurListe();
			if (this.rightTree != null && this.leftTree != null) {
				this.rightTree.calcMeilleurListe();
				this.leftTree.calcMeilleurListe();
			}
		}
	}

	/**
	 * Retourne la solution
	 * 
	 * @return solution
	 */
	public static ArrayList<Item> getSolution() {
		return new ArrayList<Item>(solution);
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
