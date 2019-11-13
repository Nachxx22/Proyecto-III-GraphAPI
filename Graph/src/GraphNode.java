import javafx.scene.layout.GridPane;

public class GraphNode {
    private String name;
    private static Lista edges;
    private static int key;
    private static int edgeKeyCount;

    public GraphNode(String name){
        this.name = name;
        this.edges = edges;
        this.key = key;
        key++;
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


    public int getKey(){
        return key-1;
    }



    public void deleteGraphNode(int nodeKey, Graph graph){
        edges.eliminar(nodeKey);
        graph.getNodes().eliminar(nodeKey);
    }


}
