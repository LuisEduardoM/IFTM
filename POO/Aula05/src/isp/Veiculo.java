package isp;

public abstract class Veiculo implements LigaDesligaVeiculo {

	private boolean motorLigado;

	public boolean isMotorRodando() {
		return motorLigado;
	}

	@Override
	public void ligar() {
		motorLigado = true;
	}

	@Override
	public void desligar() {
		motorLigado = false;
	}

}