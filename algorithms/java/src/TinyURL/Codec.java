package TinyURL;

import java.util.HashMap;
import java.util.HashSet;

// 535. Encode and Decode TinyURL
// https://leetcode.com/problems/design-tinyurl/#/description
// TinyURL is a URL shortening service where you enter a URL such as https://leetcode
// .com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk
// You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded
// to the original URL.
public class Codec {
    protected HashMap<String, String> values;
    protected HashSet<Integer> keys;

    public Codec() {
        values = new HashMap<String, String>();
        keys = new HashSet<Integer>();
    }

    protected final static int Variant = 62;
    protected final static int Len = (int) Math.round(Math.log(Math.pow(2,
            31)) / Math.log(Variant)) + 1;

    protected char getChar(char ch) {
        assert (ch >= 0 && ch < 62);
        char result = '0';
        if (ch >= 0 && ch <= 9) {
            result = (char) (ch + '0');
        } else if (ch >= 10 && ch <= 35) {
            result = (char) (ch - 10 + 'a');
        } else {
            result = (char) (ch - 36 + 'A');
        }
        return result;
    }

    public String decode(String shortUrl) {
        return values.get(shortUrl);
    }

    public String encode(String longUrl) {
        int originHash = Math.abs(longUrl.hashCode());
        int hash;
        char[] result = new char[Len];

        String key;
        String value;
        do {
            hash = originHash;
            int i = 0;
            int n;
            while (hash != 0) {
                n = hash % Variant;
                hash = hash / Variant;
                result[i++] = getChar((char) n);
            }
            assert (i <= Len);
            key = new String(result, 0, i);
            value = values.get(key);
            originHash = originHash * 31;
        } while (value != null && value.compareTo(longUrl) != 0); // key collision

        // key not exist
        if (value == null) {
            values.put(key, longUrl);

        }
        return key;
    }
}
