package BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPtoCIDR {
    int zeroCountFromRight(long x) {
       int i = 0;
       int n = 1;
       while((x & n) == 0) {
           i++;
           n*=2;
       }
       return i;
    }

    String cidr(long ip, int n) {
        int shift = 24;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++) {
           sb.append(Integer.toString((int)((ip >>> shift) & 0xff)));
           sb.append(".");
           shift -= 8;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("/"+Integer.toString(32-n));
        return sb.toString();
    }

    long ip2long(String ip) { // use long to regard ip as unsigned integer
        String[] parts = ip.split("\\.");
        long n = 0;
        int shift = 0;
        for (int i = 3; i >=0; i--) {
            n |= ((long)Integer.parseInt(parts[i])) << shift;
            shift += 8;
        }
        return n;
    }

    public List<String> ipToCIDR(String ip, int n) {
       long startIp = ip2long(ip);
       List<String> result = new ArrayList<>();
       if((startIp & 0x01) != 0) {// is odd
          result.add(cidr(startIp, 0)); // only 1 element, 2^0
          n--;
          startIp++;
       }
       result.addAll(factor(startIp, n));
       return result;
    }

    List<String> factor(long start, int n) {
        if (n <= 0) return Collections.emptyList();
        int zeroCount = zeroCountFromRight(start);
        int max = 1 << zeroCount; // power of 2
        int size = max >=n ? n : max;
        List<String> result = new ArrayList<>(size);
        int count = 0;
        while(count < size) { // traverse all the available bits
            if(((1 << zeroCount) & size) > 0) {
               result.add(cidr(start, zeroCount));
               count += 1 << zeroCount;
               start += 1 << zeroCount;
            }
            zeroCount--;
        }
        result.addAll(factor(start, n-max));
        return result;
    }
}
