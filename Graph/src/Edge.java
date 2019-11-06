public class Edge {
    GraphNode origin;  //Nombre Origen
    GraphNode destination;  //Nombre destino
    double distance;   //duración

    public Edge(GraphNode origin, GraphNode destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public void printEdges() {
        System.out.println("\n Edge [origin=" + origin.getName() + ", destination=" + destination.getName() + ", distance="
                + distance + "]");
    }
}
