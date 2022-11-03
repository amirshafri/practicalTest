import java.util.ArrayList;
import java.util.List;

public class PracticalTest {

	public static void main(String[] args) {
		String[] row1 = new String[] { "abcdqw", "aafdcw4ffs", "ddheehed", "ddwq43334" };
		String[] row2 = new String[] { "ab", "acbdw", "dddddddddd", "fdfdfdfdffe333d" };
		String[] row3 = new String[] { "fdswddddd", "ab", "dddd", "ddd3dffff3" };
		List<String[]> rows = new ArrayList<String[]>();
		rows.add(row1);
		rows.add(row2);
		rows.add(row3);
		System.out.println("Result maxColLengths:" + toString(maxColLengths(rows)));
	}

	public static int[] maxColLengths(List<String[]> rows) {
		int columnSize = totalColumn(rows);
		int[] result = new int[columnSize];
		for (int i = 0; i < columnSize; i++) {
			for (String[] row : rows) {
				try {
					if (row[i] != null) {
						if (result[i] < row[i].length()) {
							result[i] = row[i].length();
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}

		return result;
	}

	public static int totalColumn(List<String[]> rows) {
		int sumColumn = 0;
		for (String[] row : rows) {
			if (sumColumn < row.length) {
				sumColumn = row.length;
			}
		}
		return sumColumn;
	}

	public static String toString(int[] result) {
		String output = "[";
		for (int v : result) {
			output = output + v + ",";
		}
		output = output.substring(0, output.length() - 1);
		output = output + "]";
		return output;

	}

}
