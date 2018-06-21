package us.supercheng.algorithm.problems.heaters;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int [] houses = {1,2,3};
        int [] heaters = {2};
        PrintHelper.echoLn(new App().findRadius(houses, heaters));
        PrintHelper.echoLn(new App().findRadiusBinarySearch(houses, heaters));
        PrintHelper.echoLn(new App().findRadiusBinarySearch2(houses, heaters));
    }

    public int findRadiusBinarySearch2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = ~index;
                result = Math.max(result,
                            Math.min((index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE),
                                (index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE)));
            }
        }
        return result;
    }

    public int findRadiusBinarySearch(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for(int eachHouse : houses) {
            int index = Arrays.binarySearch(heaters, eachHouse);
            if(index < 0) {
                index *= -1;
                int toPrev = index > 1 ? eachHouse - heaters[index - 2] : Integer.MAX_VALUE;
                int toNext = index  - 1 < heaters.length ? heaters[index - 1] - eachHouse : Integer.MAX_VALUE;
                radius = Math.max(radius, Math.min(toPrev, toNext));
            }
        }
        return radius;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxCoverage = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<houses.length;i++) {
            int eachMin = Integer.MAX_VALUE;
            int tempVal = eachMin;
            if(i!=houses.length-1) {
                if(houses[i] != houses[i+1]) {
                    map = this.updateMaxCoverage(heaters, houses, i, eachMin, tempVal, map);
                    maxCoverage = Math.max(map.get(1), maxCoverage);
                }
            } else {
                map = this.updateMaxCoverage(heaters, houses, i, eachMin, tempVal, map);
                maxCoverage = Math.max(map.get(1), maxCoverage);
            }
        }
        return maxCoverage;
    }

    private Map<Integer, Integer> updateMaxCoverage(int [] heaters, int[] houses, int houseIndex, int currentMin, int tempVal, Map<Integer, Integer> inMap) {
        int startIndex = 0;
        if(inMap.get(2) != null) {
            startIndex = inMap.get(2);
        }
        for(int j=startIndex;j<heaters.length;j++) {
            if(j != heaters.length - 1) {
                if(heaters[j] != heaters[j+1]) {
                    currentMin = Math.min(Math.abs(houses[houseIndex] - heaters[j]), currentMin);
                    if(currentMin >= tempVal) {
                        inMap.put(1, currentMin);
                        inMap.put(2, --j);
                        return inMap;
                    }

                    else
                        tempVal = currentMin;
                }
            } else {
                currentMin = Math.min(Math.abs(houses[houseIndex] - heaters[j]), currentMin);
                if(currentMin >= tempVal) {
                    inMap.put(1, currentMin);
                    inMap.put(2, --j);
                    return inMap;
                }
                else
                    tempVal = currentMin;
            }
        }
        inMap.put(1, currentMin);
        inMap.put(2, 0);
        return inMap;
    }
}