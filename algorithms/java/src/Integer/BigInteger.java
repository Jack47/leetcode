package Integer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BigInteger {
    protected final byte[] content;

    protected static final byte[] ZERO_BYTE_ARRAY = new byte[]{0x00};

    public BigInteger(final String integerStr) {
        content = toBinaryByteArray(integerStr);
    }

    public BigInteger(final byte[] bigendianBytes) {
        content = Arrays.copyOf(bigendianBytes, bigendianBytes.length);
    }

    public BigInteger(final BigInteger other) {
        content = Arrays.copyOf(other.content, other.content.length);
    }

    protected static byte[] toBinaryByteArray(final String integerStr) {
        List<Byte> remainderList = new LinkedList<Byte>();
        StringBuilder quotient = new StringBuilder(integerStr);

        int weight = 1;
        int byteValue = 0;
        while (quotient.length() > 0) {
            String integer = quotient.toString();
            quotient.setLength(0);
            int remainder = divideDecimalString(integer, 2, quotient);
            assert (remainder == 1 || remainder == 0);
            byteValue = (byteValue | weight * remainder);
            assert (weight <= 0x80);
            assert (byteValue <= 0xFF);
            if (weight == 0x80) {
                weight = 1;
                remainderList.add(0, (byte) byteValue);
                byteValue = 0;
            } else {
                weight = (weight << 1);
            }
        }
        if (weight != 1) { // last byteValue is not stored
            remainderList.add(0, (byte) byteValue);
        }
        return toArray(remainderList);
    }

    protected static byte[] toArray(List<Byte> byteList) {
        byte[] array = new byte[byteList.size()];
        int i = 0;
        for (Byte value : byteList) {
            array[i++] = value;
        }
        return array;
    }

    /**
     * calculate division.
     * divideDecimalString("10", 5, quotient) -> return 0, quotientStr is "2"
     *
     * @param decimal
     * @param divisor
     * @param quotientStr
     * @return remainder
     */
    protected static int divideDecimalString(final String decimal,
                                             int divisor,
                                             StringBuilder quotientStr) {
        int left = 0;
        if (decimal.length() == 0) {
            return left;
        }
        for (int i = 0; i < decimal.length(); i++) {
            int num = left * 10 + decimal.charAt(i) - '0';
            quotientStr.append(num / divisor);
            left = num % divisor;
        }
        while (quotientStr.length() > 0 && quotientStr.charAt(0) == '0') {
            quotientStr.deleteCharAt(0);
        }
        return left;
    }

    protected static String addDecimalString(final String oneDecimalString,
                                             final String anotherDecimalString) {
        int i = oneDecimalString.length() - 1;
        int j = anotherDecimalString.length() - 1;
        int carrier = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? oneDecimalString.charAt(i) - '0' : 0;
            int num2 = j >= 0 ? anotherDecimalString.charAt(j) - '0' : 0;
            int sum = num1 + num2 + carrier;
            carrier = sum / 10;
            result.insert(0, sum % 10);
            i--;
            j--;
        }
        if (carrier > 0) {
            result.insert(0, carrier);
        }
        return result.toString();
    }

    protected static String multiplyDecimalString(final String decimalString, int num) {
        int product = 0;
        String currentResult = new String();

        for (int j = 0; j < decimalString.length(); j++) {
            if (!currentResult.equals("0")) { // add weight
                currentResult = currentResult.concat("0");
            }
            product = (decimalString.charAt(j) - '0') * num;
            String singleResult = String.valueOf(product);
            currentResult = addDecimalString(currentResult, singleResult);
        }

        return currentResult;
    }

    /**
     * Convert BigInteger to string represented num.
     * "19839231345"
     *
     * @return
     */
    public String toString() {
        String result = new String();
        for (byte b : content) {
            String prevResult = multiplyDecimalString(result, 256);
            String single = String.valueOf(byteToUnsignedInt(b));
            result = addDecimalString(prevResult, single);
        }
        return result;
    }

    protected int byteToUnsignedInt(byte b) {
        return b & 0xFF;
    }

    public BigInteger add(final BigInteger other) {
        List<Byte> sum = new LinkedList<Byte>();
        int carrier = 0;
        int i = this.content.length - 1;
        int j = other.content.length - 1;
        while (i >= 0 || j >= 0) {
            int num1 = i >= 0 ? byteToUnsignedInt(content[i]) : 0;
            int num2 = j >= 0 ? byteToUnsignedInt(other.content[j]) : 0;
            int s = num1 + num2 + carrier;
            carrier = s / 256;
            sum.add(0, (byte) (s % 256));
            i--;
            j--;
        }
        if (carrier != 0) {
            sum.add(0, (byte) carrier);
        }
        byte bytes[] = new byte[sum.size()];
        int k = 0;
        for (Byte b : sum) {
            bytes[k++] = b;
        }
        return new BigInteger(bytes);
    }

    public BigInteger multiply(final BigInteger other) {
        if (other.isZero()) {
            return new BigInteger(other);
        }
        if (this.isZero()) {
            return new BigInteger(this);
        }
        BigInteger current = new BigInteger(new byte[]{0x00});
        for (int i = this.content.length - 1; i >= 0; i--) {
            List<Byte> product = new LinkedList<Byte>();
            int carrier = 0;
            int num1 = byteToUnsignedInt(this.content[i]);
            int p = 0;
            if (num1 == 0) {
                continue;
            }
            for (int j = other.content.length - 1; j >= 0; j--) {
                int num2 = byteToUnsignedInt(other.content[j]);
                p = num2 * num1 + carrier;
                carrier = p / 256;
                assert (carrier <= 0xFF);
                product.add(0, (byte) (p % 256));
            }
            if (carrier != 0) {
                product.add(0, (byte) carrier);
            }
            for (int k = i; k < this.content.length - 1; k++) { // apply weight: 2^8
                product.add(product.size(), (byte) 0x00);
            }
            current = current.add(new BigInteger(toArray(product)));
        }
        return current;
    }

    public boolean isZero() {
        return Arrays.equals(ZERO_BYTE_ARRAY, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigInteger that = (BigInteger) o;

        if (!Arrays.equals(content, that.content)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(content);
    }
}
