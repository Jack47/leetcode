package Trie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileSystemTest {
    @Test
    public void test() {
        FileSystem fs = new FileSystem();
        boolean created = fs.create("/a", 1);
        assertEquals(true, created);

        Integer v = fs.get("/a");
        assertEquals(new Integer(1), v);

        created = fs.create("/a/b", 2);
        assertEquals(true, created);

        v = fs.get("/a/b");
        assertEquals(new Integer(2), v);

        created = fs.create("/c/d", 2);
        assertEquals(false, created);

        v = fs.get("/c");
        assertEquals(null, v);

        boolean set = fs.set("/a/b", 3);
        assertEquals(true, set);
        v = fs.get("/a/b/");
        assertEquals(new Integer(3), v);

        fs.watch("/a", new Runnable() {
            @Override
            public void run() {
                System.out.println("yes");
            }
        });
         fs.watch("/a/b", new Runnable() {
            @Override
            public void run() {
                System.out.println("no");
            }
        });
         fs.create("/a/b/c", 2);
    }
}
