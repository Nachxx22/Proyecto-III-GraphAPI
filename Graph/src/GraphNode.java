import javafx.scene.layout.GridPane;

import java.util.UUID;

public class GraphNode {
    private String name;
    private static Lista edges;
    private UUID key = UUID.randomUUID();

    public GraphNode(String name){
        this.name = name;
        this.edges = edges;
        this.key = key;
    }

    public String getName(){
        return name;
    }

    public String print(){
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


    public UUID getKey(){
        return key;
    }



    public void deleteGraphNode(Graph graph){
        int nodeKey = graph.getNodes().getIndex(this) ;
        System.out.println(nodeKey);
        for(int i = 0; i< edges.size; i++) {
            Edge temp = ((Edge) edges.ver(i));
            GraphNode delete = this;
            if (temp.destination.equals(delete)) {
                edges.eliminar(i);
                deleteGraphNode(graph);
            }
        }

        Lista.printEdgeList(edges);
        graph.getNodes().eliminar(nodeKey);
    }


}
