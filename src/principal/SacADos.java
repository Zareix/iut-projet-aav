package principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
	private ArrayList<Item> contenu;
	private ArrayList<Item> listeObjetsPossibles;
	private float poidsMaximal;

	public SacADos() {
		this.contenu = new ArrayList<Item>();
	}

	public SacADos(String chemin, float poidsMaximal) {
		this();
		this.listeObjetsPossibles = new ArrayList<Item>();
		readItems(chemin);
		this.poidsMaximal = poidsMaximal;
	}

	private void readItems(String chemin) {
		try {
			Scanner file = new Scanner(new FileInputStream(chemin));
			while (file.hasNextLine()) {
				Scanner scLine = new Scanner(file.nextLine());
				String line[] = scLine.nextLine().split(" ; ");
				listeObjetsPossibles.add(new Item(line[0], Float.valueOf(line[1]), Float.valueOf(line[2])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public float getPoidsMaximal() {
		return poidsMaximal;
	}

	public ArrayList<Item> getContenu() {
		return new ArrayList<>(contenu);
	}

	public ArrayList<Item> getListeObjets() {
		return new ArrayList<>(listeObjetsPossibles);
	}

	public float valeurActuel() {
		float v = 0;
		for (Item item : contenu)
			v += item.getValeur();
		return v;
	}

	public float poidsActuel() {
		float p = 0;
		for (Item item : contenu)
			p += item.getPoids();
		return p;
	}

	public void addItemSac(Item item) {
		contenu.add(item);
	}

	public void resoudre() {
		// TODO
	}

	@Override
	public String toString() {
		return "Contenu du sac : " + contenu.toString() + "\n" + "Poids du sac : " + poidsActuel()
				+ " / Valeur du sac : " + valeurActuel();
	}
}
