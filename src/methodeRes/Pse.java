package methodeRes;

import java.util.ArrayList;

import principal.ABR;
import principal.SacADos;
import principal.Item;

public class Pse {
	public static void pseRes(SacADos sac) {
		ABR arbre = new ABR(sac.getListeObjets(), sac.getPoidsMaximal(), new ArrayList<Item>(), 0);
		arbre.calcMeilleurListe();
		ArrayList<Item> sol = ABR.getSolution();
		
		for (Item item : sol) {
			sac.addItemSac(item);
		}
	}
}
