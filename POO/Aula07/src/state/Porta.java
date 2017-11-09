package state;

public class Porta {

	public IPortaState portaEstado;

	private Porta() {
		this.portaEstado = new PortaFechada(this);
	}
	
	public void abrir(){
		this.portaEstado.abrir();
		this.portaEstado = new PortaAberta();
				
	}
	
	public void fechar(){
		this.portaEstado.fechar();
		this.portaEstado = new PortaFechada(this);
	}
	
	
}
