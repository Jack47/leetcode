package TinyURL;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CodecTest {
    @Test
    public void test() {
        Codec codec = new Codec();
        String longUrl = "cnblogs.com/";
        String shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));

        longUrl = "http://cnblogs.com/";
        shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));

        longUrl = "http://tinyurl.com/4e9iAk";
        shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));

        longUrl = "http://tinyurl.com/4e9iAk";
        shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));

        longUrl = "cnblogs.com/Jack47";
        shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));

        longUrl = "github.com/Jack47";
        shortUrl = codec.encode(longUrl);
        System.out.println(shortUrl);
        assertEquals(longUrl, codec.decode(shortUrl));
    }
}
