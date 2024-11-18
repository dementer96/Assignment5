import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testGetTotal() {
        double[][] data = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0 }
        };
        assertEquals(21.0, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetAverage() {
        double[][] data = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0 }
        };
        assertEquals(3.5, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        double[][] data = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0 }
        };
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0 }
        };
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testReadFileAndWriteToFile() throws IOException {
        double[][] expectedData = {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0 }
        };

        File testFile = new File("testData.txt");
        TwoDimRaggedArrayUtility.writeToFile(expectedData, testFile);
        double[][] actualData = TwoDimRaggedArrayUtility.readFile(testFile);

        for (int i = 0; i < expectedData.length; i++) {
            assertArrayEquals(expectedData[i], actualData[i], 0.001);
        }

        // Cleanup test file after testing
        testFile.delete();
    }
}