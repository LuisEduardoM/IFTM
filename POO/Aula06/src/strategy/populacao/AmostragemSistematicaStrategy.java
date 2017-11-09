package strategy.populacao;

import java.util.Arrays;
import java.util.Random;

public class AmostragemSistematicaStrategy extends AmostragemStrategy {
	
	private int[] populacao;

	public AmostragemSistematicaStrategy(int[] populacao) {
		this.populacao = populacao;
	}

	@Override
	public int[] selecionaSubconjunto(int tamanhoAmostra) {
		int[] subConjunto = new int[tamanhoAmostra];
		Random generator = new Random();

		int[] populacaoOrdenada = new int[populacao.length];
		System.arraycopy(populacao, 0, populacaoOrdenada, 0, populacao.length);
		Arrays.sort(populacaoOrdenada);

		int step = populacaoOrdenada.length / tamanhoAmostra;
		int startingPoint = generator.nextInt(step);

		for (int i = 0; i < tamanhoAmostra; i++){
			subConjunto[i] = populacaoOrdenada[startingPoint + (i * step)];
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
