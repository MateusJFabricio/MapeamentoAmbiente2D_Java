package AutoMap.Infraestrucure;

public class PinoRPi {
	private int numPino;
	
	private Pino tipoPino;
	
	enum Pino{
		Entrada, 
		Saida,
		SerialRead,
		SerialWrite,
		AnalogicoRead,
		AnalogicoWrite 
	}
	
	private int valorPino;
	
	public int getValorPino() {
			return valorPino;
	}
	
	public void setValorPino(int valorPino) {
		//Se for do tipo saida
		if (tipoPino == Pino.Saida) {
			if ((valorPino == 0) || (valorPino == 1)){
				this.valorPino = valorPino;
			}
		}else if (tipoPino == Pino.AnalogicoWrite) {
			if ((valorPino >= -3000) || (valorPino >= -3000))
				this.valorPino = valorPino;
		}
		
	}
}
