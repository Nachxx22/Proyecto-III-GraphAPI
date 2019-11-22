package cr.ac.tec.graph.api.resources;

import java.util.UUID;   

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import cr.ac.tec.graph.api.dto.DB;
import cr.ac.tec.graph.api.dto.Edge;
import cr.ac.tec.graph.api.dto.Graph;
import cr.ac.tec.graph.api.dto.GraphNode;
//import cr.ac.tec.graph.api.dto.Representation;0
import cr.ac.tec.graph.api.dto.Representation;
import cr.ac.tec.graph.api.dto.test;

@Path("/graphs")
public class GraphsResource {
	@GET
	@Produces("application/json")
	public Response verGrafos() {
		return Response.status(200).entity(DB.db).build();
	}
	
	
		
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response añadirGrafo(test nodos) {
    	System.out.println(nodos.toString());
    	//System.out.println(edges);//Graph p/* , GraphNode nodes, Edge edges */
			Representation h=new Representation();
			//Graph GA=h.setUp(nodos, edges);
		
		// DB.db.put(p.getKey(), p); //Linea para agregar el graph con el UUID a la db
		//Graph graph = Representation.getNames();// para probar las otras funciones del API mientras se arregla el tipo										// JSON
		//DB.db.put(graph.getKey(), graph);// para probar las otras funciones del API mientras se arregla el tipo JSON
		//return Response.status(200).entity(p).build();//Respuesta para el grafo
		// funcional desde postman
		return Response.status(200).entity("2").build();
	}

//Enlaces y funciones del API para grafos
	@GET
	@Path("{id}")
	@Produces("application/json")
	public GraphResource InfoDeGrafo(@PathParam("id") UUID graphId) {
		return new GraphResource(graphId);
	}

	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public Response EliminarInfoGrafo(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("Grafo eliminado").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// Enlaces y funciones del API para todo los Nodos
	@GET
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response getNodosinf(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			Graph p = DB.db.get(ID);
			System.out.println(p.getNodes());
			return Response.status(200).entity(p.getNodes()).build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();

	}

	@POST
	@Path("{id}/nodo")
	@Consumes("application/json")
	@Produces("application/json")
	public Response NuevoNodo(@PathParam("id") UUID ID, GraphNode n) {
	if ( DB.db.containsKey(ID)) {
			Graph p = DB.db.get(ID);
			System.out.println(n.getName());;
			p.addNode(n);
			return Response.status(200).entity(n).build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response EliminarNodos(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("Eliminación total de nodos").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}
	// Enlaces y funciones del API para nodos especificos

	@GET
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response VerNodo(@PathParam("id") UUID ID, @PathParam("id2") UUID nodoid) {
		if (DB.db.containsKey(ID)) {
			Graph e = DB.db.get(ID);
			if (e.searchNode(ID) != null) {
				return Response.status(200).entity(e.searchNode(ID).getName()).build();
			}
			return Response.status(404).entity("El id del nodo es incorrecto o no existe").build();
		}
		return Response.status(404).entity("El id del grafo es incorrecto o no existe").build();
	}

	@DELETE
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response EliminarNodo(@PathParam("id") UUID ID, @PathParam("id2") UUID nodeId) {
		if (DB.db.containsKey(ID)) {
			Graph e = DB.db.get(ID);
			if (e.searchNode(ID) != null) {
				return Response.status(200).entity(e.searchNode(nodeId))/* .deleteGraphNode(nodeId, e)) */.build();
			}
			return Response.status(404).entity("El ID del nodo es incorrecto o no existe").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@PUT
	@Path("{id}/nodo/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarNodo(@PathParam("id") UUID ID, @PathParam("id2") UUID nodeId, String Name) {
		if (DB.db.containsKey(ID)) {
			Graph e = DB.db.get(ID);
			GraphNode nod = e.searchNode(nodeId);
			if (nod != null) {
				nod.setName(Name);
				return Response.status(200).entity(nod.getName()).build();
			}
			return Response.status(404).entity("El ID del nodo es incorrecto o no existe").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// enlaces y funciones del API para edges
	@GET
	@Path("{id}/edges")
	@Produces("application/json")
	public Response veredges(@PathParam("id") UUID ID, Graph p) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("Todos los edges").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/edges")
	@Produces("application/json")
	public Response Eliminaredges(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("Eliminación  de  todos los edges").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@POST
	@Path("{id}/edges")
	@Consumes("application/json")
	@Produces("application/json")
	public Response AgregarEdge(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("Agregar edge").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// Enlaces y funciones de API para edges especificos
	@PUT
	@Path("{id}/edges/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarEdge(@PathParam("id") UUID ID, @PathParam("id2") UUID edgeId, double distance) {
		if (DB.db.containsKey(ID)) {
			Graph e = DB.db.get(ID);
			Edge edg = e.searchEdge(edgeId);
			if (edg != null) {
				edg.setDistance(distance);
				return Response.status(200).entity(edg.getDistance()).build();
			}
			return Response.status(404).entity("El ID del edge es incorrecto o no existe").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/edges/{id2}")
	@Produces("application/json")
	public Response EliminarEdge(@PathParam("id") UUID ID, @PathParam("id2") UUID edgeId) {
		if (DB.db.containsKey(ID)) {
			Graph e = DB.db.get(ID);
			if (e.searchEdge(edgeId) != null) {
				return Response.status(200).entity(e.searchEdge(edgeId)).build();
			}
			return Response.status(404).entity("El ID del edge es incorrecto o no existe").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();

	}

//Enlaces y funciones para Degree:Array de objetos ordenados por su grado promedio en el orden indicado por el parametro sort
	@GET
	@Path("{id}/degree")
	@Produces("application/json")
	public Response Degree(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("degree").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

//Enlaces y funciones para Dijkstra: ruta más corta entre nodos
	@GET
	@Path("{id}/dijkstra")
	@Produces("application/json")
	public Response dijkstra(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			return Response.status(200).entity("dijkstra").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

}