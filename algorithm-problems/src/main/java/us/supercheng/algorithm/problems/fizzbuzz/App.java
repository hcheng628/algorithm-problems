package us.supercheng.algorithm.problems.fizzbuzz;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        for(String each : app.fizzBuzz(100))
            PrintHelper.echo(each + " ");
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i % 15 == 0) {
                list.add("FizzBuzz");
            }else if(i % 3 == 0 && i > 2) {
                list.add("Fizz");
            } else if(i%5 == 0 && i > 4) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}