package us.supercheng.algorithm.problems.robotboundedincircle;

class Solution {
    private int currDir;
    private int currX;
    private int currY;

    public boolean isRobotBounded(String instructions) {
        this.currDir = 0;
        this.currX = 0;
        this.currY = 0;

        for (int dir=0;dir<4;dir++)
            for (char each : instructions.toCharArray())
                if (each == 'L') {
                    if (this.currDir == 0)
                        this.currDir = 3;
                    else
                        this.currDir--;
                } else if (each == 'R') {
                    if (this.currDir == 3)
                        this.currDir = 0;
                    else
                        this.currDir++;
                } else {
                    if (this.currDir == 0)
                        this.currY++;
                    else if (this.currDir == 1)
                        this.currX++;
                    else if (this.currDir == 2)
                        this.currY--;
                    else
                        this.currX--;
                }

        return this.currX == 0 && this.currY == 0;
    }
}