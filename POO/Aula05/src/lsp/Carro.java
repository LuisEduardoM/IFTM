package lsp;

public class Carro {

	private Manipulador manipulador;

	public Carro(Manipulador manipulador) {
		this.manipulador = manipulador;
	}

	public void mudaMarcha(Marcha marcha) {
		if (Marcha.R.equals(marcha) && manipulador.getMarcha().equals(Marcha.D)) {
			throw new RuntimeException("Não pode mudar para REVERSE quando " + manipulador.getMarcha().toString()
					+ " marcha está engatada!");
		}
		
		manipulador.mudaMarcha(marcha);
	}
}