package chainOfResponsability.vendas;

public class Main {

	public static void main(String[] args) {

		System.out.println("1� Compra");

		MaquinaVendas maquina = new MaquinaVendas();

		maquina.depositar(1.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

		System.out.println("\n\n2� Compra");

		maquina = new MaquinaVendas();

		maquina.depositar(10.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

		System.out.println("\n\n3� Compra");

		maquina = new MaquinaVendas();

		maquina.depositar(9.0);

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getProduto());

		System.out.println(maquina.getTroco());

	}

}