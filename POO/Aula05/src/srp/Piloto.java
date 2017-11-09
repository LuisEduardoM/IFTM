package srp;
public class Piloto {

	private Veiculo veiculo;
	
	public Piloto(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void abastecer(int litros) {
		this.veiculo.setQuantidadeCombustivel(litros);
	}
}