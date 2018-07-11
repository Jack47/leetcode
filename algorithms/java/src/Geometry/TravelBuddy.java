package Geometry;

import java.util.*;

public class TravelBuddy {
    List<Buddy> buddys;
    Set<String> myWishList;

    int getSimilarity(Set<String> my, Set<String> other) {
        int count = 0;
        for(String s : other) {
            if(my.contains(s)) {
                count++;
            }
        }
        return count*100/my.size();
    }
    // find all travel buddys who has at least half travel list same with you.
    public List<Buddy> getSortedBuddies(Set<String> myWithList, Map<String, Set<String>> friendsWishList) {
        buddys = new LinkedList<>();
        for(Map.Entry<String, Set<String>> entry : friendsWishList.entrySet()) {
            int sim = getSimilarity(myWithList, entry.getValue());
            if(sim >= 50) {
                buddys.add(new Buddy(entry.getKey(), entry.getValue(), sim));
            }
        }
        this.myWishList = myWithList;
        Collections.sort(buddys, (a,b)->(a.similarity - b.similarity));
        return buddys;
    }

    public List<String> recommendedCities(int k) {
        List<String> result = new ArrayList<>(k);
        TreeSet<Integer> visited = new TreeSet<>();

        Iterator<Buddy> iter = buddys.iterator();
        while(k > 0 && iter.hasNext()) {
            TreeSet<String> candidates = new TreeSet<>(iter.next().wishList);
            candidates.removeAll(myWishList);
            if(candidates.size() <= k) {
                result.addAll(candidates);
                k -= candidates.size();
            } else {
                Iterator<String> cit = candidates.iterator();
                while(k > 0) {
                    result.add(cit.next());
                }
                break;
            }
        }
        return result;
    }

    public static class Buddy {
        String name;
        int similarity;
        Set<String> wishList;
        public Buddy(String name, Set<String> wishList, int similarity) {
            this.name = name;
            this.similarity = similarity;
            this.wishList = wishList;
        }
    }
}
