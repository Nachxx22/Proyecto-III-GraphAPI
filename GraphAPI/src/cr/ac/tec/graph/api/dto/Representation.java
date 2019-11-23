package cr.ac.tec.graph.api.dto;

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
		Lista.printEdgeList(A.getEdges());
		return graph;
	}

	public Graph setUp(JSONArray nodos, JSONArray edges) {
		System.out.println(nodos);
		System.out.println(edges);
		Graph A = new Graph();
		for (int j = 0; j < nodos.length(); j++) {
			JSONObject gNode = nodos.getJSONObject(j);
			String name = gNode.getString("name");
			GraphNode nuevoNodo = new GraphNode(name);
			A.addNode(nuevoNodo);

			for (int i = 0; i < edges.length(); i++) {

				JSONObject gEdge = nodos.getJSONObject(i); // lee cada objeto dentro de la lista de edges

				double time = gEdge.getInt("time");
				String origin = gEdge.getString("origin");
				String destination = gEdge.getString("destination");

				if (A.nodeExist(origin) == null || A.nodeExist(destination) == null) {
					System.out.println("el nodo no existe");

				} else if (origin.equals(nuevoNodo.getName())) {
					Edge a = new Edge(A.nodeExist(origin), A.nodeExist(destination), time);
					nuevoNodo.addEdge(a);
				}

			}
		}
		System.out.println(A);
		return A;

	}

}