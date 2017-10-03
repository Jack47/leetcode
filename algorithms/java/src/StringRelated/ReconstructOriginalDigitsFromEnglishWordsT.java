package StringRelated;

public class ReconstructOriginalDigitsFromEnglishWordsT {
    class Count {
        char key;
        int num;

        Count(char k, int n) {
            key = k;
            num = n;
        }
    }

    Count[][] counts = new Count[][]{
            {new Count('z', 1), new Count('e', 1), new Count('r', 1), new Count('o', 1)},
            {new Count('o', 1), new Count('n', 1), new Count('e', 1)},
            {new Count('t', 1), new Count('w', 1), new Count('o', 1)},
            {new Count('t', 1), new Count('h', 1), new Count('r', 1), new Count('e', 2)},
            {new Count('f', 1), new Count('o', 1), new Count('u', 1), new Count('r', 1)},
            {new Count('f', 1), new Count('i', 1), new Count('v', 1), new Count('e', 1)},
            {new Count('s', 1), new Count('i', 1), new Count('x', 1)},
            {new Count('s', 1), new Count('e', 2), new Count('v', 1), new Count('n', 1)},
            {new Count('e', 1), new Count('i', 1), new Count('g', 1), new Count('h', 1), new Count('t', 1)},
            {new Count('n', 2), new Count('i', 2), new Count('e', 1)}};
    int[] nums;
    int[] result;

    void count(int num, char ch) {
        int n = nums[ch];
        if (n == 0) return;
        result[num] = n;

        for (Count c : counts[num]) {
            nums[c.key] -= c.num * n;
        }
    }

    public String originalDigits(String s) {
        nums = new int[256];
        result = new int[10];
        for (char ch : s.toCharArray()) {
            nums[ch]++;
        }

        count(0, 'z');
        count(8, 'g');
        count(2, 'w');
        count(3, 't');
        count(4, 'u');
        count(5, 'f');
        count(6, 'v');
        count(7, 'x');
        count(9, 'i');
        count(1, 'o');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            String str = Integer.toString(i);
            for (int k = 0; k < result[i]; k++) {
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
