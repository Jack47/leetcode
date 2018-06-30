package StringRelated;

import java.util.*;

public class AccountsMerge {
    int[] roots;

    int findRoot(int i) {
        while (roots[i] != i) {
            i = roots[i];
        }
        return i;
    }

    void union(int p, int q) {
        int pr = findRoot(p);
        int qr = findRoot(q);
        roots[qr] = pr;
    }
    HashMap<Integer, Set<Integer>> findAll() {
        HashMap<Integer, Set<Integer>> ret = new HashMap<>();
        for(int i = 0; i < roots.length; i++) {
            int r = findRoot(i);
            Set<Integer> s = ret.getOrDefault(r, new HashSet<Integer>());
            s.add(i);
            ret.put(r, s);
        }
        return ret;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailIndex = new HashMap<>();
        HashMap<Integer, String> indexEmail = new HashMap<>();
        HashMap<Integer, String> emailIndexAccount = new HashMap<>();
        int count = 0;
        // email -> Index
        // index -> account
        for (List<String> account : accounts) {
            List<String> emails = account.subList(1, account.size());
            for (String email : emails) {
                if (!emailIndex.containsKey(email)) {
                    emailIndex.put(email, count);
                    indexEmail.put(count, email);
                    emailIndexAccount.put(count, account.get(0));
                    count++;
                }
            }
        }
        roots = new int[emailIndex.size()];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (List<String> account : accounts) {
            List<String> emails = account.subList(1, account.size());
            int p = emailIndex.get(emails.get(0));
            for(int k = 1; k < emails.size(); k++) {
                int q = emailIndex.get(emails.get(k));
                union(p, q);
            }
        }
        HashMap<Integer, Set<Integer>> ret = findAll();
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, Set<Integer>> entry : ret.entrySet()) {
            int root = entry.getKey();

            String account = emailIndexAccount.get(root);
            TreeSet<String> record = new TreeSet<>();
            for(Integer k : entry.getValue()) {
                record.add(indexEmail.get(k));
            }
            List<String> r = new ArrayList<>(record);
            r.add(0, account);
            result.add(r);
        }
        return result;
    }
}
