package leetcode.BackTracking.FindItinerary;

import java.util.*;

public class FIPer {

    private List<String> ans = new ArrayList<>();
    private Map<String, Map<String, Integer>> targets = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        ans.add("JFK");
        for (List<String> list: tickets) {
            String from = list.get(0);
            String to = list.get(1);
            if(!targets.containsKey(from)){
                Map<String, Integer> temp = new TreeMap<>(new MapKeyComparator());
                temp.put(to, 1);
                targets.put(from, temp);
            } else {
                if(!targets.get(from).containsKey(to)){
                    Map<String, Integer> temp = targets.get(from);
                    temp.put(to, 1);
                    targets.put(from, temp);
                }else {
                    Map<String, Integer> temp = targets.get(from);
                    temp.put(to, temp.get(to) + 1);
                    targets.put(from, temp);
                }
                }
        }
        backtracking(tickets.size(), ans);
        return ans;
    }

    private Boolean backtracking(int ticketNum, List<String> ans) {
        if(ans.size() == ticketNum + 1){
            return true;
        }
        if(targets.get(ans.get(ans.size() - 1)) != null){
        Map<String, Integer> map =  targets.get(ans.get(ans.size() - 1));

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 0){
                ans.add(entry.getKey());
                map.put(entry.getKey(), entry.getValue() - 1);
                if(backtracking(ticketNum, ans)) return true;
                ans.remove(ans.size() - 1);
                map.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = Arrays.asList("EZE","AXA");
        List<String> t2 = Arrays.asList("TIA","ANU");
        List<String> t3 = Arrays.asList("ANU","JFK");
        List<String> t4 = Arrays.asList("JFK","ANU");
        List<String> t5 = Arrays.asList("ANU","EZE");
        List<String> t6 = Arrays.asList("TIA","ANU");
        List<String> t7 = Arrays.asList("AXA","TIA");
        List<String> t8 = Arrays.asList("TIA","JFK");
        List<String> t9 = Arrays.asList("ANU","TIA");
        List<String> t0 = Arrays.asList("JFK","TIA");
        tickets.add(t1);
        tickets.add(t2);
        tickets.add(t3);
        tickets.add(t4);
        tickets.add(t5);
        tickets.add(t6);
        tickets.add(t7);
        tickets.add(t8);
        tickets.add(t9);
        tickets.add(t0);
        FIPer f = new FIPer();
        System.out.println(f.findItinerary(tickets));

    }


}

class MapKeyComparator implements Comparator<String>{

    @Override
    public int compare(String str1, String str2) {

        return str1.compareTo(str2);
    }
}