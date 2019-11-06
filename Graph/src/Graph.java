import java.sql.SQLOutput;

public class Graph {
    private Lista nodes;

    public void addNode(GraphNode node) {
        if (nodes == null) {
            nodes = new Lista();
        }
        nodes.addLast(node);
    }

    public void print() {
        System.out.printf(" \n Graph [nodes= ");
        Lista.printNodeList(nodes);
        System.out.println(" ]");
    }
}
