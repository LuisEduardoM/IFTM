package chainOfResponsability.vendas;

public class MaquinaVendas implements IMaquinaVendas {

	private final double VALOR_DO_CHIPS = 2.50;

	private final double VALOR_DO_REFRIGERANTE = 1.00;

	private double valor;

	@Override

	public void depositar(double valor) {

		this.valor += valor;

	}

	@Override

	public String getProduto() {

		if (this.valor >= VALOR_DO_CHIPS) {

			this.valor -= VALOR_DO_CHIPS;

			return "Chips";

		} else if (this.valor >= VALOR_DO_REFRIGERANTE) {

			this.valor -= VALOR_DO_REFRIGERANTE;

			return "Refrigente";

		}

		return "Saldo Insuficiênte para algum produto";

	}

	@Override

	public double getTroco() {

		return this.valor;

	}

}