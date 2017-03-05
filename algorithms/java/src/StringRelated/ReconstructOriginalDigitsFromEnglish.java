package StringRelated;

import java.util.Arrays;

public class ReconstructOriginalDigitsFromEnglish {
    public class Key {
        public Key(char ch, int num) {
            this.ch = ch;
            this.num = num;
        }

        public char ch;
        public int num;
    }

    private Key table[][] = {
            {new Key('z', 1), new Key('e', 1), new Key('r', 1), new Key('o', 1)}, // zero
            {new Key('o', 1), new Key('n', 1), new Key('e', 1)}, // one
            {new Key('t', 1), new Key('w', 1), new Key('o', 1)}, // two
            {new Key('t', 1), new Key('h', 1), new Key('r', 1), new Key('e', 2)}, // three
            {new Key('f', 1), new Key('o', 1), new Key('u', 1), new Key('r', 1)}, // four
            {new Key('f', 1), new Key('i', 1), new Key('v', 1), new Key('e', 1)}, // five
            {new Key('s', 1), new Key('i', 1), new Key('x', 1)}, // six
            {new Key('s', 1), new Key('e', 2), new Key('v', 1), new Key('n', 1)}, // seven
            {new Key('e', 1), new Key('i', 1), new Key('g', 1), new Key('h', 1), new Key('t',
                    1)}, // eight
            {new Key('n', 2), new Key('i', 1), new Key('e', 1)}, // nine
    };
    // int[] currentDigits stores current numbers of digits
    // num = currentDigits[0] means have `number` 0.
    // remainNumber = currentDigits[27] means total remain number
    protected static int Total_Index = 27;

    static char[] result = new char[50000 / 3]; // one digit contains at least three chars
    int resultLen = 0;

    private void revertAll(int digit, int[] currentDigits) {
        revertFractional(digit, currentDigits, table[digit].length - 1);
    }

    private void revertFractional(int digit, int[] currentDigits, int currentEnd) {
        // revert currentDigits
        Key[] digits = table[digit];
        for (; currentEnd >= 0; currentEnd--) {
            int d = digits[currentEnd].ch - 'a';
            int num = digits[currentEnd].num;
            currentDigits[d] += num;
            currentDigits[Total_Index - 1] += num;

        }
    }

    private boolean formDigit(int[] currentDigits) {
        if (currentDigits[Total_Index - 1] == 0) {
            return true;
        }
        for (char j = 0; j <= 9; j++) {
            Key[] digits = table[j];
            boolean found = true;
            int i;
            for (i = 0; i < digits.length; i++) {
                int d = digits[i].ch - 'a';
                int num = digits[i].num;
                if (currentDigits[d] >= num) {
                    currentDigits[d] -= num;
                    currentDigits[Total_Index - 1] -= num;
                } else {
                    found = false;
                    break;
                }
            }
            if (!found) {
                revertFractional(j, currentDigits, i - 1);
                continue;
            }

            result[resultLen++] = (char)(j + '0');
            result[resultLen] = '\0';
            System.out.printf("%dth: %s\n", resultLen, result);
            boolean next = formDigit(currentDigits);
            if (next == false) {
                resultLen--;
                revertAll(j, currentDigits); // revert and continue to try another digit
            } else {
                return true;
            }
        }
        return false;
    }

    protected int[] getCurrentDigits(String s) {
        int[] digits = new int[Total_Index];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            digits[index]++;
        }
        digits[Total_Index - 1] = s.length();
        return digits;
    }

    public String originalDigits(String s) {
        int[] currentDigits = getCurrentDigits(s);
        resultLen = 0;
        formDigit(currentDigits);
        char[] ret = Arrays.copyOf(result, resultLen);
        Arrays.sort(ret);
        StringBuilder resultStr = new StringBuilder(ret.length);
        for (int i = 0; i < ret.length; i++) {
            resultStr.append(ret[i]);
        }
        return resultStr.toString();
    }
}
