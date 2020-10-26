package methodeRes;

import java.util.ArrayList;

import principal.ABR;
import principal.SacADos;
import principal.Item;

public class Pse {
	public static void PseRes(SacADos sac) {
		ABR arbre = new ABR(sac.getListeObjets(), sac.getPoidsMaximal(), new ArrayList<Item>(), 0);
		// System.out.println(arbre);
	}
}
