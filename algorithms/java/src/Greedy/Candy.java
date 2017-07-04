package Greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) return ratings.length;
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for(int i=1; i <= ratings.length-1; i++) {
            if(ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1]+1;
            }
        }
        for(int i = ratings.length-2; i>=0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candy[i] = Math.max(candy[i], candy[i+1]+1);
            }
        }
        int result = 0;
        for(int c : candy) {
            result += c;
        }
        return result;
    }
}
