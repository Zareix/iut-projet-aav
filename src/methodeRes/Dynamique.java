package methodeRes;

import java.util.ArrayList;

import principal.Item;
import principal.SacADos;

public class Dynamique {
	public static void dynamiqueRes(SacADos sac) {
		ArrayList<Item> items = sac.getListeObjets();
		float[][] matrice = new float[items.size()][(int) sac.getPoidsMaximal() * 10 + 1];

		// On remplit la première ligne de la matrice
		for (int j = 0; j <= sac.getPoidsMaximal() * 10; j++) {
			if (items.get(0).getPoids() * 10 > j)
				matrice[0][j] = 0;
			else
				matrice[0][j] = (int) items.get(0).getValeur() * 10;
		}

		// On remplit les autres lignes de la matrice
		for (int i = 1; i < items.size(); i++) {
			for (int j = 0; j <= sac.getPoidsMaximal() * 10; j++) {
				if (items.get(i).getPoids() * 10 > j)
					matrice[i][j] = matrice[i - 1][j];
				else
					matrice[i][j] = (int) (Math.max(matrice[i - 1][j],
							matrice[i - 1][(int) (j - (items.get(i).getPoids() * 10))]
									+ items.get(i).getValeur() * 10));
			}
		}

		int i = items.size() - 1;
		int j = (int) (sac.getPoidsMaximal() * 10);
		/*
		 * on récupère dans la dernière ligne le poids minimal nécessaire pour faire le
		 * bénéfice optimal
		 */
		while (matrice[i][j] == matrice[i][j - 1])
			--j;

		// On récupère les objets
		while (j > 0) {
			while (i > 0 && matrice[i][(int) j] == matrice[i - 1][(int) j])
				--i;
			j = j - (int) (items.get(i).getPoids() * 10);
			if (j >= 0)
				sac.addItemSac(items.get(i));
			--i;
		}
	}
}
