import java.util.UUID;

public class Graph {
    private static Lista nodes;
    private UUID key=UUID.randomUUID();

    /**
     * Agregar nodos al grafo
     * @param node nodo por agregar
     */
    public void addNode(GraphNode node) {
        if (nodes == null) {
            nodes = new Lista();
        }
        nodes.addLast(node);
    }

    /**
     * imprime la lista de nodos que tiene el grafo actualmente
     */
    public void printGraph() {
        System.out.printf(" \n Graph [nodes= ");
        Lista.printNodeList(nodes);
        System.out.println(" ]");
    }

    /**
     *
     * @return lista de nodos del grafo
     */
    public Lista getNodes(){
        return nodes;
    }

    /**
     * busca un edge mediante su respectiva llave o indice
     * @param searchEdgeKey llave del edge que se busca
     * @return el objeto edge con la llave pasada por parametro
     */
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

    /**
     * Busca nodos en el grafo mediante una llave generada mediante UUID random
     * @param searchNodeKey llave que posee el nodo que se busca
     * @return el nodo con la llave ingresada
     */
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

    /**
     * verifica que un nodo exista dentro de un grafo a travez del nombre del mismo
     * @param name nombre del nodo
     * @return el nodo que posee el nombre respectivo
     */
    public GraphNode nodeExist(String name){
        Lista nodes = getNodes();
        for(int i = 0; i< nodes.size; i++){
            if (((GraphNode) nodes.ver(i)).getName().equals(name)) {
                System.out.println("se encontro");
                System.out.println(((GraphNode) nodes.ver(i)).getName());
                return (GraphNode) nodes.ver(i);
            }
        }
        return null;
    }

    /**
     * retorna la identificacion del grafo
     * @return llave del grafo
     */
    public UUID getKey() {

        // TODO Auto-generated method stub

        return key;

    }


}




