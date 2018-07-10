package us.supercheng.algorithm.problems.canplaceflowers;

public class App {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && n == 1) {
            if(flowerbed[0] == 0)
                return true;
            return false;
        }
        Integer prev = null, count = 0;
        for(int i=0;i<flowerbed.length;i++) {
            if(i != flowerbed.length - 1) {
                if((prev == null || prev == 0) && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            } else {
                if(prev == null || prev == 0 && flowerbed[i] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            }
            if(count == n)
                return true;
            prev = flowerbed[i];
        }
        return n <= count ? true :  false;
    }
}