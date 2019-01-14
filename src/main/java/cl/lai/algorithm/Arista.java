package cl.lai.algorithm;

public class Arista {

	public  Vertice destino;
	
	public double peso;

	public Arista(Vertice destino, double peso) {
		this.peso = peso;
		this.destino = destino;
		
	}

	public Vertice getDestino() {
		return destino;
	}

	public double getPeso() {
		return peso;
	}

}
