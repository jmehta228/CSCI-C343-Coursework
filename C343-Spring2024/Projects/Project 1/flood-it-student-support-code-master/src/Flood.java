// Imports for the parameters of flood

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;



public class Flood {

    // Students implement this flood function.
    public static void flood(WaterColor color,
                              LinkedList<Coord> flooded_list,
                              Tile[][] tiles,
                              Integer board_size) { // O(n)

        Set<Coord> flooded_neighbor_set = new HashSet<>(flooded_list);
        ArrayList<Coord> flooded_arrayList = new ArrayList<>(flooded_list);

        for (int i = 0; i < flooded_list.size(); i++) {
            for (Coord coord : flooded_arrayList.get(i).neighbors(board_size)) {
                if ((coord.onBoard(board_size)) && (!(flooded_neighbor_set.contains(coord))) && (tiles[coord.getY()][coord.getX()].getColor().equals(color))) {
                    flooded_neighbor_set.add(coord);
                    flooded_list.add(coord); //
                    flooded_arrayList.add(coord);
                }
            }
        }
    }

    // An alternative implementation goes here.
    public static void flood1(WaterColor color,
                             LinkedList<Coord> flooded_list,
                             Tile[][] tiles,
                             Integer board_size) { // O(n^2)
        // YOUR CODE
        int intial_flooded_list_size = flooded_list.size();
        Set<Coord> flooded_neighbor_set = new HashSet<>();

        for (int i = 0; i < flooded_list.size(); i++) {
            for (Coord coord : flooded_list.get(i).neighbors(board_size)) {
                flooded_neighbor_set.add(coord);
            }
        }
        for (Coord coord : flooded_neighbor_set) {
            if ((coord.onBoard(board_size)) && (!(flooded_list.contains(coord))) && (tiles[coord.getY()][coord.getX()].getColor().equals(color))) {
                flooded_list.add(coord);
            }
        }
        if (intial_flooded_list_size != flooded_list.size()) {
            flood(color, flooded_list, tiles, board_size);
        }
    }

}
