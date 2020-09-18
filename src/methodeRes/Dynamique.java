package methodeRes;

import java.util.ArrayList;

import principal.Item;
import principal.SacADos;

public class Dynamique {
	public static void dynamiqueRes(SacADos sac) {
		ArrayList<Item> items = sac.getListeObjets();
		float[][] matrice = new float[items.size()][(int) sac.getPoidsMaximal() + 1];

		int j = 0;
		
		while(j < sac.getPoidsMaximal()) {
			if (items.get(0).getPoids() > j)
				matrice[0][j] = 0;
			else
				matrice[0][j] = items.get(0).getValeur();
			j++;

			int  i = 0;
			while(i < matrice.length) {
				if (items.get(i).getPoids() > j)
					matrice[i][j] = matrice[i - 1][j];
				else
					matrice[i][j] = Math.max(matrice[i - 1][j],
							matrice[i - 1][(int) (j - items.get(i).getPoids())] + items.get(i).getValeur());
				
				while(matrice[i][j] == matrice[i][j - 1])
					j--;
				
				while(j > 0) {
					while(i > 0 && matrice[i][j] == matrice[i - 1][j])
						i--;
					j = j - (int) items.get(i).getPoids();
					if (j > 0)
						sac.addItemSac(items.get(i));
					i--;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		SacADos sac = new SacADos("items.txt", 5);
		dynamiqueRes(sac);
		
		System.out.println(sac.getContenu());
		
	}
}
