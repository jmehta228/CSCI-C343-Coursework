import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FloodTest {

    // Students write more complicated tests based on this one:
    @Test
    public void testSimple() {
        WaterColor[][] colors = {
                { WaterColor.BLUE, WaterColor.RED},
                { WaterColor.CYAN, WaterColor.YELLOW}
        };

        Board b = new Board(2, colors);
        b.tiles[0][0].setColor(WaterColor.RED);
        b.flood(0, WaterColor.RED);

        boolean [] [] flooded_solution = {
                { true,  true},
                { false, false}
        };

        for (int y = 0; y < b.size; y++) {
            for (int x = 0; x < b.size; x++) {
                assertEquals(b.flooded.contains(new Coord(x,y)), flooded_solution[y][x]);
            }
        }
    }

    // a helper function that students can use
    private boolean check_colors(Board b, WaterColor[][] ref) {
        for (int x = 0; x < b.getSize(); ++x) {
            for (int y = 0; y < b.getSize(); ++y) {
                if (b.get(new Coord(x, y)).getColor() != ref[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    // YOUR CODE
    @Test
    void test01() {
        WaterColor[][] waterColors = {
                {WaterColor.RED, WaterColor.CYAN},
                {WaterColor.PINK, WaterColor.YELLOW}
        };

        Board b1 = new Board(2, waterColors);
        b1.tiles[0][0].setColor(WaterColor.CYAN);
        b1.flood(0, WaterColor.CYAN);

        boolean[][] floodedSolution01 = {
                {true, true},
                {false, false}
        };

        for (int y = 0; y < b1.size; y++) {
            for (int x = 0; x < b1.size; x++) {
                assertEquals(b1.flooded.contains(new Coord(x,y)), floodedSolution01[y][x]);
            }
        }

    }

    @Test
    void test02() {
        WaterColor[][] waterColors = {
                {WaterColor.BLUE, WaterColor.RED, WaterColor.RED},
                {WaterColor.YELLOW, WaterColor.RED, WaterColor.BLUE},
                {WaterColor.YELLOW, WaterColor.CYAN, WaterColor.CYAN},
        };

        Board b2 = new Board(3, waterColors);
        b2.tiles[0][0].setColor(WaterColor.YELLOW);
        b2.flood(0, WaterColor.YELLOW);

        boolean[][] floodedSolution02 = {
                {true, false, false},
                {true, false, false},
                {true, false, false}
        };

        for (int y = 0; y < b2.size; y++) {
            for (int x = 0; x < b2.size; x++) {
                assertEquals(b2.flooded.contains(new Coord(x,y)), floodedSolution02[y][x]);
            }
        }

    }

    @Test
    void test03() {
        WaterColor[][] waterColors = {
                {WaterColor.YELLOW, WaterColor.BLUE, WaterColor.BLUE, WaterColor.CYAN, WaterColor.BLUE},
                {WaterColor.BLUE, WaterColor.BLUE, WaterColor.RED, WaterColor.BLUE, WaterColor.CYAN},
                {WaterColor.PINK, WaterColor.PINK, WaterColor.PINK, WaterColor.YELLOW, WaterColor.CYAN},
                {WaterColor.CYAN, WaterColor.PINK, WaterColor.YELLOW, WaterColor.CYAN, WaterColor.RED},
                {WaterColor.YELLOW, WaterColor.CYAN, WaterColor.YELLOW, WaterColor.RED, WaterColor.CYAN},
        };

        Board b3 = new Board(5, waterColors);
        b3.tiles[0][0].setColor(WaterColor.BLUE);
        b3.flood(0, WaterColor.BLUE);

        boolean[][] floodedSolutions03 = {
                {true, true, true, false, false},
                {true, true, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
        };

        for (int y = 0; y < b3.size; y++) {
            for (int x = 0; x < b3.size; x++) {
                assertEquals(b3.flooded.contains(new Coord(x,y)), floodedSolutions03[y][x]);
            }
        }

        b3.tiles[0][0].setColor(WaterColor.PINK);
        b3.flood(0, WaterColor.PINK);

        boolean[][] floodedSolutions04 = {
                {true, true, true, false, false},
                {true, true, false, false, false},
                {true, true, true, false, false},
                {false, true, false, false, false},
                {false, false, false, false, false},
        };

        for (int y = 0; y < b3.size; y++) {
            for (int x = 0; x < b3.size; x++) {
                assertEquals(b3.flooded.contains(new Coord(x,y)), floodedSolutions04[y][x]);
            }
        }
    }

}


//    WaterColor.BLUE
//    WaterColor.RED
//    WaterColor.CYAN
//    WaterColor.PINK
//    WaterColor.YELLOW
