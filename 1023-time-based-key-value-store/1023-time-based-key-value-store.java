import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimeMap {

    class Data {
        String val;
        int time;
        Data(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    
    Map<String, List<Data>> map = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Data>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Data> list, int time) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (time < list.get(mid).time) right = mid - 1;
            else left = mid;
        }
        return list.get(left).time <= time ? list.get(left).val : "";
    }
}