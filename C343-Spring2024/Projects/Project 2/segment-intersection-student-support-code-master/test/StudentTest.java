import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class StudentTest {

    @Test
    public void insertSmallBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[]{4, 8, 0, 2, 6, 10};
        /*
         *       4
         *     /  \
         *    /    \
         *   0      8
         *    \    / \
         *     2  6   10
         */


        for (Integer key : a) { // TODO given test
            bst.insert(key);
            map.put(key, key);
        }

        for (int i = 0; i != 11; ++i) { // TODO given test
            assertEquals(bst.contains(i), map.containsKey(i));
        }
    }

    @Test
    public void bst_insert_test() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = new int[]{4, 8, 0, 2, 6, 10};

        bst.insert(4);
        bst.insert(8);
        bst.insert(0);
        bst.insert(2);
        bst.insert(6);
        bst.insert(10);

        map.put(4, 4);
        map.put(8, 8);
        map.put(0, 0);
        map.put(2, 2);
        map.put(6, 6);
        map.put(10, 10);

        for (int i = 0; i != a.length; ++i) { // TODO given test
            assertTrue(bst.contains(a[i]));
            assertTrue(map.containsKey(a[i]));
            assertEquals(bst.contains(a[i]), map.containsKey(a[i]));
        }
        assertEquals(bst.keys().toString(), "[0, 2, 4, 6, 8, 10]");
    }

    @Test
    public void bst_remove_test() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] a = {4, 8, 0, 2, 6, 10};

        bst.insert(4);
        bst.insert(8);
        bst.insert(0);
        bst.insert(2);
        bst.insert(6);
        bst.insert(10);

        map.put(4, 4);
        map.put(8, 8);
        map.put(0, 0);
        map.put(2, 2);
        map.put(6, 6);
        map.put(10, 10);

        for (int i = 0; i != a.length; ++i) { // TODO given test
            assertTrue(bst.contains(a[i]));
            assertTrue(map.containsKey(a[i]));
            assertEquals(bst.contains(a[i]), map.containsKey(a[i]));
        }
        assertEquals(bst.keys().toString(), "[0, 2, 4, 6, 8, 10]");
        assertEquals(bst.size(), 6);


        bst.remove(4);
        map.remove(4, 4);
        assertFalse(bst.contains(4));
        assertFalse(map.containsKey(4));
        assertFalse(map.containsValue(4));
        assertEquals(bst.size(), 5);
        assertEquals(bst.keys().toString(), "[0, 2, 6, 8, 10]");

        bst.remove(0);
        map.remove(0, 0);
        assertFalse(bst.contains(0));
        assertFalse(map.containsKey(0));
        assertFalse(map.containsValue(0));
        assertEquals(bst.size(), 4);
        assertEquals(bst.keys().toString(), "[2, 6, 8, 10]");

        bst.remove(10);
        map.remove(10, 10);
        assertFalse(bst.contains(10));
        assertFalse(map.containsKey(10));
        assertFalse(map.containsValue(10));
        assertEquals(bst.size(), 3);
        assertEquals(bst.keys().toString(), "[2, 6, 8]");

        bst.remove(2);
        map.remove(2, 2);
        assertFalse(bst.contains(2));
        assertFalse(map.containsKey(2));
        assertFalse(map.containsValue(2));
        assertEquals(bst.size(), 2);
        assertEquals(bst.keys().toString(), "[6, 8]");

        bst.remove(6);
        map.remove(6, 6);
        assertFalse(bst.contains(6));
        assertFalse(map.containsKey(6));
        assertFalse(map.containsValue(6));
        assertEquals(bst.size(), 1);
        assertEquals(bst.keys().toString(), "[8]");

        bst.remove(8);
        map.remove(8, 8);
        assertFalse(bst.contains(8));
        assertFalse(map.containsKey(8));
        assertFalse(map.containsValue(8));
        assertEquals(bst.size(), 0);
        assertEquals(bst.keys().toString(), "[]");

        /*
         *       4
         *     /  \
         *    /    \
         *   0      8
         *    \    / \
         *     2  6   10
         */

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        bst2.insert(4);
        bst2.insert(8);
        bst2.insert(0);
        bst2.insert(2);
        bst2.insert(6);
        bst2.insert(10);

        map2.put(4, 4);
        map2.put(8, 8);
        map2.put(0, 0);
        map2.put(2, 2);
        map2.put(6, 6);
        map2.put(10, 10);

        bst2.remove(6);
        assertFalse(bst2.contains(6));
        assertEquals(bst2.keys().toString(), "[0, 2, 4, 8, 10]");
        assertEquals(bst2.size(), 5);

        bst2.remove(8);
        assertFalse(bst2.contains(8));
        assertEquals(bst2.keys().toString(), "[0, 2, 4, 10]");
        assertEquals(bst2.size(), 4);

        map2.remove(6, 6);
        map2.remove(8, 8);
        assertFalse(map2.containsKey(6) && map2.containsValue(6));
        assertFalse(map2.containsKey(8) && map2.containsValue(8));
        assertEquals(map2.size(), 4);
    }

    @Test
    public void bst_remove_test2() {
        //MORE REMOVE TESTING:
        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map3 = new TreeMap<>();
        int[] bst3Elements = {40, 30, 50, 25, 35, 45, 60};
        for (int element : bst3Elements) {
            bst3.insert(element);
            map3.put(element, element);
        }
        assertEquals(bst3.height(), 2);
        assertEquals(bst3.keys().toString(), "[25, 30, 35, 40, 45, 50, 60]");

        bst3.remove(30);
        assertFalse(bst3.contains(30));
        assertEquals(bst3.size(), 6);
        assertEquals(bst3.keys().toString(), "[25, 35, 40, 45, 50, 60]");
        map3.remove(30, 30);
        assertFalse(map3.containsKey(30) && map3.containsValue(30));
        assertEquals(map3.size(), 6);
        assertEquals(map3.toString(), "{25=25, 35=35, 40=40, 45=45, 50=50, 60=60}");

        bst3.remove(50);
        assertFalse(bst3.contains(50));
        assertEquals(bst3.size(), 5);
        assertEquals(bst3.keys().toString(), "[25, 35, 40, 45, 60]");
        map3.remove(50, 50);
        assertFalse(map3.containsKey(50) && map3.containsValue(50));
        assertEquals(map3.size(), 5);
        assertEquals(map3.toString(), "{25=25, 35=35, 40=40, 45=45, 60=60}");

        bst3.remove(40);
        assertFalse(bst3.contains(40));
        assertEquals(bst3.size(), 4);
        assertEquals(bst3.keys().toString(), "[25, 35, 45, 60]");
        map3.remove(40, 40);
        assertFalse(map3.containsKey(40) && map3.containsValue(40));
        assertEquals(map3.size(), 4);
        assertEquals(map3.toString(), "{25=25, 35=35, 45=45, 60=60}");

        bst3.remove(25);
        assertFalse(bst3.contains(25));
        assertEquals(bst3.size(), 3);
        assertEquals(bst3.keys().toString(), "[35, 45, 60]");
        map3.remove(25, 25);
        assertFalse(map3.containsKey(25) && map3.containsValue(25));
        assertEquals(map3.size(), 3);
        assertEquals(map3.toString(), "{35=35, 45=45, 60=60}");

        bst3.remove(45);
        assertFalse(bst3.contains(45));
        assertEquals(bst3.size(), 2);
        assertEquals(bst3.keys().toString(), "[35, 60]");
        map3.remove(45, 45);
        assertFalse(map3.containsKey(45) && map3.containsValue(45));
        assertEquals(map3.size(), 2);
        assertEquals(map3.toString(), "{35=35, 60=60}");

        bst3.remove(60);
        assertFalse(bst3.contains(60));
        assertEquals(bst3.size(), 1);
        assertEquals(bst3.keys().toString(), "[35]");
        map3.remove(60, 60);
        assertFalse(map3.containsKey(60) && map3.containsValue(60));
        assertEquals(map3.size(), 1);
        assertEquals(map3.toString(), "{35=35}");

        bst3.remove(35);
        assertFalse(bst3.contains(35));
        assertEquals(bst3.size(), 0);
        assertEquals(bst3.keys().toString(), "[]");
        map3.remove(35, 35);
        assertFalse(map3.containsKey(35) && map3.containsValue(35));
        assertEquals(map3.size(), 0);
        assertEquals(map3.toString(), "{}");
    }

    @Test
    public void big_bst_test1() {
        BinarySearchTree<Integer> bigBST = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        List<Integer> elements = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i <= 343; i++) {
            elements.add(i);
        }
        for (int i = 0; i < elements.size(); i++) {
            bigBST.insert(i);
            map.put(i, i);
        }
        assertEquals(bigBST.size(), 343);
        assertEquals(map.size(), 343);
        for (int element : elements) {
            if (element % 2 == 0) {
                bigBST.remove(element);
                map.remove(element, element);
            }
        }

        for (int k = 1000; k <= 10000; k++) {
            if (k % 2 != 0) {
                bigBST.insert(k);
                map.put(k, k);
            }
        }
        assertEquals(bigBST.size(), 4672);
        assertEquals(map.size(), 4672);
    }

    @Test
    public void big_bst_test2() {
        BinarySearchTree<Integer> bigBST = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> bigMap = new TreeMap<>();
        Random rand = new Random();

        for (int i = 1; i < 11; i++) {
            int num = rand.nextInt(500);
            bigBST.insert(num);
            bigMap.put(num, num);
        }
        List<Integer> bigBSTInOrderList = bigBST.keys();
        List<Integer> bigMapKeyList = new ArrayList<>(bigMap.keySet());
        bigBST.remove(bigBSTInOrderList.get(4));
        bigMap.remove(bigMapKeyList.get(4));
        assertFalse(bigBST.contains(bigBSTInOrderList.get(4)));
        assertFalse(bigMap.containsKey(bigMapKeyList.get(4)));
        assertEquals(bigBSTInOrderList.toString(), bigMapKeyList.toString());
    }

    @Test
    public void big_bst_test3() {
        BinarySearchTree<Integer> bigBST1 = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> bigMap1 = new TreeMap<>();
        List<Integer> elementsList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= 300; i++) {
            int num = rand.nextInt(1000);
            if (bigBST1.insert(num) != null) {
                bigMap1.put(num, num);
                elementsList.add(num);
            }

        }

        Random rd = new Random();
        while (!elementsList.isEmpty()) {
            int index = rd.nextInt(elementsList.size());
            int element = elementsList.get(index);

            assertTrue(bigBST1.contains(element));
            bigBST1.remove(element);
            assertFalse(bigBST1.contains(element));

            assertTrue(bigMap1.containsKey(element));
            assertTrue(bigMap1.containsValue(element));
            bigMap1.remove(element);
            assertFalse(bigMap1.containsKey(element));
            assertFalse(bigMap1.containsValue(element));

            assertTrue(elementsList.contains(element));
            elementsList.remove(index);
            assertFalse(elementsList.contains(element));
        }
    }

    @Test
    public void other_bst_test() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int[] bst3Elements = {40, 30, 50, 25, 35, 45, 60};
        for (int element : bst3Elements) {
            bst.insert(element);
            map.put(element, element);
        }
        assertEquals(bst.height(), 2);
        assertEquals(bst.keys().toString(), "[25, 30, 35, 40, 45, 50, 60]");
        assertEquals(map.toString(), "{25=25, 30=30, 35=35, 40=40, 45=45, 50=50, 60=60}");

        bst.remove(30);
        assertFalse(bst.contains(30));
        assertEquals(bst.size(), 6);
        assertEquals(bst.keys().toString(), "[25, 35, 40, 45, 50, 60]");
        map.remove(30, 30);
        assertFalse(map.containsKey(30) && map.containsValue(30));
        assertEquals(map.size(), 6);
        assertEquals(map.toString(), "{25=25, 35=35, 40=40, 45=45, 50=50, 60=60}");

        bst.remove(50);
        assertFalse(bst.contains(50));
        assertEquals(bst.size(), 5);
        assertEquals(bst.keys().toString(), "[25, 35, 40, 45, 60]");
        map.remove(50, 50);
        assertFalse(map.containsKey(50) && map.containsValue(50));
        assertEquals(map.size(), 5);
        assertEquals(map.toString(), "{25=25, 35=35, 40=40, 45=45, 60=60}");

        bst.remove(40);
        assertFalse(bst.contains(40));
        assertEquals(bst.size(), 4);
        assertEquals(bst.keys().toString(), "[25, 35, 45, 60]");
        map.remove(40, 40);
        assertFalse(map.containsKey(40) && map.containsValue(40));
        assertEquals(map.size(), 4);
        assertEquals(map.toString(), "{25=25, 35=35, 45=45, 60=60}");

        bst.remove(25);
        assertFalse(bst.contains(25));
        assertEquals(bst.size(), 3);
        assertEquals(bst.height(), 1);
        assertEquals(bst.keys().toString(), "[35, 45, 60]");
        map.remove(25, 25);
        assertFalse(map.containsKey(25) && map.containsValue(25));
        assertEquals(map.size(), 3);
        assertEquals(map.toString(), "{35=35, 45=45, 60=60}");

        bst.remove(45);
        assertFalse(bst.contains(45));
        assertEquals(bst.size(), 2);
        assertEquals(bst.keys().toString(), "[35, 60]");
        map.remove(45, 45);
        assertFalse(map.containsKey(45) && map.containsValue(45));
        assertEquals(map.size(), 2);
        assertEquals(map.toString(), "{35=35, 60=60}");

        bst.remove(35);
        assertFalse(bst.contains(35));
        assertEquals(bst.size(), 1);
        assertEquals(bst.height(), 0);
        assertEquals(bst.keys().toString(), "[60]");
        map.remove(35, 35);
        assertFalse(map.containsKey(35) && map.containsValue(35));
        assertEquals(map.size(), 1);
        assertEquals(map.toString(), "{60=60}");
    }

    @Test
    public void other_bst_test2() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        bst.insert(45);
        map.put(45, 45);

        bst.insert(35);
        map.put(35, 35);

        bst.insert(60);
        map.put(60, 60);

        bst.remove(45);
        map.remove(45, 45);
        assertEquals(bst.keys().toString(), "[35, 60]");
        assertEquals(map.toString(), "{35=35, 60=60}");
    }

    @Test
    public void empty_bst_test() {
        BinarySearchTree<Integer> emptyBST = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> emptyMap = new TreeMap<>();
        assertEquals(emptyBST.keys().toString(), "[]");
        assertEquals(emptyMap.toString(), "{}");
    }


    /**
         * TODO: Test cases
         */
    @Test
    public void test() {
        insertSmallBST();
        // your tests go here
        bst_insert_test();
        bst_remove_test();
        bst_remove_test2();
        big_bst_test1();
        big_bst_test2();
        big_bst_test3();
        other_bst_test();
        other_bst_test2();
        empty_bst_test();

        // AVL TEST METHODS
        avl_insert_test1();
        avl_remove_test1();
        avl_remove_test2();
        empty_avl_test();
    }

    @Test
    public void small_avl_insert_test() {
        AVLTree<Integer> avlTree = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] avlTreeArray = {1, 2, 3, 4, 5};
        for (int i : avlTreeArray) {
            avlTree.insert(i);
            map.put(i, i);
        }
        assertEquals(avlTree.keys().toString(), "[1, 2, 3, 4, 5]");
        assertEquals(map.toString(), "{1=1, 2=2, 3=3, 4=4, 5=5}");
    }

    @Test
    public void avl_insert_test1() {
        AVLTree<Integer> avlTree = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] avlTreeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : avlTreeArray) {
            avlTree.insert(i);
            map.put(i, i);
        }
        assertEquals(avlTree.keys().toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        assertEquals(map.toString(), "{1=1, 2=2, 3=3, 4=4, 5=5, 6=6, 7=7, 8=8, 9=9, 10=10}");
    }

    @Test
    public void avl_remove_test1() {
        AVLTree<Integer> avlTree = new AVLTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> bigMap1 = new TreeMap<>();
        List<Integer> avlTreeList = new ArrayList<>();

        for (int i = 1; i <= 25; i++) {
            avlTree.insert(i);
            bigMap1.put(i, i);
            avlTreeList.add(i);
        }

        Random rd = new Random();
        while (!avlTreeList.isEmpty()) {
            int index = rd.nextInt(avlTreeList.size());
            int element = avlTreeList.get(index);

            assertTrue(avlTree.contains(element));
            avlTree.remove(element);
            assertFalse(avlTree.contains(element));

            assertTrue(bigMap1.containsKey(element) && bigMap1.containsValue(element));
            bigMap1.remove(element);
            assertFalse(bigMap1.containsKey(element) && bigMap1.containsValue(element));

            assertTrue(avlTreeList.contains(element));
            avlTreeList.remove(index);
            assertFalse(avlTreeList.contains(element));

            assertEquals(avlTree.keys(), avlTreeList);
        }
        assertEquals(avlTree.keys(), avlTreeList);
    }

    @Test
    public void avl_remove_test2() {
        //MORE REMOVE TESTING:
        BinarySearchTree<Integer> avl = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] bst3Elements = {40, 30, 50, 25, 35, 45, 60};
        for (int element : bst3Elements) {
            avl.insert(element);
            map.put(element, element);
        }
        assertEquals(avl.height(), 2);
        assertEquals(avl.keys().toString(), "[25, 30, 35, 40, 45, 50, 60]");

        avl.remove(30);
        assertFalse(avl.contains(30));
        assertEquals(avl.size(), 6);
        assertEquals(avl.keys().toString(), "[25, 35, 40, 45, 50, 60]");
        map.remove(30, 30);
        assertFalse(map.containsKey(30) && map.containsValue(30));
        assertEquals(map.size(), 6);
        assertEquals(map.toString(), "{25=25, 35=35, 40=40, 45=45, 50=50, 60=60}");

        avl.remove(50);
        assertFalse(avl.contains(50));
        assertEquals(avl.size(), 5);
        assertEquals(avl.keys().toString(), "[25, 35, 40, 45, 60]");
        map.remove(50, 50);
        assertFalse(map.containsKey(50) && map.containsValue(50));
        assertEquals(map.size(), 5);
        assertEquals(map.toString(), "{25=25, 35=35, 40=40, 45=45, 60=60}");

        avl.remove(40);
        assertFalse(avl.contains(40));
        assertEquals(avl.size(), 4);
        assertEquals(avl.keys().toString(), "[25, 35, 45, 60]");
        map.remove(40, 40);
        assertFalse(map.containsKey(40) && map.containsValue(40));
        assertEquals(map.size(), 4);
        assertEquals(map.toString(), "{25=25, 35=35, 45=45, 60=60}");

        avl.remove(25);
        assertFalse(avl.contains(25));
        assertEquals(avl.size(), 3);
        assertEquals(avl.keys().toString(), "[35, 45, 60]");
        map.remove(25, 25);
        assertFalse(map.containsKey(25) && map.containsValue(25));
        assertEquals(map.size(), 3);
        assertEquals(map.toString(), "{35=35, 45=45, 60=60}");

        avl.remove(45);
        assertFalse(avl.contains(45));
        assertEquals(avl.size(), 2);
        assertEquals(avl.keys().toString(), "[35, 60]");
        map.remove(45, 45);
        assertFalse(map.containsKey(45) && map.containsValue(45));
        assertEquals(map.size(), 2);
        assertEquals(map.toString(), "{35=35, 60=60}");

        avl.remove(60);
        assertFalse(avl.contains(60));
        assertEquals(avl.size(), 1);
        assertEquals(avl.keys().toString(), "[35]");
        map.remove(60, 60);
        assertFalse(map.containsKey(60) && map.containsValue(60));
        assertEquals(map.size(), 1);
        assertEquals(map.toString(), "{35=35}");

        avl.remove(35);
        assertFalse(avl.contains(35));
        assertEquals(avl.size(), 0);
        assertEquals(avl.keys().toString(), "[]");
        map.remove(35, 35);
        assertFalse(map.containsKey(35) && map.containsValue(35));
        assertEquals(map.size(), 0);
        assertEquals(map.toString(), "{}");
    }

    @Test
    public void empty_avl_test() {
        BinarySearchTree<Integer> emptyAVL = new BinarySearchTree<>((Integer x, Integer y) -> x < y);
        TreeMap<Integer, Integer> emptyMap = new TreeMap<>();
        assertEquals(emptyAVL.keys().toString(), "[]");
        assertEquals(emptyMap.toString(), "{}");
    }
}
