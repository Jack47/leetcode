package BreadthFirstSearch;

import java.util.HashMap;

public class StickersToSpellWord {
    // apply stickers[i] to reduce target
    String reduce(int k, String target) {
        int[] tar = new int[26];
        for (char ch : target.toCharArray()) {
            tar[ch - 'a']++;
        }
        int[] sticker = stickers[k];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            tar[i] = sticker[i] >= tar[i] ? 0 : tar[i] - sticker[i];
            while (tar[i] > 0) {
                sb.append((char)(i + 'a'));
                tar[i]--;
            }
        }
        return sb.toString();
    }

    HashMap<String, Integer> cache;

    int bfs(String target) {
        if (target.isEmpty()) return 0;
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < this.stickers.length; i++) {
            char ch = target.charAt(0);
            // Prune: skip the stickers that don't contain letters in the target
            // and this will prevent the stack overflow
            if (stickers[i][ch - 'a'] == 0) continue;
            String reducedStr = reduce(i, target);
            int next = bfs(reducedStr);
            min = next != -1 ? Math.min(min, next) : min;
            if (next != -1) {
                min = Math.min(min, next);
            }
        }
        int ret = (min == -1 || min == Integer.MAX_VALUE) ? -1 : min + 1;
        cache.put(target, ret);
        return ret;
    }

    int[][] stickers;

    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        cache = new HashMap<>();
        this.stickers = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (char ch : stickers[i].toCharArray()) {
                this.stickers[i][ch - 'a']++;
            }
        }
        return bfs(target);
    }
}
