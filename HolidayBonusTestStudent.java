import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus_BasicCase() {
        double[][] salesData = {
            { 500.0, 300.0, 200.0 },
            { 150.0, 700.0, 100.0 },
            { 200.0, 300.0, 400.0 }
        };

        double[] expectedBonuses = { 7000.0, 8000.0, 9000.0 };
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertArrayEquals("Basic case test failed", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus_BasicCase() {
        double[][] salesData = {
            { 500.0, 300.0, 200.0 },
            { 150.0, 700.0, 100.0 },
            { 200.0, 300.0, 400.0 }
        };

        double expectedTotalBonus = 21000.0;
        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);
        assertEquals("Total holiday bonus calculation test failed", expectedTotalBonus, actualTotalBonus, 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_SingleRow() {
        double[][] salesData = {
            { 500.0, 300.0, 200.0 }
        };

        double[] expectedBonuses = { 10000.0 };
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertArrayEquals("Single row test failed", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_WithNegativeValues() {
        double[][] salesData = {
            { -100.0, 200.0, -300.0 },
            { 150.0, -250.0, 100.0 },
            { 0.0, 300.0, 400.0 }
        };

        double[] expectedBonuses = { 2000.0, 1000.0, 8000.0 };
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertArrayEquals("Negative values test failed", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_AllZeroValues() {
        double[][] salesData = {
            { 0.0, 0.0, 0.0 },
            { 0.0, 0.0, 0.0 },
            { 0.0, 0.0, 0.0 }
        };

        double[] expectedBonuses = { 0.0, 0.0, 0.0 };
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertArrayEquals("All zero values test failed", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateHolidayBonus_EmptyRow() {
        double[][] salesData = {
            {}
        };

        double[] expectedBonuses = { 0.0 };
        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(salesData);
        assertArrayEquals("Empty row test failed", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonus_AllZeroValues() {
        double[][] salesData = {
            { 0.0, 0.0, 0.0 },
            { 0.0, 0.0, 0.0 },
            { 0.0, 0.0, 0.0 }
        };

        double expectedTotalBonus = 0.0;
        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(salesData);
        assertEquals("Total bonus for all zero values test failed", expectedTotalBonus, actualTotalBonus, 0.001);
    }
}