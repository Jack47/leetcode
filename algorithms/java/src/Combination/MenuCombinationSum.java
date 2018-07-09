package Combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MenuCombinationSum {

    // Given a menu (list of items prices), find all
    // possible combinations of items that sum a particular value K.
    List<List<Double>> results;
    List<Double> prices;
    List<Integer> pricesInt;
    List<List<Double>> getCombos(List<Double> prices, double target) {
        results = new LinkedList<>();
        this.prices = prices;
        dfs(0, target, new LinkedList<>());
        return results;
    }

    void dfs(int i, double target, List<Double> result) {
        if(Math.abs(target) <= 0.0001) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (i >= prices.size()) {
            return;
        }
        // don't include prices[i]
        dfs(i+1, target, result);
        int k = 1;
        double curPrice = 1;
        // contain k instance of prices[i]
        while(k*prices.get(i) <= target) {
            curPrice = k*prices.get(i);
            result.add(prices.get(i));
            dfs(i + 1, target - curPrice, result);
            k++;
        }
        while(k > 1) {
            result.remove(result.size()-1);
            k--;
        }
    }

    List<List<Double>> getCombosDP(List<Double> prices, double target) {
        // dp[i][j] stores the combination that
        int targetInt = (int) Math.floor(target * 100);
        Collections.sort(prices);
        List<List<Double>>[][] dp = new List[prices.size()][targetInt+1];
        pricesInt = new ArrayList<>(prices.size());
        for(Double d : prices) {
            pricesInt.add((int)(d*100));
        }

        for(int k = 0; k < prices.size(); k++) {
            // 0 price is always available
           dp[k][0] = new LinkedList<>();
        }

        List<Double> result = new ArrayList<>(); // keep track of current result
        int i = 1; // corner case
        while (pricesInt.get(0) * i <= targetInt) {
            int price = pricesInt.get(0) * i;
            result.add(prices.get(0)); // append one element
            dp[0][price] = new ArrayList<>();
            dp[0][price].add(new ArrayList<>(result));
            i++;
        }

        for (int k = 1; k < prices.size(); k++) {
            for (int j = 0; j <= targetInt;j++) {
                dp[k][j] = dp[k-1][j]; // don't include prices[k]
            }
            for( int p = pricesInt.get(k); p <= targetInt; p++) {
                for (int j = p / pricesInt.get(k); j >= 1; j--) {
                    if (dp[k - 1][p - j * pricesInt.get(k)] != null) { // previous condition exists
                        List<List<Double>> t = new ArrayList<>(dp[k - 1][p - j * pricesInt.get(k)]);
                        List<Double> toAdd = new ArrayList<>(j);
                            int n = j;
                            while (n > 0) {
                                n--;
                                toAdd.add(prices.get(k));
                            }
                        for (List<Double> l : t) {
                            l.addAll(new ArrayList<>(toAdd));
                        }
                        if (dp[k][p] != null) {
                                dp[k][p].addAll(t);
                        } else {
                            dp[k][p] = t;
                        }
                    }
                }
            }
        }
        return dp[prices.size() - 1][targetInt];
    }
}
