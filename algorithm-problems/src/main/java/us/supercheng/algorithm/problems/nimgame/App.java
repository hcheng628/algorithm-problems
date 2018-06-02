package us.supercheng.algorithm.problems.nimgame;

public class App {

    public static void main(String[] arg) {
        App app = new App();
        System.out.println(app.canWinNim(100));
    }

    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}
