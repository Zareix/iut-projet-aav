package methodeRes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import principal.Item;
import principal.SacADos;

public class Glouton {
	public static void gloutonRes(SacADos sac) {
		List<Item> items = sac.getListeObjets();

		/*
		 * Le tri dans l'ordre décroissant selon le rapport v/p n'est utile que pour
		 * cette méthode. On a donc décidé d'utiliser un Comparator et la méthode Sort
		 * plutôt qu'override "compare" dans la classe Item directement
		 */
		Collections.sort(items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return (int) (o2.getValeur() / o2.getPoids() - o1.getValeur() / o1.getPoids());
			}
		});

		for (int i = 0; i < items.size(); i++) {
			if (sac.poidsActuel() + items.get(i).getPoids() < sac.getPoidsMaximal())
				sac.addItemSac(items.get(i));
		}
	}
}
