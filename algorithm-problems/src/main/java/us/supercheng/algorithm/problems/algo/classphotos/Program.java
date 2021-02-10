package us.supercheng.algorithm.problems.algo.classphotos;

import java.util.*;

public class Program {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int red = redShirtHeights.get(0);
        int blue = blueShirtHeights.get(0);

        if (red == blue)
            return false;

        boolean redTaller = red > blue;

        for (int i=1, len=redShirtHeights.size(); i<len; i++) {
            red = redShirtHeights.get(i);
            blue = blueShirtHeights.get(i);
            if (red == blue || red > blue != redTaller)
                return false;
        }

        return true;
    }
}


