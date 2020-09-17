package methodeRes;

import java.util.ArrayList;

import principal.Item;
import principal.SacADos;

public class Dynamique {
	public static void dynamiqueRes(SacADos sac) {
		ArrayList<Item> items = sac.getListeObjets();
		float [][] matrice = new float[items.size()][(int) sac.getPoidsMaximal() + 1];	
		
		for (int j = 0; j < sac.getPoidsMaximal(); j++) {
			if (items.get(0).getPoids() > j)
				matrice[0][j] = 0;
			else
				matrice[0][j] = items.get(0).getValeur();
			
			for (int i = 1 ; i <matrice.length ; ++i) {
				if (items.get(i).getPoids() > j) 
					matrice[i][j] = matrice[i-1][j];
				else
					matrice[i][j] = Math.max(matrice[i-1][j],  matrice[i-1][(int) (j- items.get(i).getPoids())] + items.get(i).getValeur() );
				
			}
		}
		
		
	}
}
