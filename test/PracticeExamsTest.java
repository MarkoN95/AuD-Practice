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
}
