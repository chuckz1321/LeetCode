package ByteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-09
 */
public class LogSystem {
    private Map<Integer, Integer> idMap;
    private Map<Integer, Integer> timeMap;

    public LogSystem() {
        idMap = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void add(int id, int timeStamp) {
        idMap.put(id, timeStamp);
        if (timeMap.containsKey(timeStamp)) {
            timeMap.put(timeStamp, timeMap.get(timeStamp) + 1);
        } else {
            timeMap.put(timeStamp, 1);
        }
    }

    public int delete(int id) {
        if (idMap.containsKey(id)) {
            timeMap.put(idMap.get(id), timeMap.get(idMap.get(id)) - 1);
            if (timeMap.get(idMap.get(id)) == 0) {
                timeMap.remove(idMap.get(id));
            }
            idMap.remove(id);

            return 0;
        } else {
            return -1;
        }
    }

    public int query(int startTime, int endTime) {
        int count = 0;
        for (int i = startTime; i <= endTime; i++) {
            if (timeMap.containsKey(i)) {
                count += timeMap.get(i);
            }
        }
        return count;
    }
}
