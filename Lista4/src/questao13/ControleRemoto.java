package questao13;

public class ControleRemoto {
	
	private Televisao televisao;
	
	public Televisao getTelevisao() {
		return televisao;
	}

	public ControleRemoto(Televisao televisao) {
		this.televisao = televisao;
	}
	
	private void ligarTv() {
		this.televisao.setLigado(true);
	}
	
	private void desligarTv() {
		this.televisao.setLigado(false);
	}
	
	public void ligarDesligarTv() {
		if (this.televisao.isLigado()) {
			this.desligarTv();
		} else {
			this.ligarTv();
		}
	}
	
	public void aumentarVolume() {
		if (this.televisao.isLigado()) {
			
			int volumeTv = this.televisao.getVolumeIntensidade();
			
			if (volumeTv < 100) {
				this.televisao.setVolumeIntensidade(volumeTv + 1);
			}
			
		}
		
	}
	
	public void diminuirVolume() {
		if (this.televisao.isLigado()) {
			int volumeTv = this.televisao.getVolumeIntensidade();
			
			if (volumeTv > 0) {
				this.televisao.setVolumeIntensidade(volumeTv - 1);
			}
			
		}
		
	}
	
	public void aumentarCanal() {
		if (this.televisao.isLigado()) {
			int canal = this.televisao.getCanal();
			
			if (canal < 999) {
				this.televisao.setCanal(canal + 1);
			}
			
		}
		
	}
	
	public void diminuirCanal() {
		if (this.televisao.isLigado()) {
			int canal = this.televisao.getCanal();
			
			if (canal > 0) {
				this.televisao.setCanal(canal - 1);
			}
			
		}
		
	}
	
	public int consultarVolume() {
		if (this.televisao.isLigado()) {
			return this.televisao.getVolumeIntensidade();
		} else {
			return 0;
		}
	}
	
	public int consultarCanal() {
		if (this.televisao.isLigado()) {
			return this.televisao.getCanal();
		} else {
			return 0;
		}
	}
	
	public void mudarCanal(int novoCanal) {
		if (this.televisao.isLigado()) {
			if (0 <= novoCanal && novoCanal <= 999) {
				this.televisao.setCanal(novoCanal);
			}
			
		}
		
	}
	
	private void mutar() {
		if (this.televisao.isLigado()) {
			this.televisao.setMutado(true);
			
		}
		
	}
	
	private void desmutar() {
		if (this.televisao.isLigado()) {
			this.televisao.setMutado(false);
			
		}
		
	}
	
	public void mutarDesmutarTv() {
		if (this.televisao.isMutado()) {
			this.desmutar();
		} else {
			this.mutar();
		}
	}

}
