import org.json.JSONArray;
import org.json.JSONObject;


public class Representation {
    public static Graph getNames() {
        GraphNode A = new GraphNode("CLOWI");
        GraphNode B = new GraphNode("VALE");
        GraphNode C = new GraphNode("COCO");

        Edge a = new Edge(A, B, 100);
        A.addEdge(a);
        A.addEdge(new Edge(A, C, 90));
        B.addEdge(new Edge(B, C, 50));

        Graph graph = new Graph();
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);

        A.deleteGraphNode(graph);
        Lista.printEdgeList(A.getEdges());
        return graph;
    }

    /**
     * Genera todos los nodos y los edges de un grafo a partir de dos listas enviadas desde JSON
     * @param nodos lista de nodos a crear en el grafo
     * @param edges lista de edges por agregar en el grafo
     * @return
     */
    public Graph setUp(JSONArray nodos, JSONArray edges){
        Graph A = new Graph();
        for (int j = 0; j < nodos.length(); j++){
            JSONObject gNode = nodos.getJSONObject(j);
            String name = gNode.getString("name");
            GraphNode nuevoNodo = new GraphNode(name);
            A.addNode(nuevoNodo);


        for (int i = 0; i < edges.length(); i++) {

            JSONObject gEdge = nodos.getJSONObject(i);  //lee cada objeto dentro de la lista de edges

            double time = gEdge.getInt("time");
            String origin = gEdge.getString("origin");
            String destination = gEdge.getString("destination");

            if (A.nodeExist(origin) == null || A.nodeExist(destination) == null) {
                System.out.println("el nodo no existe");

            } else if(origin.equals(nuevoNodo.getName())) {
                Edge a = new Edge(A.nodeExist(origin), A.nodeExist(destination), time);
                nuevoNodo.addEdge(a);
            }

            }
        }A.printGraph();
        return A;


        }


    }



