import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class StudentTest {

    @Test
    public void test() {
        // your tests go here
        small_connected_components_test_1();
        medium_connected_components_test1();
        large_connected_components_test1();
        empty_connected_components_test1();
        one_element_connected_components_test1();
        small_disconnected_components_test1();
        medium_disconnected_components_test1();
        large_disconnected_components_test1();
        disconnected_vertices_in_component_test();
        random_test1();
        random_test2();
    }

    @Test
    public void small_connected_components_test_1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0}");
    }

    @Test
    public void medium_connected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(51);
        for (int i = 0; i < 48; i++) {
            graph.addEdge(i, i + 1);
        }
        graph.addEdge(49, 50);
        graph.addEdge(50, 0);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0, 4=0, 5=0, 6=0, 7=0, 8=0, 9=0, 10=0, 11=0, 12=0, 13=0, 14=0, 15=0, 16=0, 17=0, 18=0, 19=0, 20=0, 21=0, 22=0, 23=0, 24=0, 25=0, 26=0, 27=0, 28=0, 29=0, 30=0, 31=0, 32=0, 33=0, 34=0, 35=0, 36=0, 37=0, 38=0, 39=0, 40=0, 41=0, 42=0, 43=0, 44=0, 45=0, 46=0, 47=0, 48=0, 49=0, 50=0}");
    }

    @Test
    public void large_connected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(101);
        for (int i = 0; i < 98; i++) {
            graph.addEdge(i, i + 1);
        }
        graph.addEdge(99, 100);
        graph.addEdge(100, 0);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0, 4=0, 5=0, 6=0, 7=0, 8=0, 9=0, 10=0, 11=0, 12=0, 13=0, 14=0, 15=0, 16=0, 17=0, 18=0, 19=0, 20=0, 21=0, 22=0, 23=0, 24=0, 25=0, 26=0, 27=0, 28=0, 29=0, 30=0, 31=0, 32=0, 33=0, 34=0, 35=0, 36=0, 37=0, 38=0, 39=0, 40=0, 41=0, 42=0, 43=0, 44=0, 45=0, 46=0, 47=0, 48=0, 49=0, 50=0, 51=0, 52=0, 53=0, 54=0, 55=0, 56=0, 57=0, 58=0, 59=0, 60=0, 61=0, 62=0, 63=0, 64=0, 65=0, 66=0, 67=0, 68=0, 69=0, 70=0, 71=0, 72=0, 73=0, 74=0, 75=0, 76=0, 77=0, 78=0, 79=0, 80=0, 81=0, 82=0, 83=0, 84=0, 85=0, 86=0, 87=0, 88=0, 89=0, 90=0, 91=0, 92=0, 93=0, 94=0, 95=0, 96=0, 97=0, 98=0, 99=0, 100=0}");
    }

    @Test
    public void empty_connected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(0);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{}");
    }

    @Test
    public void one_element_connected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(1);
        graph.addEdge(0, 0);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0}");
    }

    @Test
    public void small_disconnected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(6);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=2, 3=2, 4=4, 5=4}");
    }

    @Test
    public void medium_disconnected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(50);
        for (int i = 0; i < 25; i++) {
            graph.addEdge(i, i + 1);
        }
        for (int i = 26; i < 49; i++) {
            graph.addEdge(i, i + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0, 4=0, 5=0, 6=0, 7=0, 8=0, 9=0, 10=0, 11=0, 12=0, 13=0, 14=0, 15=0, 16=0, 17=0, 18=0, 19=0, 20=0, 21=0, 22=0, 23=0, 24=0, 25=0, 26=26, 27=26, 28=26, 29=26, 30=26, 31=26, 32=26, 33=26, 34=26, 35=26, 36=26, 37=26, 38=26, 39=26, 40=26, 41=26, 42=26, 43=26, 44=26, 45=26, 46=26, 47=26, 48=26, 49=26}");
    }

    @Test
    public void large_disconnected_components_test1() {
        Graph<Integer> graph = new UndirectedAdjacencyList(100);
        for (int i = 0; i < 49; i++) {
            graph.addEdge(i, i + 1);
        }
        for (int i = 50; i < 99; i++) {
            graph.addEdge(i, i + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0, 4=0, 5=0, 6=0, 7=0, 8=0, 9=0, 10=0, 11=0, 12=0, 13=0, 14=0, 15=0, 16=0, 17=0, 18=0, 19=0, 20=0, 21=0, 22=0, 23=0, 24=0, 25=0, 26=0, 27=0, 28=0, 29=0, 30=0, 31=0, 32=0, 33=0, 34=0, 35=0, 36=0, 37=0, 38=0, 39=0, 40=0, 41=0, 42=0, 43=0, 44=0, 45=0, 46=0, 47=0, 48=0, 49=0, 50=50, 51=50, 52=50, 53=50, 54=50, 55=50, 56=50, 57=50, 58=50, 59=50, 60=50, 61=50, 62=50, 63=50, 64=50, 65=50, 66=50, 67=50, 68=50, 69=50, 70=50, 71=50, 72=50, 73=50, 74=50, 75=50, 76=50, 77=50, 78=50, 79=50, 80=50, 81=50, 82=50, 83=50, 84=50, 85=50, 86=50, 87=50, 88=50, 89=50, 90=50, 91=50, 92=50, 93=50, 94=50, 95=50, 96=50, 97=50, 98=50, 99=50}");
    }

    @Test
    public void disconnected_vertices_in_component_test() {
        Graph<Integer> graph = new UndirectedAdjacencyList(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=3, 4=3, 5=5}");
    }

    @Test
    public void random_test1() {
        final int numVertices = 100;
        Graph<Integer> graph = new UndirectedAdjacencyList(numVertices);
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            int numEdges = random.nextInt(10);
            for (int j = 0; j < numEdges; j++) {
                int randomVertex = random.nextInt(numVertices);
                if (randomVertex != i) {
                    graph.addEdge(i, randomVertex);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        ConnectedComponents.connected_components(graph, map);
        assertEquals(map.toString(), "{0=0, 1=0, 2=0, 3=0, 4=0, 5=0, 6=0, 7=0, 8=0, 9=0, 10=0, 11=0, 12=0, 13=0, 14=0, 15=0, 16=0, 17=0, 18=0, 19=0, 20=0, 21=0, 22=0, 23=0, 24=0, 25=0, 26=0, 27=0, 28=0, 29=0, 30=0, 31=0, 32=0, 33=0, 34=0, 35=0, 36=0, 37=0, 38=0, 39=0, 40=0, 41=0, 42=0, 43=0, 44=0, 45=0, 46=0, 47=0, 48=0, 49=0, 50=0, 51=0, 52=0, 53=0, 54=0, 55=0, 56=0, 57=0, 58=0, 59=0, 60=0, 61=0, 62=0, 63=0, 64=0, 65=0, 66=0, 67=0, 68=0, 69=0, 70=0, 71=0, 72=0, 73=0, 74=0, 75=0, 76=0, 77=0, 78=0, 79=0, 80=0, 81=0, 82=0, 83=0, 84=0, 85=0, 86=0, 87=0, 88=0, 89=0, 90=0, 91=0, 92=0, 93=0, 94=0, 95=0, 96=0, 97=0, 98=0, 99=0}");
    }

    @Test
    public void random_test2() {
        Random random = new Random();
        for (int i = 1; i <= 500; i++) {
            int vertices = random.nextInt(500) + 1;
            Graph<Integer> graph = new UndirectedAdjacencyList(vertices);
            int max = vertices * vertices;
            int num = random.nextInt(max) + 1;
            for (int m = 0; m < num; m++) {
                int v1 = random.nextInt(vertices);
                int v2 = random.nextInt(vertices);
                graph.addEdge(v1, v2);
            }
            Map<Integer, Integer> map = new HashMap<>();
            ConnectedComponents.connected_components(graph, map);
            for (int k = 0; k < vertices; k++) {
                for (int j = k + 1; j < vertices; j++) {
                    if (graph.adjacent(k).iterator().hasNext()) {
                        Integer firstAdjacent = graph.adjacent(k).iterator().next();
                        if (firstAdjacent.equals(j)) {
                            assertEquals(map.get(k), map.get(j));
                        }
                    }
                }
            }
        }
    }
}