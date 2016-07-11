import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    static public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    static public class SummaryRanges {
        private ArrayList<Interval> ranges;

        /** Initialize your data structure here. */
        public SummaryRanges() {
            ranges = new ArrayList<Interval>();
        }

        public void addNum(int val) {
            if (ranges.isEmpty()) {
                ranges.add(new Interval(val, val));
                return;
            }

            int left = 0, right = ranges.size() - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (ranges.get(middle).start <= val && ranges.get(middle).end >= val) {
                    return;
                } else if (ranges.get(middle).start > val) {
                    if (ranges.get(middle).start == val + 1) {
                        ranges.get(middle).start--;
                        if (middle - 1 >= 0 && ranges.get(middle-1).end == val - 1) {
                            ranges.get(middle).start = ranges.get(middle-1).start;
                            ranges.remove(middle-1);
                        }
                        return;
                    } else if (middle - 1 >= 0 && ranges.get(middle-1).end < val) {
                        if (ranges.get(middle-1).end == val - 1) {
                            ranges.get(middle-1).end++;
                        } else {
                            ranges.add(middle, new Interval(val, val));
                        }
                        return;
                    } else if (middle - 1 < 0) {
                        ranges.add(0, new Interval(val, val));
                        return;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if (ranges.get(middle).end == val - 1) {
                        ranges.get(middle).end++;
                        if (middle + 1 < ranges.size() && ranges.get(middle+1).start == val + 1) {
                            ranges.get(middle).end = ranges.get(middle+1).end;
                            ranges.remove(middle+1);
                        }
                        return;
                    } else if (middle + 1 < ranges.size() && ranges.get(middle+1).start > val) {
                        if (ranges.get(middle+1).start == val + 1) {
                            ranges.get(middle+1).start--;
                        } else {
                            ranges.add(middle+1, new Interval(val, val));
                        }
                        return;
                    } else if (middle + 1 == ranges.size()) {
                        ranges.add(ranges.size(), new Interval(val, val));
                        return;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }

        public List<Interval> getIntervals() {
            return ranges;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 7, 2, 6};
        SummaryRanges ranges = new SummaryRanges();
        for (int i : a) {
            ranges.addNum(i);
            for (Interval interval : ranges.getIntervals()) {
                System.out.print(interval.start + "," + interval.end + " ");
            }
            System.out.println();
        }
    }
}