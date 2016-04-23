import java.util.*;

/**
 * Created by shenyuan on 16/3/12.
 */

public class Solution {
    class Line {
        int lx, ly;
        int rx, ry;
        Line(int lx, int ly, int rx, int ry) {
            this.lx = lx;
            this.ly = ly;
            this.rx = rx;
            this.ry = ry;
        }

    }
    public boolean isSelfCrossing(int[] x) {
        if (x.length < 4)
            return false;
        LinkedList<Line> lines = new LinkedList<>();
        int cx = 0, cy = 0;
        int ex, ey;
        int d = 0; //0up, 1left, 2down, 3right
        for (int m : x) {
            ex = cx;
            ey = cy;
            Line curLine;
            if (d == 0) {
                ey += m;
                curLine = new Line(cx, cy, ex, ey);
            } else if (d == 1) {
                ex -= m;
                curLine = new Line(ex, ey, cx, cy);
            } else if (d == 2) {
                ey -= m;
                curLine = new Line(ex, ey ,cx, cy);
            } else {
                ex += m;
                curLine = new Line(cx, cy ,ex, ey);
            }
            Iterator<Line> it = lines.iterator();
            if (it.hasNext())
                it.next();
            while (it.hasNext()) {
                if (cross(it.next(), curLine))
                    return true;
            }
            lines.addFirst(curLine);
            if (lines.size() > 8)
                lines.removeLast();
            d = (d + 1) % 4;
            cx = ex;
            cy = ey;
        }
        return false;
    }

    private boolean cross(Line a, Line b) {
        if (a.lx == a.rx && b.ly == b.ry && (a.lx >= b.lx && a.lx <= b.rx) && (b.ly >= a.ly && b.ly <= a.ry) )
            return true;
        else if (b.lx == b.rx && a.ly == a.ry && (b.lx >= a.lx && b.lx <= a.rx) && (a.ly >= b.ly && a.ly <= b.ry))
            return true;
        else if (a.lx == a.rx && b.lx == b.rx && a.lx == b.lx && (a.ry >= b.ly && a.ry <= b.ry || b.ry >= a.ly && b.ry <= a.ry))
            return true;
        else if (a.ly == a.ry && b.ly == b.ry && a.ly == b.ly && (a.rx >= b.lx && a.rx <= b.rx || b.rx >= a.lx && b.rx <= a.rx))
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSelfCrossing(new int[]{1,1,2,2,1,1}));
    }

}