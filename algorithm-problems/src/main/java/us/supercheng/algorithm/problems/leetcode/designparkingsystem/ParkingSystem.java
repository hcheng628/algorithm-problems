package us.supercheng.algorithm.problems.leetcode.designparkingsystem;

public class ParkingSystem {

    private int[] map;

    public ParkingSystem(int big, int medium, int small) {
        this.map = new int[4];
        this.map[1] = big;
        this.map[2] = medium;
        this.map[3] = small;
    }

    public boolean addCar(int carType) {
        if (this.map[carType] > 0) {
            this.map[carType]--;
            return true;
        }
        return false;
    }

}
