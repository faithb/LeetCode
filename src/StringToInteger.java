/**
* # Intuition
 * The problem requires converting a string to a 32-bit signed integer,
 * handling leading whitespace, optional signs, and non-numeric characters.
 * The approach involves trimming whitespace, checking for a sign, and then parsing digits while managing overflow.
* # Approach
 * 1. Trim leading and trailing whitespace from the string.
 * 2. Check if the first character is a '+' or '-' to determine the sign of the number.
 * 3. Iterate through the characters of the string, converting digits to an integer.
 * 4. Handle overflow by checking if the current total exceeds the limits of a 32-bit signed integer.
 * 5. Return the final integer value with the appropriate sign.
* # Complexity
 * - Time Complexity: O(n), where n is the length of the string. We may need to traverse the entire string in the worst case.
 * - Space Complexity: O(1), as we are using a constant amount of space regardless
*/

public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, index = 0, total = 0;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') break;

            int digit = c - '0';
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        String input = "   - jgj 42";
        int result = solution.myAtoi(input);
        System.out.println("String to Integer conversion of '" + input + "' is: " + result);
    }
}
