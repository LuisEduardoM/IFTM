package dip;
public class Piloto implements Acao {

    private CarroDeCorrida veiculo;

	public Piloto(CarroDeCorrida veiculo) {
		this.veiculo = veiculo;
	}

	@Override
	public void aumentaVelocidade() {
		veiculo.aumentaVelocidade();
	}
}