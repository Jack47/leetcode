package BitManipulation;

/**
 * Given a string array words, find the maximum value of length(word[i])*length(word[j]) where
 * the two words do not share common letters.
 * Assume that each word will contain only lower case letters.
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class MaximumProductOfWordLength {
    public class LetterBitMap {
        int bitMap;

        public LetterBitMap(String word) {
            bitMap = 0;
            for (int i = 0; i < word.length(); i++) {
                bitMap = bitMap | (1 << (word.charAt(i) - 'a'));
            }
        }

        public int getBitMap() {
            return bitMap;
        }
    }

    public int maxProduct(String[] words) {
        if (words.length == 0 || words.length == 1) return 0;
        LetterBitMap[] bitMaps = new LetterBitMap[words.length];
        for (int i = 0; i < words.length; i++) {
            bitMaps[i] = new LetterBitMap(words[i]);
        }
        int maximumProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i; j < words.length; j++) {
                boolean hasCommondLetter = (bitMaps[i].getBitMap() & bitMaps[j].getBitMap()) != 0;
                if (!hasCommondLetter) {
                    int product = words[i].length() * words[j].length();
                    if (product > maximumProduct) {
                        maximumProduct = product;
                    }
                }
            }
        }
        return maximumProduct;
    }
}
