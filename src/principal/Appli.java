package principal;

public class Appli {
	public static void main(String[] args) throws Exception {
		SacADos sac = new SacADos("items.txt", 6);

		sac.resoudre("dynamique");

		System.out.println(sac);

	}
}
