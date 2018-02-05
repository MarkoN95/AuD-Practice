import BonusExercises.*;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class BonusExercisesTest extends AuDTest {

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

        assertEquals(expected, out.toString().replace("\r", ""));
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

    @Test
    public void testFleaMarketExample() throws FileNotFoundException {
        String inPath = "testCases/FleaMarket/example.in.txt";
        String outPath = "testCases/FleaMarket/example.out.txt";

        init(outPath);

        FleaMarket.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testFleaMarketExtra() throws FileNotFoundException {
        String inPath = "testCases/FleaMarket/extra.in.txt";
        String outPath = "testCases/FleaMarket/extra.out.txt";

        init(outPath);

        FleaMarket.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testFleaMarketSubtask() throws FileNotFoundException {
        String inPath = "testCases/FleaMarket/subtask1.in.txt";
        String outPath = "testCases/FleaMarket/subtask1.out.txt";

        init(outPath);

        FleaMarket.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testTreeRotationsExample() throws FileNotFoundException {
        String inPath = "testCases/TreeRotations/example.in.txt";
        String outPath = "testCases/TreeRotations/example.out.txt";

        init(outPath);

        TreeRotations.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testTreeRotationsExtra() throws FileNotFoundException {
        String inPath = "testCases/TreeRotations/extra.in.txt";
        String outPath = "testCases/TreeRotations/extra.out.txt";

        init(outPath);

        TreeRotations.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testFrequencyAssignmentExample() throws FileNotFoundException {
        String inPath = "testCases/FrequencyAssignment/example.in.txt";
        String outPath = "testCases/FrequencyAssignment/example.out.txt";

        init(outPath);

        FrequencyAssignment.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testFrequencyAssignmentGeneral() throws FileNotFoundException {
        String inPath = "testCases/FrequencyAssignment/general_instances.in.txt";
        String outPath = "testCases/FrequencyAssignment/general_instances.out.txt";

        init(outPath);

        FrequencyAssignment.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testFrequencyAssignmentSubtask() throws FileNotFoundException {
        String inPath = "testCases/FrequencyAssignment/small_m.in.txt";
        String outPath = "testCases/FrequencyAssignment/small_m.out.txt";

        init(outPath);

        FrequencyAssignment.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testDynamicOSExample() throws FileNotFoundException {
        String inPath = "testCases/DynamicOS/example.in.txt";
        String outPath = "testCases/DynamicOS/example.out.txt";

        init(outPath);

        DynamicOS.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }

    @Test
    public void testDynamicOSExtra() throws FileNotFoundException {
        String inPath = "testCases/DynamicOS/extra.in.txt";
        String outPath = "testCases/DynamicOS/extra.out.txt";

        init(outPath);

        DynamicOS.read_and_solve(
                new FileInputStream(inPath),
                new PrintStream(out)
        );

        assertEquals(expected, out.toString().replace("\r", ""));
    }
}
