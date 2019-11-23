
import java.util.HashMap;

import java.util.Map;

import java.util.UUID;
public class DB {
    public static Map<UUID,Graph> db = new HashMap<UUID,Graph>();

    public static Map<GraphNode,Edge>db_content= new HashMap<GraphNode,Edge>();
}
