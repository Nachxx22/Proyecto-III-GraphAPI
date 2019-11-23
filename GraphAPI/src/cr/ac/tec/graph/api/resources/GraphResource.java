package cr.ac.tec.graph.api.resources;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import cr.ac.tec.graph.api.dto.DB;
import cr.ac.tec.graph.api.dto.Graph;

public class GraphResource {
	private UUID currentId;

	public GraphResource(UUID graphId) {
		this.currentId = graphId;
	}

	@GET
	@Produces("application/json")
	public Response getGraphData() {
		Graph p = DB.db.get(currentId);
		if (p != null) {
			return Response.status(200).entity(p).build();
		}
		return Response.status(404).entity("NO ESTA").build();
	}
}