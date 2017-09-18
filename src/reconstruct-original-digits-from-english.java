import java.net.Socket;
import java.util.*;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
    public String originalDigits(String s) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray()) {
            Integer count = charMap.get(c);
            if (count == null)
                count = 1;
            else
                count++;
            charMap.put(c, count);
        }
        //zero
        zero(charMap, resultMap);
        //two
        two(charMap, resultMap);
        //six
        six(charMap,resultMap);
        //eight
        eight(charMap, resultMap);
        //three
        three(charMap, resultMap);
        //seven
        seven(charMap, resultMap);
        //five
        five(charMap, resultMap);
        //four
        four(charMap, resultMap);
        //one
        one(charMap, resultMap);
        //nine
        nine(charMap, resultMap);

//        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet())
//            System.out.println(entry.getKey() + " " + entry.getValue());

        return build(resultMap);
    }

    private String build(Map<Integer, Integer> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i ++) {
            Integer c = resultMap.get(i);
            if (c != null) {
                for (int j = 1; j <= c; j++)
                    sb.append(i);
            }
        }
        return sb.toString();
    }

    private void nine(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer ic = charMap.get('i');
        if (ic != null && ic > 0) {
            addToMap(resultMap, 9, ic);
        }
    }
    private void zero(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer zc = charMap.get('z');
        if (zc != null && zc > 0) {
            addToMap(resultMap, 0, zc);
            charMap.remove('z');
            Integer ec = charMap.get('e');
            charMap.put('e', ec -  zc);
            Integer rc = charMap.get('r');
            charMap.put('r', rc - zc);
            Integer oc = charMap.get('o');
            charMap.put('o', oc - zc);
        }
    }
    private void one(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer oc = charMap.get('o');
        if (oc != null && oc > 0) {
            addToMap(resultMap, 1, oc);
            charMap.remove('o');
            Integer nc = charMap.get('n');
            charMap.put('n', nc -  oc);
            Integer ec = charMap.get('e');
            charMap.put('e', ec - oc);
        }
    }
    private void four(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer fc = charMap.get('f');
        if (fc != null && fc > 0) {
            addToMap(resultMap, 4, fc);
            charMap.remove('f');
            Integer oc = charMap.get('o');
            charMap.put('o', oc -  fc);
            Integer uc = charMap.get('u');
            charMap.put('u', uc - fc);
            Integer rc = charMap.get('r');
            charMap.put('r', rc - fc);
        }
    }
    private void five(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer vc = charMap.get('v');
        if (vc != null && vc > 0) {
            addToMap(resultMap, 5, vc);
            charMap.remove('v');
            Integer fc = charMap.get('f');
            charMap.put('f', fc -  vc);
            Integer ic = charMap.get('i');
            charMap.put('i', ic - vc);
            Integer ec = charMap.get('e');
            charMap.put('e', ec - vc);
        }
    }
    private void seven(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer sc = charMap.get('s');
        if (sc != null && sc > 0) {
            addToMap(resultMap, 7, sc);
            charMap.remove('s');
            Integer ec = charMap.get('e');
            charMap.put('e', ec -  sc* 2);
            Integer vc = charMap.get('v');
            charMap.put('v', vc - sc);
            Integer nc = charMap.get('n');
            charMap.put('n', nc - sc);
        }
    }
    private void three(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer hc = charMap.get('h');
        if (hc != null && hc > 0) {
            addToMap(resultMap, 3, hc);
            charMap.remove('h');
            Integer tc = charMap.get('t');
            charMap.put('t', tc - hc);
            Integer rc = charMap.get('r');
            charMap.put('r', rc - hc);
            Integer ec = charMap.get('e');
            charMap.put('e', ec - hc * 2);
        }
    }
    private void eight(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer gc = charMap.get('g');
        if (gc != null && gc > 0) {
            addToMap(resultMap, 8, gc);
            charMap.remove('g');
            Integer ec = charMap.get('e');
            charMap.put('e', ec - gc);
            Integer ic = charMap.get('i');
            charMap.put('i', ic - gc);
            Integer hc = charMap.get('h');
            charMap.put('h', hc - gc);
            Integer tc = charMap.get('t');
            charMap.put('t', tc - gc);
        }
    }
    private void six(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer xc = charMap.get('x');
        if (xc != null && xc > 0) {
            addToMap(resultMap, 6, xc);
            charMap.remove('x');
            Integer ic = charMap.get('i');
            charMap.put('i', ic - xc);
            Integer sc = charMap.get('s');
            charMap.put('s', sc - xc);
        }
    }

    private void two(Map<Character, Integer> charMap, Map<Integer, Integer> resultMap) {
        Integer wc = charMap.get('w');
        if (wc != null && wc > 0) {
            addToMap(resultMap, 2, wc);
            charMap.remove('w');
            Integer tc = charMap.get('t');
            charMap.put('t', tc - wc);
            Integer oc = charMap.get('o');
            charMap.put('o', oc - wc);
        }
    }

    private void addToMap(Map<Integer, Integer> map, Integer key, Integer value) {
        Integer count = map.get(key);
        if (count == null)
            count = 0;
        count += value;
        map.put(key, count);
    }
}