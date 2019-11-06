public class Representation {
    public static Graph getNames() {
        GraphNode A = new GraphNode("CLOWI");
        GraphNode B = new GraphNode("VALE");
        GraphNode C = new GraphNode("COCO");

        A.addEdge(new Edge(A, B, 100));
        A.addEdge(new Edge(A, C, 90));
        B.addEdge(new Edge(B, C, 50));


        Graph graph = new Graph();
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        return graph;
    }
}
