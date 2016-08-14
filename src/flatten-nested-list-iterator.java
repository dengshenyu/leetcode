import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private List<Integer> list;
        private Iterator<Integer> it;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new LinkedList<>();
            for (NestedInteger i : nestedList)
                list.addAll(getInteger(i));
            it = list.iterator();
        }

        private List<Integer> getInteger(NestedInteger nestedInteger) {
            List<Integer> list = new LinkedList<>();
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> nestedIntegers = nestedInteger.getList();
                for (NestedInteger i : nestedIntegers)
                    list.addAll(getInteger(i));
            }
            return list;
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }
    }

    public static void main(String[] args) {
    }
}