import PracticeExams.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class PracticeExamsTest extends AuDTest {

    @Test
    public void testCellTowersExample() throws FileNotFoundException {
        String inPath = "testCases/CellTowers/example.input";
        String outPath = "testCases/CellTowers/example.output";

        init(outPath);

        CellTowers.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testCellTowersTest1() throws FileNotFoundException {
        String inPath = "testCases/CellTowers/test1.input";
        String outPath = "testCases/CellTowers/test1.output";

        init(outPath);

        CellTowers.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testCellTowersTest2() throws FileNotFoundException {
        String inPath = "testCases/CellTowers/test2.input";
        String outPath = "testCases/CellTowers/test2.output";

        init(outPath);

        CellTowers.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testCellTowersTest3() throws FileNotFoundException {
        String inPath = "testCases/CellTowers/test3.input";
        String outPath = "testCases/CellTowers/test3.output";

        init(outPath);

        CellTowers.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
}
