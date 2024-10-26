import java.util.*;
public class Routing {

    /**
     * TODO
     * <p>
     * The findPaths function takes a board and a list of goals that contain
     * endpoints that need to be connected. The function returns a list of
     * Paths that connect the points.
     */
    public static ArrayList<Wire> findPaths(Board board, ArrayList<Endpoints> goals) {
//        ArrayList<Wire> wires = new ArrayList<>();
//        for (Endpoints ep : goals) {
//            wires.add(returnWire(board, ep));
//        }
//        return wires;
        return backtracking(board, goals);
    }

    public static boolean bfs(Board board, Endpoints endpoints, Map<Coord, Coord> map) {
        Coord start = endpoints.start;
        Coord end = endpoints.end;

        Queue<Coord> coordQueue = new LinkedList<>();
        coordQueue.add(start);

        HashMap<Coord, Boolean> visited = new HashMap<>();
        visited.put(start, true);

        while (!coordQueue.isEmpty()) {
            Coord top = coordQueue.poll();
            visited.put(top, true);
            if (top.equals(end)) {
                return true;
            }
            List<Coord> neighbors = board.adj(top);
            for (Coord n : neighbors) {
                if (!visited.containsKey(n)) {
                    if (board.getValue(n) == 0 || n.equals(end)) {
                        coordQueue.add(n);
                        map.put(n, top);
                    }
                }
            }
        }
        return false;
    }

    public static Wire returnWire(Board board, Endpoints endpoints) {
        Map<Coord, Coord> coordHashMap = new HashMap<>();
        boolean found = bfs(board, endpoints, coordHashMap);
        if (found) {
            List<Coord> coordList = new ArrayList<>();
            coordList.add(endpoints.end);
            Coord curr = coordHashMap.get(endpoints.end);
            while (curr != null) {
                coordList.add(curr);
                curr = coordHashMap.get(curr);
            }
            Collections.reverse(coordList);
            Wire wire = new Wire(endpoints.id, coordList);
            board.placeWire(wire);
            return wire;
        }
        else {
            return null;
        }
    }

    public static ArrayList<Wire> backtracking(Board board, ArrayList<Endpoints> goals) {
        if (goals.isEmpty()) {
            return new ArrayList<>();
        }
        for (Endpoints ep : goals) {
            Wire wire = returnWire(board, ep);
            if (wire != null) {
                ArrayList<Endpoints> newGoals = new ArrayList<>(goals);
                newGoals.remove(ep);
                ArrayList<Wire> result = backtracking(board, newGoals);
                if (result == null) {
                    board.removeWire(wire);
                }
                else {
                    result.add(wire);
                    return result;
                }
            }
        }
        return null;
    }
}