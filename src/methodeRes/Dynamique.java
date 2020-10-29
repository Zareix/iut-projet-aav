package methodeRes;

import java.util.ArrayList;

import principal.Item;
import principal.SacADos;

public class Dynamique {
	public static void dynamiqueRes(SacADos sac) {
		float multiplicateur = 10; // TODO : A voir où le déclarer

		ArrayList<Item> items = sac.getListeObjets();
		float[][] matrice = new float[items.size()][(int) (sac.getPoidsMaximal() * multiplicateur + 1)];

		// On remplit la première ligne de la matrice
		for (int j = 0; j <= sac.getPoidsMaximal() * multiplicateur; j++) {
			if (items.get(0).getPoids() * multiplicateur > j)
				matrice[0][j] = 0;
			else
				matrice[0][j] = items.get(0).getValeur() * multiplicateur;
		}

		// On remplit les autres lignes de la matrice
		for (int i = 1; i < items.size(); i++) {
			for (int j = 0; j <= sac.getPoidsMaximal() * multiplicateur; j++) {
				if (items.get(i).getPoids() * multiplicateur > j)
					matrice[i][j] = matrice[i - 1][j];
				else
					matrice[i][j] = (int) (Math.max(matrice[i - 1][j],
							matrice[i - 1][(int) (j - (items.get(i).getPoids() * multiplicateur))]
									+ items.get(i).getValeur() * multiplicateur));
			}
		}

		int i = items.size() - 1;
		int j = (int) (sac.getPoidsMaximal() * multiplicateur);
		/*
		 * On récupère dans la dernière ligne le poids minimal nécessaire pour faire le
		 * bénéfice optimal
		 */
		while (matrice[i][j] == matrice[i][j - 1])
			--j;

		// On récupère les objets
		while (j > 0) {
			while (i > 0 && matrice[i][j] == matrice[i - 1][j])
				--i;
			j = j - (int) (items.get(i).getPoids() * multiplicateur);
			if (j >= 0)
				sac.addItemSac(items.get(i));
			--i;
		}
	}
}
