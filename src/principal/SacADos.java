package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import methodeRes.Dynamique;
import methodeRes.Glouton;

public class SacADos {
	private ArrayList<Item> listeObjetsPossibles;
	private float poidsMaximal;

	public SacADos() {
	}

	public SacADos(String chemin, float poidsMaximal) throws Exception {
		this();
		this.listeObjetsPossibles = new ArrayList<Item>();
		readItems(chemin);
		this.poidsMaximal = poidsMaximal;
	}

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

	public float getPoidsMaximal() {
		return poidsMaximal;
	}

	public ArrayList<Item> getListeObjets() {
		return new ArrayList<>(listeObjetsPossibles);
	}

	public float valeurActuel() {
		float v = 0;
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				v += item.getValeur();
		return v;
	}

	public float poidsActuel() {
		float p = 0;
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				p += item.getPoids();
		return p;
	}

	public void addItemSac(Item item) {
		item.setStocké(true);
	}

	public void resoudre(String methode) {
		switch (methode) {
		case "glouton":
			Glouton.gloutonRes(this);
			break;
		case "dynamique":
			Dynamique.dynamiqueRes(this);
			break;
		case "pse":
			break;
		default:
			throw new IllegalArgumentException(methode + " n'est pas une méthode de resolution définie.");
		}
	}

	@Override
	public String toString() {
		String contenu = "";
		for (Item item : listeObjetsPossibles)
			if (item.getStocké())
				contenu += item.toString() + " | ";

		return "Contenu du sac : " + contenu + "\n" + "Poids du sac : " + poidsActuel() + " / Valeur du sac : "
				+ valeurActuel();
	}
}
