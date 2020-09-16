package Principal;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SacADos {
	ArrayList<Item> contenu;
	ArrayList<Item> listeObjets;
	float poidsMaximal;

	public SacADos() {
		contenu = new ArrayList<Item>();
	}

	public SacADos(String chemin, float poidsMaximal) {
		contenu = new ArrayList<Item>();
		listeObjets = new ArrayList<Item>();
		readItems(chemin);
		this.poidsMaximal = poidsMaximal;

	}
	
	public float getPoidsMaximal() {
		return poidsMaximal;
	}
	
	public ArrayList<Item> getContenu() {
		return contenu;
	}

	private void readItems(String chemin) {
		try {
			Scanner file = new Scanner(new FileInputStream(chemin));
			while (file.hasNextLine()) {
				Scanner scLine = new Scanner(file.nextLine());
				String line[] = scLine.nextLine().split(" ; ");
				listeObjets.add(new Item(line[0], Float.valueOf(line[1]), Float.valueOf(line[2])));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return contenu.toString() + " " + poidsActuel() + valeurActuel();
	}

	private float valeurActuel() {
		float v = 0;
		for (Item item : contenu)
			v += item.getValeur();
		return v;
	}

	public float poidsActuel() {
		float p = 0;
		for (Item item : contenu)
			p += item.getPoids();
		return p ;
	}

	public void resoudre() {
		// TODO
	}
	
	public void addItemSac(Item it) {
		contenu.add(it);
	}
	
	public ArrayList<Item> getListeObjets() {
		return new ArrayList<>(listeObjets);
	}
	
	public static void main(String[] args) {
		SacADos sac = new SacADos("Items.txt", 10);
		System.out.println(sac.listeObjets.toString());
	}
}
