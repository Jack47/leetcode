package Roman;

public class IntegerToRoman {
    final String[] Thousands = new String[]{"M", "MM", "MMM"};
    final String[] Hundreds = new String[]{"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    final String[] Tens = new String[]{"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    final String[] Ones = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num >= 1000) {
            sb.append(Thousands[num / 1000 - 1]);
            num = num % 1000;
        }
        if (num >= 100) {
            sb.append(Hundreds[num / 100 - 1]);
            num = num % 100;
        }
        if (num >= 10) {
            sb.append(Tens[num / 10 - 1]);
            num = num % 10;
        }
        if (num >= 1) {
            sb.append(Ones[num - 1]);
        }
        return sb.toString();
    }
}
