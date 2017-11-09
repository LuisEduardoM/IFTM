package strategy.semana;

public class Teste {
	
	public static void main(String[] args) {
		
		DiaSemanaStrategy domingo = new Domingo();
		DiaSemanaStrategy segunda = new Segunda();
		DiaSemanaStrategy terca = new Terca();
		DiaSemanaStrategy quarta = new Quarta();
		DiaSemanaStrategy quinta = new Quinta();
		DiaSemanaStrategy sexta = new Sexta();
		DiaSemanaStrategy sabado = new Sabado();
		
		System.out.println(domingo.mensagemDiaSemana());
		System.out.println(segunda.mensagemDiaSemana());
		System.out.println(terca.mensagemDiaSemana());
		System.out.println(quarta.mensagemDiaSemana());
		System.out.println(quinta.mensagemDiaSemana());
		System.out.println(sexta.mensagemDiaSemana());
		System.out.println(sabado.mensagemDiaSemana());
	}
}
