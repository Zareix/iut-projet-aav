package principal;

public class Appli {
	public static void main(String[] args) throws Exception {
		SacADos sac = new SacADos("items.txt", 50);

		sac.resoudre("glouton");

		System.out.println(sac);
	}
}
