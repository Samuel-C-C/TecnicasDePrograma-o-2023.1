package questao13;

public class Televisao {
	
	private boolean ligado;
	private int volumeIntensidade;
	private int canal;
	private boolean mutado;
	
	public boolean isLigado() {
		return ligado;
	}
	
	protected void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	public int getVolumeIntensidade() {
		return volumeIntensidade;
	}
	
	protected void setVolumeIntensidade(int volumeIntensidade) {
		this.volumeIntensidade = volumeIntensidade;
	}
	
	public int getCanal() {
		return canal;
	}
	
	protected void setCanal(int canal) {
		this.canal = canal;
	}
	
	public boolean isMutado() {
		return mutado;
	}
	
	protected void setMutado(boolean mutado) {
		this.mutado = mutado;
	}
	
	public Televisao() {
		this.ligado = false;
		this.volumeIntensidade = 0;
		this.canal = 1;
		this.mutado = false;
	}

}
