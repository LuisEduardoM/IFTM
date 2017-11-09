package Method;

public class RelatorioComplexo extends Relatorios {

	private Banco banco;
	
	public RelatorioComplexo(Banco banco) {
		this.banco = banco;
	}

	@Override
	public void cabecalho() {
		System.out.println(banco.getNomeBanco());
		System.out.println("Endereço " + banco.getEndereco() + " Telefone :" + banco.getTelefone());
	}

	@Override
	public void corpo() {
		banco.getContas().forEach(conta -> System.out.println("Titular " + conta.getTitular() + 
				" agencia " + conta.getAgencia() +
				" numero conta " + conta.getNumeroConta() +
				" saldo " + conta.getSaldo()));
	}

	@Override
	public void rodape() {
		System.out.println("Email: " + banco.getEmail() + " data atual " + banco.getDataAtual());
	}

}
