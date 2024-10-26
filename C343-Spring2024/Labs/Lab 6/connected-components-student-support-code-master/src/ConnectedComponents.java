import java.util.Map;

import java.util.*;

public class ConnectedComponents {

    /*
     * TODO
     */
    public static <V> void connected_components(Graph<V> G, Map<V, V> representative) {
        Set<V> visited = new HashSet<>();
        for (V vertex : G.vertices()) {
            if (!visited.contains(vertex)) {
                dfsTraversal(G, vertex, vertex, visited, representative);
            }
        }
    }

    private static <V> void dfsTraversal(Graph<V> graph, V vertex1, V vertex2, Set<V> visitedSet, Map<V, V> representativeMap) {
        visitedSet.add(vertex1);
        representativeMap.put(vertex1, vertex2);
        for (V neighbor : graph.adjacent(vertex1)) {
            if (!visitedSet.contains(neighbor)) {
                dfsTraversal(graph, neighbor, vertex2, visitedSet, representativeMap);
            }
        }
    }
}
