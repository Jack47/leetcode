package BitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPtoCIDR {
    int zeroCountFromRight(long x) {
        int i = 0;
        int n = 1;
        while ((x & n) == 0) {
            i++;
            n *= 2;
        }
        return i;
    }

    String cidr(long ip, int n) {
        int shift = 24;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.toString((int) ((ip >>> shift) & 0xff)));
            sb.append(".");
            shift -= 8;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("/" + Integer.toString(32 - n));
        return sb.toString();
    }

    long ip2long(String ip) { // use long to regard ip as unsigned integer
        String[] parts = ip.split("\\.");
        long n = 0;
        int shift = 0;
        for (int i = 3; i >= 0; i--) {
            n |= ((long) Integer.parseInt(parts[i])) << shift;
            shift += 8;
        }
        return n;
    }

    public List<String> ipToCIDR(String ip, int n) {
        long startIp = ip2long(ip);
        List<String> result = new ArrayList<>();
        if (n <= 0) return Collections.emptyList();
        while(n > 0) {
            int zeroCount = zeroCountFromRight(startIp);
            // how many numbers can be represented
            int max = 1 << zeroCount; // power of 2
            int size = max >= n ? n : max;
            if(size == 1) {
                result.add(cidr(startIp, 0));
                startIp += 1;
                n-=1;
                continue;
            }
            if(size == max) {
                result.add(cidr(startIp, zeroCount));
                startIp += size;
                n -= size;
                continue;
            }
            int count = 0;
            while (count < size) {
                if (((1 << (zeroCount-1)) & size) > 0) {
                    result.add(cidr(startIp, (zeroCount-1)));
                    count += 1 << (zeroCount-1);
                    startIp += 1 << (zeroCount-1);
                }
                // traverse all the available bits
                zeroCount--;
            }
            n -= size;
        }
        return result;
    }
    public List<String> ipToCIDRS(String ip, int n) {
        long startIp = ip2long(ip);
        List<String> result = new ArrayList<>();
        if (n <= 0) return Collections.emptyList();
        long endIp = startIp + n -1;
        while(startIp <= endIp) {
           long firstOneFromRight = startIp & (-startIp);
           // log2^(firstOneFromRight)
            // 10 => 1
           int mask = (int)(Math.log(firstOneFromRight)/Math.log(2));
           int needMask = (int)(Math.log(endIp-startIp+1)/Math.log(2));
           int curMask = Math.min(mask, needMask);
           result.add(cidr(startIp, curMask));
           startIp += Math.pow(2, curMask);
        }
        return result;
    }
}
