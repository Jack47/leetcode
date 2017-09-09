package Math;

public class ComplexNumberMultiplication {
    int[] parseComplexNumber(String s) {
        int i = 0;
        String[] parts = s.split("\\+");
        int real = Integer.parseInt(parts[0]);
        // Remove i;
        int virtual = Integer.parseInt(parts[1].replace("i", ""));
        return new int[]{real, virtual};
    }

    String toString(int real, int virtual) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(real));
        sb.append("+");
        sb.append(String.valueOf(virtual));
        sb.append("i");
        return sb.toString();
    }

    public String complexNumberMultiply(String a, String b) {
        int[] c1 = parseComplexNumber(a);
        int[] c2 = parseComplexNumber(b);
        int[] nc = new int[2];
        nc[0] = c1[0] * c2[0] - c1[1] * c2[1];
        nc[1] = c1[0] * c2[1] + c2[0] * c1[1];
        return toString(nc[0], nc[1]);
    }
}
