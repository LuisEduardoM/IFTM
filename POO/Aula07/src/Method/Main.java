package Method;

public class Main {

	public static void main(String[] args) {
		 Conta conta1 = new Conta("104", 123, "luis", 2000.00);
		 Conta conta2 = new Conta("104", 1872, "luis Eduardo", 200.00);
		 
		 Banco banco = new Banco("Itau", "(34) 3232-4526", "Tubal Vilela", "itau@.com.br", "02-02-1989");
		 banco.setContas(conta1);
		 banco.setContas(conta2);
		 
		 Relatorios relatorioSimples = new RelatorioSimples(banco);
		 System.out.println("############ RELATÓRIO SIMPLES ##############");
		 relatorioSimples.corpoRelatorio();
		 
		 Relatorios relatorioComplexo = new RelatorioComplexo(banco);
		 System.out.println("############ RELATÓRIO COMPLEXO ##############");
		 relatorioComplexo.corpoRelatorio();
		 
	}
}
