package cr.ac.tec.graph.api.dto;

import java.util.UUID;

public class Edge {
	GraphNode origin; // Nombre Origen
	GraphNode destination; // Nombre destino
	double distance; // duración
	private UUID edgeKey = UUID.randomUUID();

	public Edge(GraphNode origin, GraphNode destination, double distance) {
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
		this.edgeKey = edgeKey;

	}

	public void printEdges() {
		System.out.println("\n Edge [origin=" + origin.getName() + ", destination=" + destination.getName()
				+ ", distance=" + distance + "]");
	}

	public UUID getEdgeKey() {
		return edgeKey;
	}

	Object setdistance(double e) {
		this.distance = e;
		return distance;
	}

	Object setorigin(GraphNode e) {
		this.origin = e;
		return distance;
	}

	Object setdestination(GraphNode e) {
		this.destination = e;
		return distance;
	}
}