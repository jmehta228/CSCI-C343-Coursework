/**
 * To test with JUnit, add JUnit to your project. To do this, go to
 * Project->Properties. Select "Java Build Path". Select the "Libraries"
 * tab and "Add Library". Select JUnit, then JUnit 4.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
  @Test
  public void test() {
    defaultJudgeTest();
    customJudgeTest();
    empties();
    singletons();
    // your tests go here
    judge_test_1();
    judge_test_2();
    judge_test_3();

    fillCache_test_1();
    fillCache_test_2();
    fillCache_test_3();

    traceback_test_1();
    traceback_test_2();
    traceback_test_3();
  }

  @Test
  public void defaultJudgeTest() {
    Judge judge = new Judge();
    assertEquals(2, judge.score('A',  'A'));
    assertEquals(2, judge.score("A",  "A"));
  }

  @Test
  public void customJudgeTest() {
    Judge judge = new Judge(3, -3, -2);
    assertEquals(3, judge.score('A',  'A'));
    assertEquals(3, judge.score("A",  "A"));
  }

  @Test
  public void judge_test_1() {
    Judge judge = new Judge();
    assertEquals(6, judge.score("ATATATAT", "ATAT_C_T"));
  }

  @Test
  public void judge_test_2() {
    Judge judge = new Judge();
    assertEquals(21, judge.score("CG_AT_T_TATCGCG", "CG_AT_T_TATCGCG"));
  }

  @Test
  public void judge_test_3() {
    Judge judge = new Judge(3, -3, -2);
    assertEquals(48, judge.score("AGTCAGTCAGTCAGTC", "AGTCAGTCAGTCAGTC"));
  }

  /**********************************************
   * Testing SequenceAligner.fillCache()
   **********************************************/
  @Test
  public void empties() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("", "");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
  }

  @Test
  public void singletons() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("A", "A");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
    result = sa.getResult(0, 1);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.LEFT, result.getParent());
    result = sa.getResult(1, 0);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.UP, result.getParent());
    result = sa.getResult(1, 1);
    assertNotNull(result);
    assertEquals(2, result.getScore());
    assertEquals(Direction.DIAGONAL, result.getParent());
  }

  @Test
  public void fillCache_test_1() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("GAA", "GGA");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
    result = sa.getResult(0, 1);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.LEFT, result.getParent());
    result = sa.getResult(1, 0);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.UP, result.getParent());
    result = sa.getResult(1, 1);
    assertNotNull(result);
    assertEquals(2, result.getScore());
    assertEquals(Direction.DIAGONAL, result.getParent());
  }

  @Test
  public void fillCache_test_2() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("A_C_G_TCG", "ACCACACACACA");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
    result = sa.getResult(0, 1);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.LEFT, result.getParent());
    result = sa.getResult(1, 0);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.UP, result.getParent());
    result = sa.getResult(1, 1);
    assertNotNull(result);
    assertEquals(2, result.getScore());
    assertEquals(Direction.DIAGONAL, result.getParent());
  }

  @Test
  public void fillCache_test_3() {
    SequenceAligner sa;
    Result result;
    sa = new SequenceAligner("ATATATAT", "AATTATAT");
    result = sa.getResult(0, 0);
    assertNotNull(result);
    assertEquals(0, result.getScore());
    assertEquals(Direction.NONE, result.getParent());
    result = sa.getResult(0, 1);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.LEFT, result.getParent());
    result = sa.getResult(1, 0);
    assertNotNull(result);
    assertEquals(-1, result.getScore());
    assertEquals(Direction.UP, result.getParent());
    result = sa.getResult(1, 1);
    assertNotNull(result);
    assertEquals(2, result.getScore());
    assertEquals(Direction.DIAGONAL, result.getParent());
  }

  /**********************************************
   * Testing SequenceAligner.traceback()
   **********************************************/
  @Test
  public void simpleAlignment() {
    SequenceAligner sa;
    sa = new SequenceAligner("ACGT", "ACGT");
    assertTrue(sa.isAligned());
    assertEquals("ACGT", sa.getAlignedX());
    assertEquals("ACGT", sa.getAlignedY());
  }

  @Test
  public void traceback_test_1() {
    SequenceAligner sa;
    sa = new SequenceAligner("ACCA", "ACCA");
    assertTrue(sa.isAligned());
    assertEquals("ACCA", sa.getAlignedX());
    assertEquals("ACCA", sa.getAlignedY());
  }

  @Test
  public void traceback_test_2() {
    SequenceAligner sa;
    sa = new SequenceAligner("ATCG", "ATCG");
    assertTrue(sa.isAligned());
    assertEquals("ATCG", sa.getAlignedX());
    assertEquals("ATCG", sa.getAlignedY());
  }

  @Test
  public void traceback_test_3() {
    SequenceAligner sa;
    sa = new SequenceAligner("CGAAAA", "CGAAAA");
    assertTrue(sa.isAligned());
    assertEquals("CGAAAA", sa.getAlignedX());
    assertEquals("CGAAAA", sa.getAlignedY());
  }


}