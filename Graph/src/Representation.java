public class Representation {
    public static Graph getNames() {
        GraphNode A = new GraphNode("CLOWI");
        GraphNode B = new GraphNode("VALE");
        GraphNode C = new GraphNode("COCO");

        Edge a = new Edge(A, B, 100);
        A.addEdge(a);
        A.addEdge(new Edge(A, C, 90));
        B.addEdge(new Edge(B, C, 50));

        A.getEdges();

        Graph graph = new Graph();
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);

        A.deleteGraphNode(graph);
        Lista.printEdgeList(A.getEdges());
        return graph;
    }

}
