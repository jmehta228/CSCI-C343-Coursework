import java.util.Random;

/**
 * TODO: Implement the fillCache(), getResult(), and traceback() methods, in
 * that order. This is the biggest part of this project.
 */

public class SequenceAligner {
    private static Random gen = new Random();

    private String x, y;
    private int n, m;
    private String alignedX, alignedY;
    private Result[][] cache;
    private Judge judge;

    /**
     * Generates a pair of random DNA strands, where x is of length n and
     * y has some length between n/2 and 3n/2, and aligns them using the
     * default judge.
     */
    public SequenceAligner(int n) {
        this(randomDNA(n), randomDNA(n - gen.nextInt(n / 2) * (gen.nextInt(2) * 2 - 1)));
    }

    /**
     * Aligns the given strands using the default judge.
     */
    public SequenceAligner(String x, String y) {
        this(x, y, new Judge());
    }

    /**
     * Aligns the given strands using the specified judge.
     */
    public SequenceAligner(String x, String y, Judge judge) {
        this.x = x.toUpperCase();
        this.y = y.toUpperCase();
        this.judge = judge;
        n = x.length();
        m = y.length();
        cache = new Result[n + 1][m + 1];
        fillCache();
        traceback();
    }

    /**
     * Returns the x strand.
     */
    public String getX() {
        return x;
    }

    /**
     * Returns the y strand.
     */
    public String getY() {
        return y;
    }

    /**
     * Returns the judge associated with this pair.
     */
    public Judge getJudge() {
        return judge;
    }

    /**
     * Returns the aligned version of the x strand.
     */
    public String getAlignedX() {
        return alignedX;
    }

    /**
     * Returns the aligned version of the y strand.
     */
    public String getAlignedY() {
        return alignedY;
    }

