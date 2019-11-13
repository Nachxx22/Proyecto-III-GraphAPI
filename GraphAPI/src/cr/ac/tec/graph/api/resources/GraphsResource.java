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

import cr.ac.tec.graph.api.dto.DB;
import cr.ac.tec.graph.api.dto.Persona;

@Path("/graphs")
public class GraphsResource {	
	@GET
	@Produces("application/json")
	public Response getGraphs() {
		return Response.status(200)
				.entity(DB.db)
				.build();
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createGraph(Persona p) {
		DB.db.put(p.getId(), p);
		return Response.status(200)
				.entity(p)
				.build();
	}
	@GET
	@Path("{id}")
	@Produces("application/json")
	public Response getGraphData(@PathParam("id") UUID ID) {
		Persona p = DB.db.get(ID);
		if (p != null) {
			return Response.status(200)
					.entity(p)
					.build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}
	@DELETE
	@Path("{id}")
	@Produces("application/json")
	public Response EliminarInfoGrafo(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("Eliminado").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// Enlaces y funciones del API para todo los Nodos
	@GET
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response getNodosinf(@PathParam("id") UUID ID,Persona p) {
		if(DB.db.containsKey(ID)) {
			return Response.status(200).entity(p.getNombre()).build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
		
	}

	@POST
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response NuevoNodo(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("Nodo añadido").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}
	

	@DELETE
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response EliminarNodos(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("Eliminación total de nodos").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}
	// Enlaces y funciones del API para nodos especificos

	@GET
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response VerNodo(@PathParam("id") UUID ID,@PathParam("id2") UUID nodeId) {
		if(DB.db.containsKey(ID)) {
			return Response.status(200).entity("Informacion  de nodo").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response EliminarNodo(@PathParam("id") UUID ID,@PathParam("id2") UUID nodeId) {
		if(DB.db.containsKey(ID)) {
			return Response.status(200).entity("Eliminación  de nodo").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@PUT
	@Path("{id}/nodo/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarNodo(@PathParam("id") UUID ID,@PathParam("id2") UUID nodeId) {
		if(DB.db.containsKey(ID)) {
			return Response.status(200).entity("Actualizacion de nodo").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// enlaces y funciones del API para edges
	@GET
	@Path("{id}/edges")
	@Produces("application/json")
	public Response veredges(@PathParam("id") UUID ID, Persona p) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity(p.getEdad()).build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/edges")
	@Produces("application/json")
	public Response Eliminaredges(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
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
			DB.db.remove(ID);
			return Response.status(200).entity("Agregar edge").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	// Enlaces y funciones de API para edges especificos
	@PUT
	@Path("{id}/edges/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarEdge(@PathParam("id") UUID ID,@PathParam("id2") UUID edgeId) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("Actualizar edge").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

	@DELETE
	@Path("{id}/edges/{id2}")
	@Produces("application/json")
	public Response EliminarEdge(@PathParam("id") UUID ID,@PathParam("id2") UUID edgeId) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
			return Response.status(200).entity("eliminar  edge").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
		
	}

//Enlaces y funciones para Degree:Array de objetos ordenados por su grado promedio en el orden indicado por el parametro sort
	@GET
	@Path("{id}/degree")
	@Produces("application/json")
	public Response Degree(@PathParam("id") UUID ID) {
		if (DB.db.containsKey(ID)) {
			DB.db.remove(ID);
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
			DB.db.remove(ID);
			return Response.status(200).entity("dijkstra").build();
		}
		return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
	}

}