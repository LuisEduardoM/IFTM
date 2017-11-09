package srp;
public class VeiculoAcao implements IVeiculoAcao {

	private Veiculo veiculo;
	
	public VeiculoAcao(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	@Override
	public void acelerar() {
		veiculo.acelerar();
	}
}