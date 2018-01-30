import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import BonusExercises.*;

import static org.junit.Assert.assertEquals;

public class BonusExercisesTest {

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
    public void testSlidingCoinExample() throws FileNotFoundException {
        String inPath = "testCases/SlidingCoin/example.in.txt";
        String outPath = "testCases/SlidingCoin/example.out.txt";

        init(outPath);

        SlidingCoin.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testSlidingCoinExtra() throws FileNotFoundException {
        String inPath = "testCases/SlidingCoin/extra.in.txt";
        String outPath = "testCases/SlidingCoin/extra.out.txt";

        init(outPath);

        SlidingCoin.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testSubmatrixSumExample() throws FileNotFoundException {
        String inPath = "testCases/SubmatrixSum/example.in.txt";
        String outPath = "testCases/SubmatrixSum/example.out.txt";

        init(outPath);

        SubmatrixSum.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testSubmatrixSumSmall() throws FileNotFoundException {
        String inPath = "testCases/SubmatrixSum/small.in.txt";
        String outPath = "testCases/SubmatrixSum/small.out.txt";

        init(outPath);

        SubmatrixSum.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testSubmatrixSumBig() throws FileNotFoundException {
        String inPath = "testCases/SubmatrixSum/big.in.txt";
        String outPath = "testCases/SubmatrixSum/big.out.txt";

        init(outPath);

        SubmatrixSum.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testInversionsExample() throws FileNotFoundException {
        String inPath = "testCases/Inversions/example.in.txt";
        String outPath = "testCases/Inversions/example.out.txt";

        init(outPath);

        Inversions.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testInversionsExtra() throws FileNotFoundException {
        String inPath = "testCases/Inversions/extra.in.txt";
        String outPath = "testCases/Inversions/extra.out.txt";

        init(outPath);

        Inversions.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testMountainTripExample() throws FileNotFoundException {
        String inPath = "testCases/MountainTrip/example.in.txt";
        String outPath = "testCases/MountainTrip/example.out.txt";

        init(outPath);

        MountainTrip.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testMountainTripExtra() throws FileNotFoundException {
        String inPath = "testCases/MountainTrip/extra.in.txt";
        String outPath = "testCases/MountainTrip/extra.out.txt";

        init(outPath);

        MountainTrip.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testDynoExample() throws FileNotFoundException {
        String inPath = "testCases/Dyno/example.in.txt";
        String outPath = "testCases/Dyno/example.out.txt";

        init(outPath);

        Dyno.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString());
    }

    @Test
    public void testDynoExtra() throws FileNotFoundException {
        String inPath = "testCases/Dyno/extra.in.txt";
        String outPath = "testCases/Dyno/extra.out.txt";

        init(outPath);

        Dyno.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testLightCoffeeExample() throws FileNotFoundException {
        String inPath = "testCases/LightCoffee/example.in.txt";
        String outPath = "testCases/LightCoffee/example.out.txt";

        init(outPath);

        LightCoffee.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testLightCoffeeExtra() throws FileNotFoundException {
        String inPath = "testCases/LightCoffee/extra.in.txt";
        String outPath = "testCases/LightCoffee/extra.out.txt";

        init(outPath);

        LightCoffee.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testLightCoffeeSubtask() throws FileNotFoundException {
        String inPath = "testCases/LightCoffee/weight_1.in.txt";
        String outPath = "testCases/LightCoffee/weight_1.out.txt";

        init(outPath);

        LightCoffee.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
}
