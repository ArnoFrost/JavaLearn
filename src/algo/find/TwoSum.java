package algo.find;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArnoFrost
 * @date 2020/4/11 21:07
 * @since 1.0
 */
public class TwoSum {

    /**
     * Initialize your data structure here.
     */
    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer integer : map.keySet()) {
            int need = value - integer;
            if (map.containsKey(need) && (need != integer || map.get(need) > 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
