import MockExam.*;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class MockExamTest {
    private ByteArrayOutputStream out;
    private String expected = "";

    private void init(String outPath) {
        if(out != null) {
            try {
                out.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        out = new ByteArrayOutputStream();

        try {
            expected = new String(Files.readAllBytes(Paths.get(outPath)));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWindMillExample() throws FileNotFoundException {
        String inPath = "testCases/WindMill/example.in.txt";
        String outPath = "testCases/WindMill/example.out.txt";

        init(outPath);

        WindMill.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString());
    }
}
