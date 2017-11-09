package chainOfResponsability.vendas;

public class Main {

	public static void main(String[] args) {

		System.out.println("1ª Compra");

		MaquinaVendas maquina = new MaquinaVendas();

		maquina.depositar(1.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

		System.out.println("\n\n2ª Compra");

		maquina = new MaquinaVendas();

		maquina.depositar(10.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

		System.out.println("\n\n3ª Compra");

		maquina = new MaquinaVendas();

		maquina.depositar(9.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

	}

}