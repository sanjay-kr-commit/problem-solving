
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
    ArrayList<String> alerted = new ArrayList<>();
    for (int i = 0; i < keyTime.length; i++) {
      if (!hashMap.containsKey(keyName[i]))
        hashMap.put(keyName[i], new ArrayList<>());
      hashMap.get(keyName[i]).add(time(keyTime[i]));
    }
    for (Map.Entry<String, ArrayList<Integer>> entry : hashMap.entrySet()) {
      if (entry.getValue().size() < 3)
        continue;
      Collections.sort(entry.getValue());
      for (int i = 0, len = entry.getValue().size() - 2; i < len; i++) {
        if (entry.getValue().get(i + 2) - entry.getValue().get(i) < 61) {
          alerted.add(entry.getKey());
          break;
        }
      }
    }
    Collections.sort(alerted);
    return alerted;
  }

  int time(String s) {
    int time = 0;
    time += s.charAt(0) - '0';
    time *= 10;
    time += s.charAt(1) - '0';
    time *= 60;
    time += ((s.charAt(3) - '0') * 10) + (s.charAt(4) - '0');
    return time;
  }

}