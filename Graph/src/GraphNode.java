import javafx.scene.layout.GridPane;

public class GraphNode {
    private String name;
    private Lista edges;

    public GraphNode(String name){
        this.name = name;
        this.edges = edges;
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

}
