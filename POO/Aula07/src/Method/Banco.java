package Method;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nomeBanco;
	private String telefone;
	private String endereco;
	private String email;
	private String dataAtual;
	private List<Conta> contas;

	public Banco(String nomeBanco, String telefone, String endereco, String email, String dataAtual) {
		this.nomeBanco = nomeBanco;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataAtual = dataAtual;
		contas = new ArrayList<>();
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(String dataAtual) {
		this.dataAtual = dataAtual;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(Conta conta) {
		contas.add(conta);
	}
}
