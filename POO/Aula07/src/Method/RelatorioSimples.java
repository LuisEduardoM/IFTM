package Method;

public class RelatorioSimples extends Relatorios {
	
	private Banco banco;
	
	public RelatorioSimples(Banco banco) {
		this.banco = banco;
	}

	@Override
	public void cabecalho() {
		System.out.println(banco.getNomeBanco());
	}

	@Override
	public void corpo() {
		banco.getContas().forEach(conta -> System.out.println("Titular " + conta.getTitular() + " saldo " + conta.getSaldo()));
	}

	@Override
	public void rodape() {
		System.out.println(banco.getTelefone());
	}
}
