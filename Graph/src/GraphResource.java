import java.io.BufferedReader;
import java.io.FileReader;
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

@Path("/graphs")
public class GraphResource {
    public static Graph graph = new Graph();
    static String[] n = null;
    private UUID currentId;

    /**
     * Constructor de la clase GraphResource
     * @param graphId ID del respectivo objeto
     */
    public GraphResource(UUID graphId) {
        this.currentId = graphId;

    }

    /**
     *
     * @return base de datos para visualizar el grafo y los elementos que contiene
     */
    @GET
    @Produces("application/json")
    public Response verGrafos() {

        return Response.ok(DB.db).build();
        // status(200).entity(DB.db.toString()).build();
    }

    /**
     * Es un metodo que contiene la informacion del grafo del ID que se ingresa por parametro
     * @param graphId identificacion del grafo
     * @return datos del grafo
     */
    //Enlaces y funciones del API para grafos
    @GET
    @Path("{id}")
    @Produces("application/json")
    public GraphResource InfoDeGrafo(@PathParam("id") UUID graphId) {
        return new GraphResource(graphId);
    }

    /**
     * Elimina un grafo junto a la informacion y elementos que este posee
     * @param ID identificacion del grafo que se busca eliminar
     * @return estado que indica que el grafo ya ha sido removido
     */
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

    /**
     * Devuelve los atributos que posee el nodo que el usuario seleccione como parametro
     * @param ID identificacion del nodo
     * @return caracteristicas del nodo seleccionado
     */
    // Enlaces y funciones del API para todo los Nodos
    @GET
    @Path("{id}/nodo")
    @Produces("application/json")
    public Response getNodosinf(@PathParam("id") UUID ID) {
        if (DB.db.containsKey(ID)) {
            Graph p = DB.db.get(ID);
            return Response.status(200).entity(p.getNodes()).build();
        }
        return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();

    }

    /**
     * Agrega nodos al grafo
     * @param ID Identificacion del nuevo nodo
     * @param n Nodo por agregar
     * @return estado al agregar el nodo o al rechazar la peticion
     */
    @POST
    @Path("{id}/nodo")
    @Consumes("application/json")
    @Produces("application/json")
    public Response NuevoNodo(@PathParam("id") UUID ID, GraphNode n) {
        if (DB.db.containsKey(ID)) {
            Graph p = DB.db.get(ID);
            p.addNode(n);
            return Response.status(200).entity(n).build();
        }
        return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
    }

    /**
     * Elimina todos los nodos de un grafo
     * @param ID identificacion del nodo a eliminar
     * @return estado referente a la accion realizada
     */
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

    /**
     * Retorna un nodo al buscarse por su ID
     * @param ID identificacion del nodo que se busca
     * @return el estado al encontrar el nodo o muestra un determinado incoveniente
     */
    @GET
    @Path("{id}/nodo/{id2}")
    @Produces("application/json")
    public Response VerNodo(@PathParam("id") UUID ID) {
        if (DB.db.containsKey(ID)) {
            Graph e = DB.db.get(ID);
            if (e.searchNode(ID) != null) {
                return Response.status(200).entity(e.searchNode(ID).getName()).build();
            }
            return Response.status(404).entity("El id del nodo es incorrecto o no existe").build();
        }
        return Response.status(404).entity("El id del grafo es incorrecto o no existe").build();
    }

    /**
     * Elimina un nodo seleccionado a traves de su identificacion
     * @param ID idenficacion del grafo donde se encuentra el nodo
     * @param nodeId identificacion del nodo a eliminar
     * @return estado referente a la accion realizada
     */
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

    /**
     * Actualiza la informacion de un nodo seleccionado
     * @param ID identificacion del grafo
     * @param nodeId identificacion del nodo que se quiere actualizar
     * @param Name nuevo nombre que se le asigna al nodo al actualizarlo
     * @return estado referente al resultado de la actualizacion
     */
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

    /**
     * Muestra un edge a partir de su ID
     * @param ID identificacion del edge
     * @param p grafo donde se encuentra el edge
     * @return estado referente al resultado
     */
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

