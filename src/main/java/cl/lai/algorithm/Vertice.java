package cl.lai.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertice implements Comparable<Vertice>{

	public final int name;
    public List<Arista> aristas = new ArrayList<Arista>();
    public Double distanciaMinima = Double.POSITIVE_INFINITY;
    public Vertice anterior;
    public Vertice(int argName) { name = argName; }
    public String toString() { return String.valueOf(name); }
    public int compareTo(Vertice other)
    {
        return Double.compare(distanciaMinima, other.distanciaMinima);
    }

}
