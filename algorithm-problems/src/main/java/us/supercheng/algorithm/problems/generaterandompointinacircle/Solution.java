package us.supercheng.algorithm.problems.generaterandompointinacircle;

class Solution {

    private final double TWO_RADIUS;
    private final double RADIUS_POWER_TWO;
    private final double X;
    private final double Y;
    private final double LEFT_X;
    private final double BOT_Y;
    private double[] result;

    public Solution(double radius, double x_center, double y_center) {
        this.TWO_RADIUS = radius + radius;
        this.RADIUS_POWER_TWO = Math.pow(radius, 2);
        this.X = x_center;
        this.Y = y_center;
        this.LEFT_X = x_center - radius;
        this.BOT_Y = y_center - radius;
        this.result = new double [2];
    }

    public double[] randPoint() {
        do {
            this.result[0] = this.LEFT_X + Math.random() * this.TWO_RADIUS;
            this.result[1] = this.BOT_Y + Math.random() * this.TWO_RADIUS;
        } while (Math.pow((this.result[0] - this.X), 2) + Math.pow((this.result[1] - this.Y), 2) >    this.RADIUS_POWER_TWO);
        return result;
    }
}