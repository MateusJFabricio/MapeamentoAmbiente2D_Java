package AutoMap.Infraestrucure;

public class PinoRPi {
	private int numPino;
	private int TipoPino;
	private int valorPino;
	
	public int getNumPino() {
		return numPino;
	}
	public void setNumPino(int numPino) {
		this.numPino = numPino;
	}
	public int getTipoPino() {
		return TipoPino;
	}
	public void setTipoPino(int tipoPino) {
		TipoPino = tipoPino;
	}
	public int getValorPino() {
		return valorPino;
	}
	
	public void setValorPino(int valorPino) {
		//Se for do tipo saida
		if (TipoPino == 1) {
			if (!(valorPino > 1)){
				this.valorPino = valorPino;
			}
		}else if (TipoPino == 2) {
			this.valorPino = valorPino;
		}
		
	}
}
