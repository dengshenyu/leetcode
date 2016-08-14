import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public boolean dfs(Map<String, ArrayList<String>> fromTos, String dest, List<String> itineraries) {
        if (!fromTos.containsKey(dest)) {
            if (fromTos.isEmpty())
                return true;
            else
                return false;
        }

        ArrayList<String> tos = fromTos.get(dest);
        for (int i = 0; i < tos.size(); i++) {
            String to = tos.get(i);
            itineraries.add(to);
            tos.remove(i);
            if (tos.isEmpty())
                fromTos.remove(dest);
            if (dfs(fromTos, to, itineraries))
                return true;
            tos.add(i, to);
            if (tos.size() == 1)
                fromTos.put(dest, tos);
            itineraries.remove(itineraries.size() - 1);
        }

        return false;
    }
    public List<String> findItinerary(String[][] tickets) {
        List<String> itineraries = new LinkedList<>();
        Map<String, ArrayList<String>> fromTos = new HashMap<>();
        for (String[] arr : tickets) {
            ArrayList<String> list = fromTos.get(arr[0]);
            if (list == null) {
                list = new ArrayList<>();
                fromTos.put(arr[0], list);
            }
            int i = 0;
            for (i = 0; i < list.size(); i++) {
                if (list.get(i).compareTo(arr[1]) >= 0) {
                    list.add(i, arr[1]);
                    break;
                }
            }
            if (i == list.size()) {
                list.add(arr[1]);
            }
        }

        itineraries.add("JFK");
        dfs(fromTos, "JFK", itineraries);
        return itineraries;
    }

    public static void main(String[] args) {
        for (String s : new Solution().findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}))
            System.out.println(s);
    }
}