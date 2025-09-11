public class KaratsubaMultiplication {

    // Karatsuba multiplication method
    public static String karatsuba(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        // Base case for small numbers
        if (len1 == 1 && len2 == 1) {
            return Integer.toString((num1.charAt(0) - '0') * (num2.charAt(0) - '0'));
        }

        // Equalize lengths by padding with zeros
        int maxLen = Math.max(len1, len2);
        if (maxLen % 2 != 0) maxLen++;

        num1 = padLeftZeros(num1, maxLen);
        num2 = padLeftZeros(num2, maxLen);

        int n = maxLen;
        int m = n / 2;

        String high1 = num1.substring(0, m);
        String low1 = num1.substring(m);
        String high2 = num2.substring(0, m);
        String low2 = num2.substring(m);

        String z0 = karatsuba(low1, low2);
        String z1 = karatsuba(addStrings(low1, high1), addStrings(low2, high2));
        String z2 = karatsuba(high1, high2);

        String part1 = shiftLeft(z2, 2 * (n - m)); // z2 * 10^(2*m)
        String part2 = shiftLeft(subtractStrings(subtractStrings(z1, z2), z0), n - m); // (z1 - z2 - z0) * 10^m

        return removeLeadingZeros(addStrings(addStrings(part1, part2), z0));
    }

    // Adds two numbers represented as strings
    private static String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int len1 = a.length(), len2 = b.length();
        int i = len1 - 1, j = len2 - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        return result.reverse().toString();
    }

    // Subtracts two numbers represented as strings (a > b assumed)
    private static String subtractStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int len1 = a.length(), len2 = b.length();
        int i = len1 - 1, j = len2 - 1;
        int borrow = 0;

        while (i >= 0) {
            int digit1 = a.charAt(i--) - '0';
            int digit2 = j >= 0 ? b.charAt(j--) - '0' : 0;

            int sub = digit1 - digit2 - borrow;
            if (sub < 0) {
                sub += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(sub);
        }
        return removeLeadingZeros(result.reverse().toString());
    }

    // Pads the string with zeros on the left
    private static String padLeftZeros(String s, int n) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + s.length() < n) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    // Shifts a number left by adding zeros at the end (equivalent to multiplying by 10^n)
    private static String shiftLeft(String s, int n) {
        return s + "0".repeat(n);
    }

    // Removes leading zeros from a number
    private static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }
        return s.substring(i);
    }

    // Example usage
    public static void main(String[] args) {
        String num1 = "3141592653589793238462643383279502884197169399375105820974944592";
        String num2 = "2718281828459045235360287471352662497757247093699959574966967627";

        String product = karatsuba(num1, num2);
        System.out.println("Product: " + product);
    }
}
 {
    
}
