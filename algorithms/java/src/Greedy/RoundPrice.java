package Greedy;

import java.util.PriorityQueue;

public class RoundPrice {
    // round prices, return the rounded prices
    // round prices such that :
    // round(sum(prices)) == sum(round(prices))
    // Choose the solution that makes  sum(delta(prices[i], round(prices[i]))
    // minimize.
    class FloatPrice implements Comparable<FloatPrice> {
        float price; // point_price
        int i;
        public FloatPrice(float pointPrice, int i) {
            this.price = pointPrice;
            this.i = i;
        }

        @Override
        public int compareTo(FloatPrice o) {
            if(this.price < o.price) {
                return +1;
            } else if (this.price > o.price) {
                return -1;
            } else  return 0;
        }
    }

    int[] round(float[] prices) {
        float fsum = 0;
        int isum = 0;
        int[] ret = new int[prices.length];

        // min-gap heap
        // max-point-price heap
        PriorityQueue<FloatPrice> pq = new PriorityQueue<>();
        for (int i = 0; i < prices.length; i++) {
            ret[i] = (int) prices[i]; // floor to nearest int
            fsum += prices[i];
            isum += ret[i];
            pq.add(new FloatPrice(fsum-isum, i));
        }
        int roundedSum = Math.round(fsum);
        // roundedSum must >= isum
        int delta = roundedSum - isum;
        while (delta > 0) {
            FloatPrice fp = pq.poll();
            ret[fp.i]++; // ceil these
            delta--;
        }
        return ret;
    }
}
