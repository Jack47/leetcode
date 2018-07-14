package Trie;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    class Trie {
        Trie[] nodes;
        // value is valid when isDir = true
        boolean isDir;
        int value;
        // callback is valid when isDir = true
        Runnable callback;
        public Trie() {
            nodes = new Trie[26]; // 26th is '/'
            isDir = false;
            value = 0;
            callback = null;
        }
        public boolean set(String path, int value, boolean isAdd) {
            Trie cur = this;
            String[] paths = path.split("/");
            List<Runnable> callbacks =  new ArrayList<>(paths.length-1);
            for(int i = 1; i < paths.length;i++) {
                for(char ch : paths[i].toCharArray()) {
                    if(cur.nodes[ch-'a'] == null) {
                        if(isAdd) { // add the last part
                            if (i < paths.length - 1) {
                                return false;
                            }
                            cur.nodes[ch - 'a'] = new Trie();
                        } else {
                            return false;
                        }
                    }
                    cur = cur.nodes[ch-'a'];
                }
                if(cur.isDir && cur.callback != null) {
                    callbacks.add(cur.callback);
                }
            }
            cur.isDir = true;
            cur.value = value;
            for(Runnable c : callbacks) {
                c.run();
            }
            return true;
        }
        public Integer get(String path) {
            Trie cur = this;
            String[] paths = path.split("/");
            for(int i = 0; i < paths.length;i++) {
                for(char ch : paths[i].toCharArray()) {
                    if (cur.nodes[ch - 'a'] == null) {
                        return null;
                    }
                    cur = cur.nodes[ch-'a'];
                }
            }
            return cur.value;
        }
        public boolean addCallback(String path, Runnable c) {
            Trie cur = this;
            String[] paths = path.split("/");
            for(int i = 0; i < paths.length;i++) {
                for(char ch : paths[i].toCharArray()) {
                    cur = cur.nodes[ch-'a'];
                    if(cur == null) return false;
                }
            }
            assert cur.isDir == true;
            cur.callback = c;
            return true;
        }
    }
    Trie root;
    public FileSystem() {
        root = new Trie();
    }
    public boolean create(String path, int value) {
        return root.set(path, value, true /* isAdd */);
    }
    public boolean set(String path, int value) {
       return root.set(path, value, false /* isAdd */);
    }
    public Integer get(String path) {
        return root.get(path);
    }
    public boolean watch(String path, Runnable callback) {
        return root.addCallback(path, callback);
    }
}
