import java.util.UUID;

public class GraphNode {
    private String name;
    private static Lista edges;
    private UUID key = UUID.randomUUID();
    private int deleteCount;

    /**
     * constructor de la clase GraphNode, asigna las caracteristicas propias de cada nodo
     * @param name nombre asignado al nodo creado
     */
    public GraphNode(String name){
        this.name = name;
        this.edges = edges;
        this.key = key;
    }

    /**
     *
     * @return nombre del nodo
     */
    public String getName(){
        return name;
    }

    public String print(){
        return "\n \tNode [city=" + name + ", edges=" + edges + "]";
    }

    /**
     * Agrega edges o conexiones al grafo y los guarda en una lista enlazada
     * @param edge edge por agregar
     */
    public void addEdge(Edge edge) {
        edge.printEdges();
        if (edges == null) {
            edges = new Lista();
        }
        edges.addLast(edge);

    }

    /**
     *
     * @return retorna la lista de edges
     */
    public Lista getEdges() {
        return edges;

    }

    /**
     * @return llave del nodo la cual es generada de forma aleatoria mediante la variable de tipo UUID
     */
    public UUID getKey(){
        return key;
    }


    /**
     * Borra nodos de un grafo, junto con las conexiones relacionadas al mismo, ya sea si el nodo eliminado funciona como origen o
     * como destino. Se eliminan todos los edges que requieran de la existencia del nodo eliminado.
     * @param graph el grafo al que pertenece dicho nodo
     */
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
