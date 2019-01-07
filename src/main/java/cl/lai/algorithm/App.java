package cl.lai.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedMultigraph;



/**
 * Hello world!
 *
 */
public class App 
{
	 


    public static void main( String[] args ) throws Exception {
    	
    	DirectedWeightedMultigraph<Integer, DefaultWeightedEdge> g = new DirectedWeightedMultigraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
    	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0]))));
    	int nodos = Integer.parseInt(reader.readLine());
    	for(int i=1; i<=nodos;i++)
    		g.addVertex(i);
    	
    	reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[1]))));
    	String aux = null;
    	while((aux=reader.readLine())!=null) {
    		if("EOF".equalsIgnoreCase(aux)) break;
    		String array[] = aux.split(" ");
    		DefaultWeightedEdge e = g.addEdge(Integer.parseInt(array[0]),Integer.parseInt(array[1]));
			g.setEdgeWeight(e,Integer.parseInt(array[2]));
			
    	}
    	DijkstraShortestPath<Integer, DefaultWeightedEdge> dij = new DijkstraShortestPath<Integer, DefaultWeightedEdge>(g);
    	
    	
    	for(int i=1; i<=nodos;i++) {
    		PrintWriter writer = new PrintWriter(new File(args[2]+"/salida_"+i+".txt"));
    		writer.println(i);
    		
    		for(int j=1;j<=nodos;j++) {
    			if(i==j)
    				writer.println(i+" "+i+" "+0);
    			else {
    				if(dij.getPath(i,j)==null) {
    					writer.println(j+" "+-1+" "+0);
    				}else {
    					List<Integer> lists =  dij.getPath(i,j).getVertexList();
        				writer.println(j+" "+lists.get(lists.size()-2)+" "+(int)dij.getPath(i,j).getWeight());
    				}
    				
    			}
    		}
    		writer.close();
    	}
    	
    	
    	/*
    	System.out.println(dij.getPathWeight(1, 6));
    	for(Integer e: dij.getPath(1, 5).getVertexList()){
			System.out.println(e);
		}
		*/
    	
    			 
    	
    }
}
