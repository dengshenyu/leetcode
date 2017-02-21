/**
 * Created by shenyuan on 17/2/22.
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int nonDashes = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-')
                nonDashes++;
        }
        int firstGroup = nonDashes % K;
        int normalGroupCount = nonDashes / K;
        int i = 0;
        if (firstGroup != 0) {
            while (firstGroup-- > 0) {
                i = getFirstNonDash(S, i);
                if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
                    sb.append((char)(S.charAt(i) - 32));
                else
                    sb.append(S.charAt(i));
                i++;
            }
            sb.append('-');
        }

        for (int j = 0; j < normalGroupCount; j++) {
            for (int k = 0; k < K; k++) {
                i = getFirstNonDash(S, i);
                if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z')
                    sb.append((char)(S.charAt(i) - 32));
                else
                    sb.append(S.charAt(i));
                i++;
            }
            sb.append('-');
        }

        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private int getFirstNonDash(String s, int i) {
        while (s.charAt(i) == '-')
            i++;
        return i;
    }
}