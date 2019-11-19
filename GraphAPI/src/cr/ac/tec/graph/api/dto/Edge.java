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

	public double getDistance() {
		return distance;
	}

	public GraphNode setOrigin(GraphNode gn) {
		this.origin = gn;
		return origin;
	}

	public GraphNode setDestination(GraphNode gn) {
		this.destination = gn;
		return destination;
	}

	public double setDistance(double d) {
		this.distance = d;
		return distance;

	}
}