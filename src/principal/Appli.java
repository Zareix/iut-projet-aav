package principal;

import java.util.Scanner;

public class Appli {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entrer le chemin du fichier d'items : ");
		String chemin = sc.nextLine();

		System.out.println("Entrer le poids maximal du sac : ");
		float poidsMax = Float.parseFloat(sc.nextLine());

		System.out.println("Entrer la méthode de résolution ('glouton', 'dynamique' ou 'pse') :");
		String methode = sc.nextLine();

		sc.close();

		System.out.println(System.lineSeparator() + "Chemin : " + chemin + System.lineSeparator() + "Poids Max : "
				+ poidsMax + System.lineSeparator() + "Méthode : " + methode);

		SacADos sac = new SacADos(chemin, poidsMax);
		sac.resoudre(methode);

		System.out.println(System.lineSeparator() + "Résultat de la résolution" + System.lineSeparator() + sac);
	}
}