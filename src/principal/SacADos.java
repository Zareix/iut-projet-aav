package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import methodeRes.Dynamique;
import methodeRes.Glouton;
import methodeRes.Pse;

public class SacADos {
	private ArrayList<Item> listeObjetsPossibles; // La liste récupérée depuis le fichier d'items
	private float poidsMaximal;

	/**
	 * Créer un sac vide
	 */
	public SacADos() {
		this.listeObjetsPossibles = new ArrayList<Item>();
	}

	/**
	 * Créer un sac pour un poids max donné et un liste d'items
	 * 
	 * @param chemin       : chemin du fichier d'items
	 * @param poidsMaximal : poids max du sac
	 * @throws Exception : FileNotFoundException
	 */
	public SacADos(String chemin, float poidsMaximal) throws Exception {
		this.listeObjetsPossibles = new ArrayList<Item>();
		readItems(chemin);
		this.poidsMaximal = poidsMaximal;
	}

	/**
	 * Lit la liste des objets depuis un fichier texte donné en paramètre
	 * 
	 * @param chemin : le chemin du fichier d'items
	 * @throws Exception : FileNotFoundException
	 */
	private void readItems(String chemin) throws Exception {
		try {
			Scanner file = new Scanner(new FileInputStream(chemin));
			while (file.hasNextLine()) {
				Scanner scLine = new Scanner(file.nextLine());
				String line[] = scLine.nextLine().split(" ; ");
				listeObjetsPossibles.add(new Item(line[0], Float.valueOf(line[1]), Float.valueOf(line[2])));
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Impossible de trouver le fichier " + chemin);
		}

	}

	/**
	 * Retourne le poids maximal du sac
	 * 
	 * @return poids max du sac
	 */
	public float getPoidsMaximal() {
		return poidsMaximal;
	}

	/**
	 * Retourne une copie des la liste des objets possibles
	 * 
	 * @return ArrayList des items possibles
	 */
	public ArrayList<Item> getListeObjets() {
		return new ArrayList<Item>(listeObjetsPossibles);
	}

	/**
	 * Retourne la valeur totale des objets dans le sac
	 * 
	 * @return valeur actuelle du sac
	 */
	public float valeurActuel() {
		float v = 0;
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				v += item.getValeur();
		return v;
	}

	/**
	 * Retourne le poids totale des objets dans le sac
	 * 
	 * @return poids actuel du sac
	 */
	public float poidsActuel() {
		float p = 0;
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				p += item.getPoids();
		return p;
	}

	/**
	 * Ajoute un item dans le sac
	 * 
	 * @param item
	 */
	public void addItemSac(Item item) {
		item.setStocké(true);
	}

	/**
	 * Résout le problème du sac selon la méthode passée en paramètre
	 * 
	 * @param methode : méthode choisie
	 */
	public void resoudre(String methode) {
		switch (methode) {
		case "glouton":
			Glouton.gloutonRes(this);
			break;
		case "dynamique":
			Dynamique.dynamiqueRes(this);
			break;
		case "pse":
			Pse.pseRes(this);
			break;
		default:
			throw new IllegalArgumentException(methode + " n'est pas une méthode de résolution définie.");
		}
	}

	@Override
	public String toString() {
		StringBuilder contenu = new StringBuilder();
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				contenu.append(item.toString() + " | ");
		contenu.deleteCharAt(contenu.lastIndexOf("|"));

		DecimalFormat df = new DecimalFormat("#.##"); // Permet de formater l'affichage des floats
		return "Contenu du sac : " + contenu + System.lineSeparator() + "Poids du sac : " + df.format(poidsActuel())
				+ "kg" + System.lineSeparator() + "Valeur du sac : " + df.format(valeurActuel());
	}
}
