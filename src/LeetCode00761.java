import java.util.HashMap;
import java.util.Map;

public class LeetCode00761 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        final int n = nums1.length;
        final Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < n; ++i) {
            final int value = nums2[i];
            if (!map.containsKey(value)) {
                map.put(value, i);
            }
        }
        final int[] result = new int[n];
        for(int i = 0; i < n; ++i) {
            final int value = nums1[i] ;
            result[i] = map.get(value);
        }
        return result;
    }
}
