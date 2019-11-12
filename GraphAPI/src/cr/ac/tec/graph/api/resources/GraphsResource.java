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
	public Response verGrafos() {
		return Response.status(200).entity(DB.db).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response añadirGrafo(Persona p) {
		DB.db.put(p.getId(), p);
		return Response.status(200).entity(p).build();
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
			return Response.status(200).entity("Eliminado").build();
		}
		return Response.status(404).entity("NO ESTA").build();
	}

	// Enlaces y funciones del API para todo los Nodos
	@GET
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response getNodosinf() {
		return Response.status(200).entity("informacion de nodos").build();
	}

	@POST
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response NuevoNodo() {
		return Response.status(200).entity("Nodo añadido").build();
	}

	@DELETE
	@Path("{id}/nodo")
	@Produces("application/json")
	public Response EliminarNodos() {
		return Response.status(200).entity("Eliminación total de nodos").build();
	}
	// Enlaces y funciones del API para nodos especificos

	@GET
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response VerNodo() {
		return Response.status(200).entity("Datos de nodo").build();
	}

	@DELETE
	@Path("{id}/nodo/{id2}")
	@Produces("application/json")
	public Response EliminarNodo() {
		return Response.status(200).entity("Eliminación  de nodo").build();
	}

	@PUT
	@Path("{id}/nodo/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarNodo() {
		return Response.status(200).entity("Actualizacion de nodo").build();
	}

	// enlaces y funciones del API para edges
	@GET
	@Path("{id}/edges")
	@Produces("application/json")
	public Response veredges() {
		return Response.status(200).entity("ver todos los edges").build();
	}

	@DELETE
	@Path("{id}/edges")
	@Produces("application/json")
	public Response Eliminaredges() {
		return Response.status(200).entity("Eliminación  de  todos los edges").build();
	}

	@POST
	@Path("{id}/edges")
	@Consumes("application/json")
	@Produces("application/json")
	public Response AgregarEdge() {
		return Response.status(200).entity("Agregar edge").build();
	}

	// Enlaces y funciones de API para edges especificos
	@PUT
	@Path("{id}/edges/{id2}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response ActualizarEdge() {
		return Response.status(200).entity("Actualizar edge").build();
	}

	@DELETE
	@Path("{id}/edges/{id2}")
	@Produces("application/json")
	public Response EliminarEdge() {
		return Response.status(200).entity("eliminar  edge").build();
	}

//Enlaces y funciones para Degree:Array de objetos ordenados por su grado promedio en el orden indicado por el parametro sort
	@GET
	@Path("{id}/degree")
	@Produces("application/json")
	public Response Degree() {
		return Response.status(200).entity("degree").build();
	}

//Enlaces y funciones para Dijkstra: ruta más corta entre nodos
	@GET
	@Path("{id}/dijkstra")
	@Produces("application/json")
	public Response dijkstra() {
		return Response.status(200).entity("dijkstra").build();
	}

}