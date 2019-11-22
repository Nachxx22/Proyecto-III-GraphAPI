package cr.ac.tec.graph.api.dto;
import java.util.UUID;

public class Graph {
    private static Lista nodes;
    private UUID key=UUID.randomUUID();

    public void addNode(GraphNode node) {
        if (nodes == null) {
            nodes = new Lista();
        }
        nodes.addLast(node);
    }
    public void printGraph() {
        System.out.printf(" \n Graph [nodes= ");
        Lista.printNodeList(nodes);
        System.out.println(" ]");
    }

    public Lista getNodes(){
        return nodes;
    }

    public Edge searchEdge(UUID searchEdgeKey){
        Lista nodes = getNodes();
        for(int i = 0; i< nodes.size; i++){
            Lista edges = ((GraphNode)nodes.ver(i)).getEdges();
            for(int j = 0; j< edges.size; j++) {
                if (((Edge) edges.ver(j)).getEdgeKey().equals(searchEdgeKey)) {
                    System.out.println("se encontro");
                    ((Edge) edges.ver(j)).printEdges();
                    return (Edge) edges.ver(j);
                }
            }
            } return null;
        }

        public GraphNode searchNode(UUID searchNodeKey){
            Lista nodes = getNodes();
            for(int i = 0; i< nodes.size; i++){
                if (((GraphNode) nodes.ver(i)).getKey().equals(searchNodeKey)) {
                    System.out.println("se encontro");
                    System.out.println(((GraphNode) nodes.ver(i)).getName());
                    return (GraphNode) nodes.ver(i);
                }
            } return null;
        }

    public GraphNode nodeExist(String name){
        Lista nodes = getNodes();
        for(int i = 0; i< nodes.size; i++){
            if (((GraphNode) nodes.ver(i)).getName().equals(name)) {
                System.out.println("se encontro");
                System.out.println(((GraphNode) nodes.ver(i)).getName());
                return (GraphNode) nodes.ver(i);
            }
        } return null;
    }
	public UUID getKey() {
		
		// TODO Auto-generated method stub
		return key;
	}


}
