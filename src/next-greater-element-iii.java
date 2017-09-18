import java.net.Socket;
import java.util.*;

/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public int nextGreaterElement(int n) {
        int[] num = new int[20];
        int size = 0;
        while (n > 0) {
            num[size++] = n % 10;
            n /= 10;
        }
        for (int i = 0; i < size; i++) {
            if (i + 1 < size && num[i] > num[i+1]) {
                int j;
                for (j = i; j >= 0;) {
                    if (num[j] > num[i+1])
                        j--;
                    else
                        break;
                }
                j++;
                int tmp = num[i+1];
                num[i+1] = num[j];
                num[j] = tmp;
                int p = 0, q = i;
                while (p < q) {
                    tmp = num[p];
                    num[p] = num[q];
                    num[q] = tmp;
                    p++;
                    q--;
                }
                long result = 0;
                long priority = 1;
                for (int t = 0; t < size; t++) {
                    result += priority * num[t];
                    priority *= 10;
                }
                if (result > Integer.MAX_VALUE)
                    return -1;
                else
                    return (int)result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(1999999999));
    }
}