package principal;

import methodeRes.*;

public class Appli {
	public static void main(String[] args) {
		SacADos sac = new SacADos("items.txt", 6);
		Glouton.gloutonRes(sac);

		System.out.println(sac);

	}
}
