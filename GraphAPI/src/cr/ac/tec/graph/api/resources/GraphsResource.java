package cr.ac.tec.graph.api.resources;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		return Response.status(200).entity(DB.db).build();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createGraph(Persona p) {
		DB.db.put(p.getId(), p);
		return Response.status(200).entity(p).build();
	}

//Enlaces y funciones del API para grafos
	@Path("{id}")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public GraphResource handleSigleGraph(@PathParam("id") UUID graphId) {
		return new GraphResource(graphId);
	}

	@DELETE
	@Consumes("application/json")
	@Produces("application/json")
	public GraphResource REMOVEGraph(@PathParam("id") UUID graphId) {
		return new GraphResource(graphId);
	}
}
/*
 * // Enlaces y funciones del API para todo los Nodos
 * 
 * @Path("/nodo")
 * 
 * @GET
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response getNodoinf(Persona p) { return
 * Response.status(200).entity(DB.db).build(); }
 * 
 * @POST
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response NuevoNodo() { return
 * Response.status(200).entity("Actualizacion de nodo").build(); }
 * 
 * @DELETE
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response EliminarNodos() { return
 * Response.status(200).entity("Eliminación total de nodos").build(); }
 * 
 * // Enlaces y funciones del API para nodos especificos
 * 
 * @Path("{id}")
 * 
 * @GET
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response VerNodo() { return
 * Response.status(200).entity("Datos de nodo").build(); }
 * 
 * @DELETE
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response EliminarNodo() { return
 * Response.status(200).entity("Eliminación  de nodo").build(); }
 * 
 * @PUT
 * 
 * @DELETE
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response ActualizarNodo() { return
 * Response.status(200).entity("Actualizacion de nodo").build(); }
 * 
 * // enlaces y funciones del API para edges
 * 
 * @Path("edges")
 * 
 * @GET
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response veredges() { return
 * Response.status(200).entity("ver todos los edges").build(); }
 * 
 * @DELETE
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response Eliminaredges() { return
 * Response.status(200).entity("Eliminación  de edges").build(); }
 * 
 * @POST
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response AgregarEdge() { return
 * Response.status(200).entity("Agregar edge").build(); }
 * 
 * // Enlaces y funciones de API para edges especificos
 * 
 * @Path("{id}")
 * 
 * @PUT
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response ActualizarEdge() { return
 * Response.status(200).entity("Actualizar edge").build(); }
 * 
 * @DELETE
 * 
 * @Consumes("application/json")
 * 
 * @Produces("application/json") public Response EliminarEdge() { return
 * Response.status(200).entity("eliminar  edge").build(); } }
 */