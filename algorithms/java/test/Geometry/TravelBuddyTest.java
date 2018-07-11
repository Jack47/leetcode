package Geometry;

import org.junit.Test;

import java.util.*;

public class TravelBuddyTest {
    @Test
    public void test(){
        TravelBuddy tb = new TravelBuddy();
        Set<String> myWishList = new HashSet<>();
        myWishList.add("a");
        myWishList.add("b");
        myWishList.add("c");

        Map<String, Set<String>> othersWishList = new HashMap<>();
        Set<String> otherWishList = new HashSet<>();
        otherWishList.add("d");
        otherWishList.add("b");
        othersWishList.put("2", otherWishList);

        otherWishList = new HashSet<>();
        otherWishList.add("a");
        otherWishList.add("c");
        othersWishList.put("3", otherWishList);

        otherWishList = new HashSet<>();
        otherWishList.add("d");
        otherWishList.add("c");
        othersWishList.put("4", otherWishList);

        List<TravelBuddy.Buddy> real = tb.getSortedBuddies(myWishList, othersWishList);
        List<TravelBuddy.Buddy> expected = new ArrayList<>(1);
        Set<String> withList = new HashSet<>();
        withList.add("a");
        withList.add("c");

        expected.add(new TravelBuddy.Buddy("3", withList, 100*2/3));
        // assertEquals(expected, real);
        List<String> cities = tb.recommendedCities(3);
        cities = tb.recommendedCities(1);
    }
}
