package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-28
 */
public class DisClose {
    public int maxDistToClosest(int[] seats) {
        int[] length = new int[seats.length];
        int bigIndex = 0;
        int l = 0;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 1) {
                length[i] = 0;
            }
            if(seats[i] == 0 && i > 0) {
                length[i] = seats[i-1] == 0 ? length[i-1] + 1 : 1;
                if(length[i] > l) {
                    l = length[i];
                    bigIndex = i;
                }
            }
            if (seats[i]==0 && i==0) {
                length[i] = 1;
                if(length[i] > l) {
                    l = length[i];
                    bigIndex = i;
                }
            }
        }
        if(bigIndex == seats.length - 1 || bigIndex - l < 0) return l;
        if (l%2 ==0) return l /2 -1;
        return l / 2 + 1;
    }

    public static void main(String[] args) {
        String esn = "2102351HND10H2200002";
        UUID uuid = UUID.randomUUID();
        System.out.println(System.currentTimeMillis());
        System.out.println(uuid);
        System.out.println(esn.substring(2, 10));
    }
}
