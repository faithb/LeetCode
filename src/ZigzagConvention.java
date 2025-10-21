import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ZigzagConvention {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int index = 0, dir = 1;
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0) {
                dir = 1;
            } else if (index == numRows - 1) {
                dir = -1;
            }
            index += dir;
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) ans.append(row);
        return ans.toString();
    }

    static void main() {
        ZigzagConvention zigzag = new ZigzagConvention();
        String result = zigzag.convert("PAYPALISHIRING", 3);
        System.out.println("Zigzag Conversion Result: " + result);
    }
}