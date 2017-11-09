package Method;

public abstract class Relatorios {

	public final void corpoRelatorio(){
		cabecalho();
		corpo();
		rodape();
	}
	
	public abstract void cabecalho();
	
	public abstract void corpo();
	
	public abstract void rodape();
	
}
