package strategy.populacao;

public class Cliente {
	public static void main(String args[]) {

		// Populacao
		int[] zipCodes = new int[] { 66209, 64113, 10162, 90210, 61701, 55901, 48823, 62901, 50014 };
		int[] amostra = null;

		AmostragemStrategy amostragemRandomicaStrategy = new AmostragemRandomicaStrategy(zipCodes);
		amostra = amostragemRandomicaStrategy.selecionaSubconjunto(3);

		System.out.println("######## RANDOMICA ##########");
		for (int i = 0; i < amostra.length; i++) {
			System.out.println(amostra[i]);
		}

		AmostragemStrategy amostragemSistematicaStrategy = new AmostragemSistematicaStrategy(zipCodes);
		amostra = amostragemSistematicaStrategy.selecionaSubconjunto(3);

		System.out.println("######## SISTEMATICA ##########");
		for (int i = 0; i < amostra.length; i++) {
			System.out.println(amostra[i]);
		}
	}
}