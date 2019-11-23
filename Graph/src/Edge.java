import java.util.UUID;

/**
 * Genera objetos de tipo Edge con sus respectivos atributos, los cuales son referentes a las conexiones entre nodos
 */
public class Edge {
    GraphNode origin;  //Nombre Origen
    GraphNode destination;  //Nombre destino
    double distance;   //duración
    private UUID edgeKey = UUID.randomUUID();

    /**
     * Constructor de la clase Edge, asigna los atributos de cada objeto
     * @param origin origen de la conexion, origen de la llamada
     * @param destination destino de la conexion, destinatario de la llamada
     * @param distance duracion de la llamada, extencion de la conexion
     */
    public Edge(GraphNode origin, GraphNode destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.edgeKey = edgeKey;

    }

    /**
     * imprime los edges
     */
    public void printEdges() {
        System.out.println("\n Edge [origin=" + origin.getName() + ", destination=" + destination.getName() + ", distance="
                + distance + "]");
    }

    /**
     *
     * @return llave o indice con el que se puede buscar un edge, este es generado mediante un UUID random
     */
    public UUID getEdgeKey(){
        return edgeKey;
    }

    /**
     * asigna la distancia de una determinada conexion, en este caso referente a la duracion de una llamada
     * @param distance distancia que debe tener el edge
     */
    public void setDistance(double distance) {
        // TODO Auto-generated method stub
        this.distance=distance;
    }

    /**
     * devuelve el valor de la distancia de una conexion
     * @return distancia del edge
     */
    public double getDistance(){
        return distance;
    }
}
