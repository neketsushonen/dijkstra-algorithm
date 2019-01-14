package cl.lai.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;

/**
 * Hello world!
 *
 */
public class Dial {
	public static List<Vertice> obtenerLaRutaMinima(Vertice target) {
		List<Vertice> path = new ArrayList<Vertice>();
		for (Vertice Vertice = target; Vertice != null; Vertice = Vertice.anterior)
			path.add(Vertice);

		Collections.reverse(path);
		return path;
	}

	public static void calcularRutas(Vertice source) {
		PriorityQueue<Vertice> listaVertice = new PriorityQueue<Vertice>();

		source.distanciaMinima = 0.;
		listaVertice.add(source);

		while (!listaVertice.isEmpty()) {
			Vertice u = listaVertice.poll();

			for (Arista e : u.aristas) {
				Vertice v = e.destino;
				double peso = e.peso;
				double distancias = u.distanciaMinima + peso;
				if (distancias < v.distanciaMinima) {
					listaVertice.remove(v);

					v.distanciaMinima = distancias;
					v.anterior = u;
					listaVertice.add(v);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		HashMap<Integer, Vertice> vertices = new HashMap<Integer, Vertice>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
		int nodos = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= nodos; i++) {
			vertices.put(i, new Vertice(i));
		}

		reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[1]))));
		String aux = null;
		while ((aux = reader.readLine()) != null) {
			if ("EOF".equalsIgnoreCase(aux))
				break;
			String array[] = aux.split(" ");
			vertices.get(Integer.parseInt(array[0])).aristas
					.add(new Arista(vertices.get(Integer.parseInt(array[1])), Integer.parseInt(array[2])));

		}

		for (int i = 1; i <= nodos; i++) {
			PrintWriter writer = new PrintWriter(new File(args[2] + "/salida_" + i + ".txt"));
			writer.println(i);
			calcularRutas(vertices.get(i));
			for (int j = 1; j <= nodos; j++) {
				if (i == j)
					writer.println(i + " " + i + " " + 0);
				else {
					try {
						List<Vertice> vtx = obtenerLaRutaMinima(vertices.get(j));
						writer.println(
								j + " " + vtx.get(vtx.size() - 2) + " " + vertices.get(j).distanciaMinima.intValue());

					} catch (Exception e) {
						writer.println(j + " " + -1 + " " + 0);

					}

				}
			}
			writer.close();
		}

	}
}
