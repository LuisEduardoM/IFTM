package isp;

public class Drone extends Veiculo implements LigaDesligaCamera {

	private boolean cameraOn;

	public boolean isCameraOn() {
		return cameraOn;
	}

	@Override
	public void ligarCamera() {
		cameraOn = true;
	}

	@Override
	public void desligarCamera() {
		cameraOn = false;
	}
}