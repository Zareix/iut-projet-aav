package methodeRes;

import java.util.ArrayList;

import principal.ABR;
import principal.SacADos;
import principal.Item;

public class Pse {
	/**
	 * @param sac : le sac à résoudre
	 */
	public static void pseRes(SacADos sac) {
		ABR arbre = new ABR(sac.getListeObjets(), sac.getPoidsMaximal(), new ArrayList<Item>(), 0);
		arbre.calcMeilleurListe();

		for (Item item : ABR.getSolution())
			sac.addItemSac(item);
	}
}
