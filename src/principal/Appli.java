package principal;

public class Appli {
	public static void main(String[] args) throws Exception {
		SacADos sac = new SacADos("itemsEval.txt", 20);

		sac.resoudre("glouton");

		System.out.println(sac);

	}
}
