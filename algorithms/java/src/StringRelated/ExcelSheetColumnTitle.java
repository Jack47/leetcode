package StringRelated;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        sb.append((char) (n - 1 + 'A'));

        return sb.reverse().toString();
    }
}
