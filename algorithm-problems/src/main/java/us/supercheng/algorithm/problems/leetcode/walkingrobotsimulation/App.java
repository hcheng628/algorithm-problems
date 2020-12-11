package us.supercheng.algorithm.problems.leetcode.walkingrobotsimulation;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        int[] commands = {-2,8,3,7,-1};
        int[][] obstacles ={{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        // Answer 324
        PrintHelper.echoLn("Max-Euclidean-Distance: " + new App().robotSim(commands, obstacles));
    }


    public int robotSim(int[] commands, int[][] obstacles) {
        int ret = 0, currDir = 1, currX = 0, currY = 0;
        Set<String> obstaclesSet = new HashSet<>();
        for(int i=0;i<obstacles.length;i++)
            obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);

        for(int i=0;i<commands.length;i++) {
            if(commands[i] < 0)
                currDir = this.changeDir(commands[i], currDir);
            else {
                switch(currDir) {
                    case 1:
                        currY = this.move(commands[i],currX, currY, 1, false, obstaclesSet);
                        break;
                    case 3:
                        currY = this.move(commands[i], currX, currY, -1, false, obstaclesSet);
                        break;
                    case 2:
                        currX = this.move(commands[i], currX, currY, 1, true, obstaclesSet);
                        break;
                    default:
                        currX = this.move(commands[i], currX, currY, -1, true, obstaclesSet);
                        break;

                }
                int res = currX*currX + currY*currY;
                if(res > ret)
                    ret = res;
            }
        }
        return ret;
    }

    private int move(int amount, int x, int y, int dir, boolean isMoveX, Set<String> obstaclesSet) {
        boolean canMove = true;
        for(int i=0;i<amount&&canMove;i++) {
            if(isMoveX) {
                canMove = !obstaclesSet.contains((x+dir) + "," + y);
                if(canMove)
                    x += dir;
            } else {
                canMove = !obstaclesSet.contains(x + "," + (y+dir));
                if(canMove)
                    y += dir;
            }
        }
        return isMoveX ? x : y;
    }

    private int changeDir(int change, int currDir) {
        switch (currDir) {
            case 1:
                if(change == -1)
                    return 2;
                else
                    return 4;
            case 2:
                if(change == -1)
                    return 3;
                else
                    return 1;
            case 3:
                if(change == -1)
                    return 4;
                else
                    return 2;
            default:
                if(change == -1)
                    return 1;
                else
                    return 3;
        }
    }
}
