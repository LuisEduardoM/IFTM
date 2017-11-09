package state;

public class PortaFechada implements IPortaState {
	
	private Porta porta;
	
	public PortaFechada(Porta porta) {
		this.porta = porta;
	}

	@Override
	public void abrir() {
		porta.portaEstado = new PortaAbrindo();
		//porta.portaEstado.
		
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abertura() {
		// TODO Auto-generated method stub
		
	}

}
