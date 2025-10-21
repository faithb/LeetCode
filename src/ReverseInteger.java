public class ReverseInteger {
    public int reverse(int x) {
        long reversed = 0;
        while (x!= 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;

        return (int) reversed;
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int input = 3568413;
        int result = solution.reverse(input);
        System.out.println("Reversed integer of " + input + " is: " + result);
    }

}
