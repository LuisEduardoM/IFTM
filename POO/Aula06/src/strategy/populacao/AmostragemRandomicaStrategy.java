package strategy.populacao;

import java.util.ArrayList;
import java.util.Random;

public class AmostragemRandomicaStrategy extends AmostragemStrategy {

	private int[] populacao;
	
	public AmostragemRandomicaStrategy(int[] populacao) {
		this.populacao = populacao;
	}

	@Override
	public int[] selecionaSubconjunto(int tamanhoAmostra) {
		int[] subConjunto = new int[tamanhoAmostra];
		Random generator = new Random();

		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		for (int i = 0; i < populacao.length; i++)
			tempArray.add(populacao[i]);

		for (int i = 0; i < tamanhoAmostra; i++){
			subConjunto[i] = tempArray.remove(generator.nextInt(tempArray.size()));
		}

		return subConjunto;
	}

	public int[] getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int[] populacao) {
		this.populacao = populacao;
	}
}
