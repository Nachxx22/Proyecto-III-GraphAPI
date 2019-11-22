package cr.ac.tec.graph.api.dto;

import java.util.UUID;

public class GraphNode {
	private String name;
	private static Lista edges;
	private UUID key = UUID.randomUUID();
	 private int deleteCount;
	 
	public GraphNode(String name) {
		super();
		this.name = name;
	}
	public GraphNode() {
		this.key = UUID.randomUUID();
		this.edges = edges;
	}

	public String getName() {
		return name;
	}

	public String setName(String nombre) {
		this.name = nombre;
		return name;
	}

	public String print() {
		return "\n \tNode [city=" + name + ", edges=" + edges + "]";
	}

	public void addEdge(Edge edge) {
		edge.printEdges();
		if (edges == null) {
			edges = new Lista();
		}
		edges.addLast(edge);

	}

	public Lista getEdges() {
		return edges;

	}

	public UUID getKey() {
		return key;
	}

	  public void deleteGraphNode(Graph graph){
	        int nodeKey = graph.getNodes().getIndex(this) ;
	        for(int i = 0; i< edges.size; i++) {
	            Edge temp = ((Edge) edges.ver(i));
	            GraphNode delete = this;
	            if (temp.destination.equals(delete)) {
	                edges.eliminar(i);
	                delete.deleteGraphNode(graph);
	            }
	            if (temp.origin.equals(delete)){
	                edges.eliminar(i);
	                delete.deleteGraphNode(graph);
	            }
	        }
	        if(deleteCount == 0){
	            graph.getNodes().eliminar(nodeKey);
	            deleteCount ++;
	        }

	    }

}