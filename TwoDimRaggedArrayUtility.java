import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

		public TwoDimRaggedArrayUtility() {
			
		}
		
		public static double[][] readFile(File file) {
	        List<double[]> data = new ArrayList<>();

	        try (Scanner scanner = new Scanner(file)) {
	            while (scanner.hasNextLine()) {
	                String line = scanner.nextLine().trim();
	                if (!line.isEmpty()) {
	                    String[] tokens = line.split(" ");
	                    double[] row = new double[tokens.length];
	                    for (int i = 0; i < tokens.length; i++) {
	                        row[i] = Double.parseDouble(tokens[i]);
	                    }
	                    data.add(row);
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found: " + file.getPath());
	            e.printStackTrace();
	            return null; // Return null if the file cannot be read
	        }

	        return data.toArray(new double[data.size()][]);
	    }

	    public static boolean writeToFile(double[][] data, File file) {
	        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
	            for (double[] row : data) {
	                for (double value : row) {
	                    writer.print(value + " ");
	                }
	                writer.println();
	            }
	            return true; // Return true if writing is successful
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + file.getPath());
	            e.printStackTrace();
	            return false; // Return false if there’s an issue writing
	        }
	    }

		
		public static double getTotal(double[][] data) {
			double total = 0;
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j< data[i].length; j++) {
					total += data[i][j];
				}
			}
			return total;
		}
		
		public static double getAverage(double[][] data) {
			double total = getTotal(data);
			int count = 0;
			for (int i = 0 ; i < data.length; i++) {
				count += data[i].length;
			}
			return count > 0 ? total / count : 0;
		}
		
		public static double getRowTotal(double[][] data, int row) {
			double total = 0;
			for (int i = 0; i < data[row].length; i++) {
				total += data[row][i];
			}
			return total;
		}
		
		public static double getColumnTotal(double[][] data, int col) {
			double total = 0;
			for (int i = 0; i < data.length; i++) {
				if (col < data[i].length) {
					total += data[i][col];
				}
			}
			return total;
		}
		
		public static double getHighestInRow(double[][] data, int row) {
			double maxVal = data[row][0];
			for (int i = 1; i < data[row].length; i++) {
				if (data[row][i] > maxVal) {
					maxVal = data[row][i];
				}
			}
			return maxVal;
		}
		
		public static double getLowestInRow(double[][] data, int row) {
			double minVal = data[row][0];
			for (int i = 1; i < data[row].length; i++) {
				if (data[row][i] < minVal) {
					minVal = data[row][i];
				}
			}
			return minVal;
		}
		
		public static double getHighestInColumn(double[][] data, int col) {
			double maxVal = Double.NEGATIVE_INFINITY;
			for (int i = 0; i < data.length; i++) {
	            if (col < data[i].length && data[i][col] > maxVal) {
	                maxVal = data[i][col];
	            }
	        }
	        return maxVal;
		}
		
		public static double getLowestInColumn(double[][] data, int col) {
	        double minVal = Double.POSITIVE_INFINITY;
	        for (int i = 0; i < data.length; i++) {
	            if (col < data[i].length && data[i][col] < minVal) {
	                minVal = data[i][col];
	            }
	        }
	        return minVal;
	    }
		
		public static double getHighestInArray(double[][] data) {
	        double maxVal = Double.NEGATIVE_INFINITY;
	        for (int i = 0; i < data.length; i++) {
	            for (int j = 0; j < data[i].length; j++) {
	                if (data[i][j] > maxVal) {
	                    maxVal = data[i][j];
	                }
	            }
	        }
	        return maxVal;
	    }

	    public static double getLowestInArray(double[][] data) {
	        double minVal = Double.POSITIVE_INFINITY;
	        for (int i = 0; i < data.length; i++) {
	            for (int j = 0; j < data[i].length; j++) {
	                if (data[i][j] < minVal) {
	                    minVal = data[i][j];
	                }
	            }
	        }
	        return minVal;
	    }
}
