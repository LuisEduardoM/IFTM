package strategy.populacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Amostrador {
	private int[] populacao;

	public Amostrador(int[] codigosZip) {
		populacao = codigosZip;
	}

	public int[] selecionaSubconjunto(int tamanhoAmostra, String metodo) {
		if (metodo.equals("randomico")) {
			int[] subConjunto = new int[tamanhoAmostra];
			Random generator = new Random();

			// faz uma cópia usando ArrayList
			// fica fácil amostrar sem repetir
			ArrayList<Integer> tempArray = new ArrayList<Integer>();
			for (int i = 0; i < populacao.length; i++)
				tempArray.add(populacao[i]);

			for (int i = 0; i < tamanhoAmostra; i++)
				subConjunto[i] = tempArray.remove(generator.nextInt(tempArray.size()));

			return subConjunto;
		} else if (metodo.equals("sistematico")) {
			int[] subConjunto = new int[tamanhoAmostra];
			Random generator = new Random();

			// faz cópia da população.
			// não queremos causar efeitos colaterais.
			int[] populacaoOrdenada = new int[populacao.length];
			System.arraycopy(populacao, 0, populacaoOrdenada, 0, populacao.length);
			Arrays.sort(populacaoOrdenada);

			int step = populacaoOrdenada.length / tamanhoAmostra;
			int startingPoint = generator.nextInt(step);

			// seleciona elementos em intervalo regular ‘step’
			for (int i = 0; i < tamanhoAmostra; i++)
				subConjunto[i] = populacaoOrdenada[startingPoint + (i * step)];

			return subConjunto;
		}
		return null;
	}

	public int[] getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int[] populacao) {
		this.populacao = populacao;
	}
}
