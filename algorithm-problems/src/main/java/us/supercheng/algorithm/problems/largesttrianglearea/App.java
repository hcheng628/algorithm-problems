package us.supercheng.algorithm.problems.largesttrianglearea;

public class App {

    public double largestTriangleArea(int[][] points) {
        double ret = 0.0;
        for(int each=0;each<points.length;each++) {
            for(int i=each+1;i<points.length;i++) {
                for(int j=i+1;j<points.length;j++) {
                    double res = Math.abs((points[each][0]*(points[oi][1]-points[j][1])
                            + points[i][0]*(points[j][1]-points[each][1])
                            + points[j][0]*(points[each][1]-points[i][1]))) *.5;
                    if(res>ret)
                        ret = res;
                }
            }
        }
        return ret;
    }
}