package Glouton;

import java.util.Collections;
import java.util.List;

import Principal.Item;
import Principal.SacADos;

public class glouton {
	public static void glouton(SacADos sac) {
		List<Item> items = sac.getListeObjets();
		Collections.sort(items);
		System.out.println(items);
		
		for (int i = 0; i < items.size(); i++) {
			if(sac.poidsActuel() + items.get(i).getPoids() < sac.getPoidsMaximal())
				sac.addItemSac(items.get(i));
		}
	}
	
	public static void main(String[] args) {
		SacADos sac = new SacADos("items.txt", 50);
		glouton(sac);
		System.out.println(sac.getContenu());
	}
}