    /**
     * Elimina un edge seleccionado
     * @param ID identificacion del edge
     * @return estado de la aplicacion al eliminar el edge
     */
    @DELETE
    @Path("{id}/edges")
    @Produces("application/json")
    public Response Eliminaredges(@PathParam("id") UUID ID) {
        if (DB.db.containsKey(ID)) {
            return Response.status(200).entity("Eliminación  de  todos los edges").build();
        }
        return Response.status(404).entity("El ID del grafo es incorrecto o el grafo no existe").build();
    }

    /**
     * Incorpora edges al grafo
     * @param ID identificacion del edge
     * @return estado de la ejecucion
     */
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

    /**
     * Actualiza las conexiones en el grafo
     * @param ID identificacion del grafo donde se encuentra el edge
     * @param edgeId identificacion del edge que se quiere actualizar
     * @param distance distancia que posee el edge
     * @return estado de la actualizacion
     */
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

    /**
     * Elimina una conexion entre dos nodos
     * @param ID identificacion del grafo
     * @param edgeId identificacion del edge
     * @return estado de la aplicacion al eliminar el edge
     */
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

    /**
     * @author sergio Funcion que retorna los datos necesarios para la constroccion
     *         de los grafos con sigma
     * @return lista con los nombres de los nodeos del grafo
     */
    @GET
    @Path("/n")
    @Produces("application/json")
    public Response Nodes() {
        // gn.getEdges();

        System.out.println("lista: " + n);
        return Response.ok(n).header("Acces-Control-Allow-Origin", "*")
                .header("Acces-Controll-Allow-Methods", "GET, POST,DELETE,PUUT").allow("OPTIONS").build();
    }

    /**
     * @author sergio Funcion que retorna los datos necesarios para la constroccion
     *         de los nodos con sigma
     * @return respuesta de la aplicacion
     */
    @GET
    @Path("/e")
    @Produces("application/json")
    public Response Edges() {
        // ya pongo el codigo
        return Response.ok().header("Acces-Control-Allow-Origin", "*")
                .header("Acces-Controll-Allow-Methods", "GET, POST,DELETE,PUUT").allow("OPTIONS").build();
    }

    /**
     * @author sergio Funcion que conecta la web de carga del csv con al api, recibe
     *         el nombre del archivo csv para buscarlo en la carpeta deonde la web
     *         de carga, guarda los archivos
     * @param nombre: Nombre del archivo csv selecconado por el usuario
     * @return String de confirmacion de carga
     */
    @POST
    @Path("{name}/csv")
    public Response csv(@PathParam("name") String nombre) {
        String path = "C:\\wamp64\\www\\tutorial\\archivos\\" + nombre;
        BufferedReader br = null;
        BufferedReader Br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            line = br.readLine();
            while (null != line) {
                String[] partes = line.split(",");
                GraphNode n1 = new GraphNode(partes[0]);
                GraphNode n2 = new GraphNode(partes[1]);
                Edge ED = new Edge(n1, n2, Integer.parseInt(partes[2]));
                n1.addEdge(ED);
                graph.addNode(n1);
                graph.addNode(n2);
                line = br.readLine();
            }
            DB.db.put(graph.getKey(), graph);

            Br = new BufferedReader(new FileReader(path));
            String linea = Br.readLine();
            line = br.readLine();
            n = new String[graph.getNodes().size];
            System.out.println("size: " + graph.getNodes().size);
            int cN = 0;
            linea = Br.readLine();
            while (null != linea) {
                System.out.println("cN: " + cN);
                String[] partes = linea.split(",");
                n[cN] = partes[0];
                System.out.println("partes[0] " + partes[0]);
                cN++;
                n[cN] = partes[1];
                System.out.println("partes[1] " + partes[1]);
                cN++;
                linea = Br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(200).entity("csv").header("Acces-Control-Allow-Origin", "*")
                .header("Acces-Controll-Allow-Methods", "GET, POST,DELETE,PUUT").allow("OPTIONS").build();
    }
}