    /**
     * TODO: Solve the alignment problem using bottom-up dynamic programming
     * algorithm described in lecture. When you're done, cache[i][j] will hold
     * the result of solving the alignment problem for the first i characters
     * in x and the first j characters in y.
     * <p>
     * Your algorithm must run in O(n * m) time, where n is the length of x
     * and m is the length of y.
     * <p>
     * Ordering convention: So that your code will identify the same alignment
     * as is expected in Testing, we establish the following preferred order
     * of operations: M (diag), I (left), D (up). This only applies when you
     * are picking the operation with the biggest payoff and two or more
     * operations have the same max score.
     */
    private void fillCache() {
        // delete this line and add your code
        char[] xCharArray = x.toCharArray();
        char[] yCharArray = y.toCharArray();
        Result left, up, diagonal;

        cache[0][0] = new Result(0, Direction.NONE);
        for (int i = 1; i <= xCharArray.length; i++) {
            cache[i][0] = new Result(getJudge().getGapCost() + cache[i - 1][0].getScore(), Direction.UP);
        }
        for (int k = 1; k <= yCharArray.length; k++) {
            cache[0][k] = new Result(getJudge().getGapCost() + cache[0][k - 1].getScore(), Direction.LEFT);
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                diagonal = cache[i - 1][k - 1];
                left = cache[i][k - 1];
                up = cache[i - 1][k];
                if (xCharArray[i - 1] == yCharArray[k - 1]) {
                    diagonal = new Result(diagonal.getScore() + getJudge().getMatchCost(), Direction.DIAGONAL);
                }
                else {
                    diagonal = new Result(diagonal.getScore() + getJudge().getMismatchCost(), Direction.DIAGONAL);
                }
                left = new Result(left.getScore() + getJudge().getGapCost(), Direction.LEFT);
                up = new Result(up.getScore() + getJudge().getGapCost(), Direction.UP);
                Result bestResult = bestYet(diagonal, bestYet(left, up));
                cache[i][k] = bestResult;
            }
        }
    }

    public Result bestYet(Result r1, Result r2) {
        if (r1.getScore() > r2.getScore()) {
            return r1;
        }
        else if (r1.getScore() < r2.getScore()) {
            return r2;
        }
        else {
            Result equalScoreResult;
            if (r2.getParent().equals(Direction.DIAGONAL)) {
                equalScoreResult = r2;
            }
            else if (r1.getParent().equals(Direction.DIAGONAL)) {
                equalScoreResult = r1;
            }
            else if (r2.getParent().equals(Direction.LEFT)) {
                equalScoreResult = r2;
            }
            else {
                equalScoreResult = r1;
            }
            return equalScoreResult;
        }
    }


    /**
     * TODO: Returns the result of solving the alignment problem for the
     * first i characters in x and the first j characters in y. You can
     * find the result in O(1) time by looking in your cache.
     */
    public Result getResult(int i, int j) {
//        return null;  // delete this line and add your code
        return cache[i][j];
    }

    /**
     * TODO: Mark the path by tracing back through parent pointers, starting
     * with the Result in the lower right corner of the cache. Call Result.markPath()
     * on each Result along the path. The GUI will highlight all such marked cells
     * when you check 'Show path'. As you're tracing back along the path, build
     * the aligned strings in alignedX and alignedY (using Constants.GAP_CHAR
     * to denote a gap in the strand).
     * <p>
     * Your algorithm must run in O(n + m) time, where n is the length of x
     * and m is the length of y.
     */
    private void traceback() {
        // delete this line and add your code
        char[] xCharArray = x.toCharArray();
        char[] yCharArray = y.toCharArray();
        alignedX = "";
        alignedY = "";
        boolean processCompleted = false;
        Result next;
        int x = n;
        int y = m;
        Result curr = cache[x][y];
        curr.markPath();
        Direction prev = curr.getParent();

        if (xCharArray.length != 0 && yCharArray.length != 0) {
            while (!processCompleted) {
                if (prev.equals(Direction.DIAGONAL)) {
                    alignedX += xCharArray[x - 1];
                    alignedY += yCharArray[y - 1];
                    x -= 1;
                    y -= 1;
                    next = cache[x][y];
                }
                else if (prev.equals(Direction.LEFT)) {
                    alignedX += '_';
                    alignedY += yCharArray[y - 1];
                    y -= 1;
                    next = cache[x][y];
                }
                else {
                    alignedX += xCharArray[x - 1];
                    alignedY += '_';
                    x -= 1;
                    next = cache[x][y];
                }
                next.markPath();
                curr = next;
                prev = curr.getParent();

                if (x == 0 && y == 0) {
                    processCompleted = true;
                }
            }
            alignedX = new StringBuilder(alignedX).reverse().toString();
            alignedY = new StringBuilder(alignedY).reverse().toString();
        }
    }

    /**
     * Returns true iff these strands are seemingly aligned.
     */
    public boolean isAligned() {
        return alignedX != null && alignedY != null &&
                alignedX.length() == alignedY.length();
    }

    /**
     * Returns the score associated with the current alignment.
     */
    public int getScore() {
        if (isAligned())
            return judge.score(alignedX, alignedY);
        return 0;
    }

    /**
     * Returns a nice textual version of this alignment.
     */
    public String toString() {
        if (!isAligned())
            return "[X=" + x + ",Y=" + y + "]";
        final char GAP_SYM = '.', MATCH_SYM = '|', MISMATCH_SYM = ':';
        StringBuilder ans = new StringBuilder();
        ans.append(alignedX).append('\n');
        int n = alignedX.length();
        for (int i = 0; i < n; i++)
            if (alignedX.charAt(i) == Constants.GAP_CHAR || alignedY.charAt(i) == Constants.GAP_CHAR)
                ans.append(GAP_SYM);
            else if (alignedX.charAt(i) == alignedY.charAt(i))
                ans.append(MATCH_SYM);
            else
                ans.append(MISMATCH_SYM);
        ans.append('\n').append(alignedY).append('\n').append("score = ").append(getScore());
        return ans.toString();
    }

    /**
     * Returns a DNA strand of length n with randomly selected nucleotides.
     */
    private static String randomDNA(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append("ACGT".charAt(gen.nextInt(4)));
        return sb.toString();
    }

}
