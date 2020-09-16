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
	
	private static void readItems(String chemin) {
		try {
			Scanner file = new Scanner(new FileInputStream(chemin));
			while (file.hasNextLine()){
				Scanner scLine = new Scanner(file.nextLine());
				String line ="";
				String name="";float poids;float valeur;
				line = scLine.nextLine();
				
				for(int i=0; i< line.length();++i) {
					if (line[i] ==';') {
						
					}
				}
				
				
				Item it = new Item();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	@Override
	public String toString() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		return super.toString();
	}
	
	public void resoudre() {
		//TODO
	}
}
