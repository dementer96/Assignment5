public class HolidayBonus {

    // Constants for bonus amounts
    private static final double BONUS_FOR_HIGHEST = 5000.0;
    private static final double BONUS_FOR_LOWEST = 1000.0;
    private static final double BONUS_FOR_OTHER = 2000.0;

    public HolidayBonus() {
        // Default constructor
    }

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        // Loop through each column (category)
        for (int col = 0; col < getMaxColumnLength(data); col++) {
            // Use TwoDimRaggedArrayUtility to get highest and lowest sales in this column
            double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

            // Calculate bonuses for each store in this column
            for (int row = 0; row < data.length; row++) {
                if (col < data[row].length) {
                    double sales = data[row][col];
                    if (sales > 0) {
                        if (sales == highest) {
                            bonuses[row] += BONUS_FOR_HIGHEST;
                        } else if (sales == lowest) {
                            bonuses[row] += BONUS_FOR_LOWEST;
                        } else {
                            bonuses[row] += BONUS_FOR_OTHER;
                        }
                    }
                }
            }
        }
        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) {
        double[] bonuses = calculateHolidayBonus(data);
        double totalBonus = 0;
        for (int i = 0; i < bonuses.length; i++) {
            totalBonus += bonuses[i];
        }
        return totalBonus;
    }

    public static int getMaxColumnLength(double[][] data) {
        int maxLength = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length > maxLength) {
                maxLength = data[i].length;
            }
        }
        return maxLength;
    }
}